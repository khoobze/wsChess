/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.tp.javaee.webservice.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import m1.tp.javaee.core.JeuxEchec;

/**
 *
 * @author mohammed
 */
@WebService(serviceName = "RequestHandler")
public class RequestHandler {

    private final JeuxEchec jeu = new JeuxEchec();
    private Connection conn = null;

    protected Connection connectToBdd() {
        try {
            if (conn == null || conn.isClosed()) {
                String user = "m1tp";
                String password = "m1tp";
                String uspa = ";user=m1tp;password=m1tp";
                String bdd = "Echequier";
                String dbUrl = "derby:/home/mohammed/WorkSpace/Java/wsEchiquierServer/database/EchequierBDD";
                try {
                    Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
                    conn = DriverManager.getConnection("jdbc:" + dbUrl + uspa);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    @WebMethod(operationName = "loadEchiquier")
    public int loadEchiquier(@WebParam(name = "id") int id) {
        int userId = -1;

        conn = connectToBdd();
        if (conn == null) {
            return -4;
        }
        try {
            PreparedStatement ps = conn.prepareStatement("select Echiquier, Joueur, Historique from Jeux WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userId = jeu.fromString(rs.getString("Echiquier"));
                jeu.setJoueur(userId, rs.getInt("Joueur"));
                jeu.setHistorique(userId, rs.getString("Historique"));
            }
            ps.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return -1;
        }
        jeu.linkUser(userId, id);
        jeu.addPartieLibre(id);
        return userId;
    }

    @WebMethod(operationName = "joinEchiquier")
    public int joinEchiquier(@WebParam(name = "id") int id) {
        int userId = jeu.getUserid(id);
        //jeu.removePartieLibre(id);
        return userId;
    }

    @WebMethod(operationName = "saveEchiquier")
    public boolean saveEchiquier(@WebParam(name = "userId") int userId) {
        Connection conn = connectToBdd();
        if (conn == null) {
            return false;
        }
        try {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.INFO, null, jeu.getId(userId));
            PreparedStatement ps = conn.prepareStatement("UPDATE Jeux SET Echiquier = ?, Joueur = ?, Historique = ? WHERE id = ?");
            ps.setString(1, jeu.toString(userId));
            ps.setInt(2, jeu.getJoueur(userId));
            ps.setString(3, jeu.serializeHistorique(userId));
            ps.setInt(4, jeu.getId(userId));
            ps.executeUpdate(); 
            ps.close();           
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }finally{}
        return true;
    }

    @WebMethod(operationName = "createEchiquier")
    public int createEchiquier() {
        int id = -1;
        Connection conn = connectToBdd();
        if (conn == null) {
            return -2;
        }
        int userId = jeu.createEchiquier();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Jeux (echiquier,joueur,historique) VALUES (?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, jeu.toString(userId));
            ps.setInt(2, jeu.getJoueur(userId));
            ps.setString(3, jeu.serializeHistorique(userId));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -3;
        }
        jeu.linkUser(userId, id);
        jeu.addPartieLibre(id);
        return userId;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getEchiquier")
    public ArrayList<String> getEchiquier(@WebParam(name = "userId") int userId) {
        if (jeu == null) {
            return null;
        }
        return jeu.getAllPiece(userId);
    }

    /**
     * Web service operation
     *
     * @param from
     * @param to
     */
    @WebMethod(operationName = "movePiece")
    public boolean movePiece(@WebParam(name = "userId") int userId, @WebParam(name = "from") String from, @WebParam(name = "to") String to) {
        try {
            jeu.move(userId, from, to);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Web service operation
     *
     * @param userId
     * @return
     */
    @WebMethod(operationName = "getJoueur")
    public int getJoueur(@WebParam(name = "userId") int userId) {
        //TODO write your implementation code here:
        return jeu.getJoueur(userId);
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "getParties")
    public ArrayList<Integer> getParties() {
        ArrayList<Integer> idParties = new ArrayList<Integer>();
        ArrayList<Integer> join = jeu.joinParties();
        try {
            Connection conn;
            conn = connectToBdd();
            if (conn == null) {
                return null;
            }
            Statement us = conn.createStatement();
            ResultSet rs = us.executeQuery("SELECT id FROM Jeux ORDER BY id");
            while (rs.next()) {
                int id = rs.getInt("id");
                idParties.add(id);

            }
            us.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return null;
        }
        return idParties;
    }

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "joinParties")
    public ArrayList<Integer> joinParties() {
        return jeu.joinParties();
    }

    @WebMethod(operationName = "getHistorique")
    public ArrayList<String> getHistorique(int userId) {
        return jeu.getHistorique(userId);
    }

    @WebMethod(operationName = "removePartie")
    public boolean removePartie(int userId) {
        Connection conn = connectToBdd();
        if (conn == null) {
            return false;
        }
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Jeux WHERE id = ?");
            ps.setInt(1, jeu.getId(userId));
            ps.executeUpdate();
            
            ps.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
            
            try {
                conn.close();
            } catch (SQLException ex1) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }finally{}
        return true;
    }

    /**
     * Web service operation
     *
     * @param username
     * @param password
     * @return
     */
    @WebMethod(operationName = "login")
    public int login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        if (username != null && password != null) {
            int id = -1;
            try {
                Connection conn;
                conn = connectToBdd();
                if (conn == null) {
                    return -1;
                }
                PreparedStatement stmt = conn.prepareStatement("SELECT id FROM Users WHERE username=? and password=?");
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    return rs.getInt("id");
                }
            stmt.close();
            conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
                
                try {
                    conn.close();
                } catch (SQLException ex1) {
                    Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex1);
                }
                return -1;
            }
        }
        return -1;
    }

    /**
     * Web service operation
     *
     * @param username
     * @param password
     * @return
     */
    @WebMethod(operationName = "subscribe")
    public int subscribe(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        if (username != null && password != null) {
            Connection conn = null;
            PreparedStatement stmt = null;
            try {
                conn = connectToBdd();
                if (conn == null) {
                    return -1;
                }
                Statement us = conn.createStatement();
                PreparedStatement stmt1 = conn.prepareStatement("SELECT id FROM Users WHERE username=?");
                stmt1.setString(1, username);
                ResultSet rs = stmt1.executeQuery();
                if (rs.next()) {
                    return -1;
                }
                stmt = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, username);
                stmt.setString(2, password);
                stmt.executeUpdate();
                rs = stmt.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    return rs.getInt(1);
                }
            stmt.close();
            conn.close();
            } catch (Exception e) {
                Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, e);

                if (stmt != null) {
                    try {
                        stmt.close();
                        
                      conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(RequestHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                return -1;
            }
        }
        return -1;
    }
}
