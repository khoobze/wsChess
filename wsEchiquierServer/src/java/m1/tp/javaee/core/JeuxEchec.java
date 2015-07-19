/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.tp.javaee.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohammed
 */
public class JeuxEchec {
    
   // protected 
    protected  Map<Integer, Echiquier> echiquiers = new HashMap<>();
    protected ArrayList<Integer> echiquiersLibre = new ArrayList<>();
    protected int nbrJoueur = 0;
    public JeuxEchec() {}

    
    public int[] getCoordonnee(String position) {
        if (position.length() != 2) {
            return null;
        }
        position = position.toLowerCase();
        int[] crd = new int[2];
        crd[1] = position.charAt(0) - 97;
        crd[0] = position.charAt(1) - 49;
        if (crd[0] >= 0 && crd[0] < 8 && crd[1] >= 0 && crd[1] < 8) {
            return crd;
        }
        return null;
    }
    
    public void move(int userId, String from, String to) {
        int[] from_crd = getCoordonnee(from);
        int[] to_crd = getCoordonnee(to);
         Logger.getLogger(JeuxEchec.class.getName()).log(Level.INFO, null, "|------> Piece: " + echiquiers.get(userId).getPiece(from_crd).getClass().getSimpleName() + " Joueur: " + echiquiers.get(userId).getPiece(from_crd).getJoueur());
         if (echiquiers.get(userId).getPiece(from_crd).isPiece() && echiquiers.get(userId).getPiece(from_crd).getJoueur() == echiquiers.get(userId).getJoueur()) {
            ArrayList<int[]> t = echiquiers.get(userId).getAvailableMove(from_crd);
            for (int[] next : t) {
                if (Arrays.equals(next, to_crd)) {
                    echiquiers.get(userId).movePiece(from_crd, to_crd);
                    System.out.println("Move");
                    break;
                }
            }
        }
        echiquiers.get(userId).changeJoueur();
    }
  
    
    public String toString(int userId) {
        String table = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table += echiquiers.get(userId).getPiece(new int[]{i, j}).getClass().getSimpleName() + ":" + echiquiers.get(userId).getPiece(new int[]{i, j}).getJoueur() + ";";
            }
        }
        return table.substring(0, table.length()-1);
    }
    
    
    public void setJoueur(int userId, int joueur) {
        echiquiers.get(userId).setJoueur(joueur);
    }
    
    
    public int getJoueur(int userId) {
        if(echiquiers.get(userId)!=null)
            return echiquiers.get(userId).getJoueur();
        else
            return -1;
    }
    
    
    public int fromString(String str) {
        nbrJoueur++;
        Echiquier echiquier_ = new Echiquier();
        echiquier_.fromString(str);
        echiquiers.put(nbrJoueur, echiquier_);
        return nbrJoueur;
    }
    
    
    public void addPartieLibre(int id) { 
        if(!echiquiersLibre.contains(id))
            echiquiersLibre.add(id);
    }
    public void removePartieLibre(int id) { 
        if(echiquiersLibre.contains(id))
            echiquiersLibre.remove(id);
    }
    
    public ArrayList<String> getAllPiece(int userId) {
        return echiquiers.get(userId).getAllPiece();
    }

    
    public int createEchiquier() {
        nbrJoueur++;
        echiquiers.put(nbrJoueur, new Echiquier());
        echiquiers.get(nbrJoueur).initialise();
        return nbrJoueur;
    }
    
    
    public ArrayList<Integer> joinParties() {        
        return echiquiersLibre;
    }
    
    
    public void linkUser(int userId, int id) {
     echiquiers.get(userId).setId(id);
    }
    
    public int getUserid(int id) {
        Iterator iterator = echiquiers.entrySet().iterator();
	while (iterator.hasNext()) {
                Map.Entry mapEntry = (Map.Entry) iterator.next();
		Echiquier ec = (Echiquier) mapEntry.getValue();
                if(ec.getId() == id)
                    return (int) mapEntry.getKey();
	}
        return -1;
    }
    public int getId(int userId) {
        return echiquiers.get(userId).getId();
    }
     public ArrayList<String> getHistorique(int userId) {
        return echiquiers.get(userId).getHistorique();
    }
    
    public void setHistorique(int userId, String h) {
       echiquiers.get(userId).setHistorique(h);
    }
    
    public String serializeHistorique(int userId) {
        return echiquiers.get(userId).serializeHistorique();
    }
}
