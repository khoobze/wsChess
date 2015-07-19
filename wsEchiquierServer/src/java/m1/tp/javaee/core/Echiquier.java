/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.tp.javaee.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import m1.tp.javaee.piece.Cavaliers;
import m1.tp.javaee.piece.Dame;
import m1.tp.javaee.piece.Fous;
import m1.tp.javaee.piece.Piece;
import m1.tp.javaee.piece.Pions;
import m1.tp.javaee.piece.Roi;
import m1.tp.javaee.piece.Tours;
import m1.tp.javaee.piece.Vide;
import java.util.Arrays;

/**
 *
 * @author mohammed
 */
public class Echiquier implements Serializable {

    protected Piece[][] pieces = new Piece[8][8];
    protected ArrayList<String> historique = new ArrayList<>();
    protected int id = -1;
    protected int joueur = 0;

    public ArrayList<String> getHistorique() {
        return historique;
        
    }

    public void setHistorique(String h) {
        
      /*  if (h.length()>3) {
            String[] bb = h.split(";");
            for(int i = 0; i< bb.length ; i++) {
                historique.add(bb[i]);
            }
        }*/
    }

    public String serializeHistorique() {
        String h = "";
       /* for (String s : historique) {
            h += s + ";";
        }*/
        return h;
    }

    public void setId(int i) {
        id = i;
    }

    public int getId() {
        return id;
    }

    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    public int getJoueur() {
        return joueur;
    }

    public Piece getPiece(int[] crd) {
        return pieces[crd[0]][crd[1]];
    }

    public void initialise() {
        joueur = 0;
        pieces[0][0] = new Tours(0);
        pieces[0][1] = new Cavaliers(0);
        pieces[0][2] = new Fous(0);
        pieces[0][3] = new Roi(0);
        pieces[0][4] = new Dame(0);
        pieces[0][5] = new Fous(0);
        pieces[0][6] = new Cavaliers(0);
        pieces[0][7] = new Tours(0);
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    pieces[i][j] = new Pions(0);
                } else if (i == 6) {
                    pieces[i][j] = new Pions(1);
                } else {
                    pieces[i][j] = new Vide();
                }
            }
        }
        pieces[7][0] = new Tours(1);
        pieces[7][1] = new Cavaliers(1);
        pieces[7][2] = new Fous(1);
        pieces[7][3] = new Roi(1);
        pieces[7][4] = new Dame(1);
        pieces[7][5] = new Fous(1);
        pieces[7][6] = new Cavaliers(1);
        pieces[7][7] = new Tours(1);
        historique.add("Debut de la Partie");
    }

    public ArrayList<int[]> getAvailableMove(int[] position) {
        Piece p = pieces[position[0]][position[1]];
        Logger.getLogger(Echiquier.class.getName()).log(Level.INFO, null, "|------> Piece: " + p.getClass().getSimpleName() + " Joueur: " + p.getJoueur());

        ArrayList<int[]> move = p.getAvailableMove();
        int x = 0, y = 1;
        if (move != null) {
            for (Iterator<int[]> iterator = move.iterator(); iterator.hasNext();) {
                int[] mv = iterator.next();
                mv[x] += position[0];
                mv[y] += position[1];
                Logger.getLogger(Echiquier.class.getName()).log(Level.INFO, null, "Traitement  " + (mv[y]) + " " + (mv[x]));
                if ((mv[x] >= 8) | (mv[x] < 0) | (mv[y] >= 8) | (mv[y] < 0)) {
                    Logger.getLogger(Echiquier.class.getName()).log(Level.INFO, null, "++Remove " + (mv[y]) + " " + (mv[x]));
                    iterator.remove();
                } else if (pieces[mv[x]][mv[y]].isPiece() && pieces[mv[x]][mv[y]].getJoueur() == joueur) {
                    Logger.getLogger(Echiquier.class.getName()).log(Level.INFO, null, "**Remove " + (mv[y]) + " " + (mv[x]));
                    iterator.remove();
                }
            }
        }
        return move;
    }

    public void changeJoueur() {
        joueur = (joueur + 1) % 2;
    }

    public void movePiece(int[] from, int[] to) {
        pieces[to[0]][to[1]] = pieces[from[0]][from[1]];
        pieces[from[0]][from[1]] = new Vide();
        String from_str = Character.toChars(from[1] + 97)[0] + "" + Character.toChars(from[0] + 49)[0];
        String to_str = Character.toChars(to[1] + 97)[0] + "" + Character.toChars(to[0] + 49)[0];
        historique.add(from_str + "->" + to_str);
    }

    public void fromString(String str) {
        String[] c = str.split(";");
        int x = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String[] cc = c[x].split(":");
                switch (cc[0]) {
                    case "Vide":
                        pieces[i][j] = new Vide();
                        break;
                    case "Pions":
                        pieces[i][j] = new Pions(Integer.parseInt(cc[1]));
                        break;
                    case "Tours":
                        pieces[i][j] = new Tours(Integer.parseInt(cc[1]));
                        break;
                    case "Cavaliers":
                        pieces[i][j] = new Cavaliers(Integer.parseInt(cc[1]));
                        break;
                    case "Dame":
                        pieces[i][j] = new Dame(Integer.parseInt(cc[1]));
                        break;
                    case "Fous":
                        pieces[i][j] = new Fous(Integer.parseInt(cc[1]));
                        break;
                    case "Roi":
                        pieces[i][j] = new Roi(Integer.parseInt(cc[1]));
                        break;
                }
                x++;
            }
        }
    }

    public ArrayList<String> getAllPiece() {
        ArrayList<String> allPiece = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                allPiece.add(pieces[i][j].getSymbole());
            }
        }
        return allPiece;
    }
}
