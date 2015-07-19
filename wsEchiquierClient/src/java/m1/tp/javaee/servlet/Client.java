/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.tp.javaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import m1.tp.javaee.webservice.server.RequestHandler;
import m1.tp.javaee.webservice.server.RequestHandler_Service;

/**
 *
 * @author mohammed
 */
@WebServlet(name = "Client", urlPatterns = {"/Client"})
public class Client extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if ((request.getAttribute("ajax") == null) || ((Boolean) request.getAttribute("ajax") == false)) {
                request.getRequestDispatcher("Echiquier.jsp").include(request, response);
            } else {
                response.setContentType("application/json");
                try (PrintWriter out = response.getWriter()) {
                    out.println(request.getAttribute("response"));
                }
            } 

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        int id = 0;
        switch (op) {
            case "New":
                request.getSession().setAttribute("id", createEchiquier());
                request.getSession().setAttribute("joueur", 0);
                request.getSession().setAttribute("adversaire", "En attente");
                request.setAttribute("currentJoueur", getJoueur((int) request.getSession().getAttribute("id")));
                request.setAttribute("echiquier", getEchiquier((int) request.getSession().getAttribute("id")));
                break;
            case "Load":
                id = this.loadEchiquier(Integer.parseInt(request.getParameter("id")));
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("joueur", 0);
                request.getSession().setAttribute("adversaire", "En attente");
                request.setAttribute("currentJoueur", getJoueur((int) request.getSession().getAttribute("id")));
                request.setAttribute("echiquier", getEchiquier((int) request.getSession().getAttribute("id")));
                //request.setAttribute("historique", getHistorique(id));
                break;
            case "Join":
                id = this.joinEchiquier(Integer.parseInt(request.getParameter("id")));
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("joueur", 1);
                request.getSession().setAttribute("adversaire", "En attente");
                request.setAttribute("currentJoueur", getJoueur((int) request.getSession().getAttribute("id")));
                request.setAttribute("echiquier", getEchiquier((int) request.getSession().getAttribute("id")));
                //request.setAttribute("historique", getHistorique(id));
                break;
            case "Move":
                if (Integer.parseInt(request.getParameter("currentJoueur")) == (Integer) request.getSession().getAttribute("joueur")) {
                    this.movePiece((int) request.getSession().getAttribute("id"), request.getParameter("from"), request.getParameter("to"));
                }
                request.setAttribute("currentJoueur", getJoueur((int) request.getSession().getAttribute("id")));
                request.setAttribute("echiquier", getEchiquier((int) request.getSession().getAttribute("id")));
                // request.setAttribute("historique", getHistorique(id));
                break;
            case "Save":
                this.saveEchiquier((int) request.getSession().getAttribute("id"));
                request.setAttribute("currentJoueur", getJoueur((int) request.getSession().getAttribute("id")));
                request.setAttribute("echiquier", getEchiquier((int) request.getSession().getAttribute("id")));
                break;
            case "getParties":
                request.setAttribute("ajax", true);
                request.setAttribute("response", "{\"Parties\":" + this.getParties().toString() + "}");
                break;
            case "joinParties":
                request.setAttribute("ajax", true);
                request.setAttribute("response", "{\"Parties\":" + this.joinParties().toString() + "}");
                break;
            case "checkUpdate":
                boolean stat = checkUpdate(Integer.parseInt(request.getParameter("currentJoueur")), (int) request.getSession().getAttribute("id"));
                request.setAttribute("ajax", true);
                request.setAttribute("response", "{\"Update\":" + stat + "}");
                break;
            case "refresh":
                request.setAttribute("currentJoueur", getJoueur((int) request.getSession().getAttribute("id")));
                request.setAttribute("echiquier", getEchiquier((int) request.getSession().getAttribute("id")));
                //request.setAttribute("historique", getHistorique((int) request.getSession().getAttribute("id")));
                break;
            case "exit":
                removeEchiquier((int) request.getSession().getAttribute("id"));
                request.getSession().setAttribute("id", null);
                request.setAttribute("exit", true);
                break;
            default:
                request.getSession().setAttribute("id", -1);
                request.getSession().setAttribute("adversaire", "En attente");
                request.getSession().setAttribute("joueur", -1);
                request.setAttribute("currentJoueur", -1);
                request.setAttribute("echiquier", null);

        }
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public int createEchiquier() {
        RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.createEchiquier();
    }

    public int getJoueur(int id) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.getJoueur(id);
    }

    public int loadEchiquier(int id) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.loadEchiquier(id);
    }

    public int joinEchiquier(int id) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.joinEchiquier(id);
    }

    public List<String> getEchiquier(int id) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.getEchiquier(id);
    }

    public boolean saveEchiquier(int id) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.saveEchiquier(id);
    }

    public boolean removeEchiquier(int id) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.removePartie(id);
    }

    public boolean movePiece(int id, String from, String to) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.movePiece(id, from, to);
    }

    public List<Integer> getParties() {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.getParties();
    }

    public List<Integer> joinParties() {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.joinParties();
    }

    public List<Integer> refresh(int id) {
        return getParties();
    }

    /**
     *
     * @param userId
     * @return
     */
    public List<String> getHistorique(int userId) {
        m1.tp.javaee.webservice.server.RequestHandler_Service rh_service = new m1.tp.javaee.webservice.server.RequestHandler_Service();
        RequestHandler rh = rh_service.getRequestHandlerPort();
        return rh.getHistorique(userId);
    }

    public boolean checkUpdate(int currentJoueur, int id) {
        // vérifier si le joueur a changé charger l'echequier 
        return currentJoueur == getJoueur(id);
    }
}
