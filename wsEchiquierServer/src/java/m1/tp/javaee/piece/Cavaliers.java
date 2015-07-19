/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.tp.javaee.piece;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mohammed
 */
public class Cavaliers  implements Piece, Serializable {
    private int joueur;
    private String symbole;   

    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
    

    public Cavaliers(int j) {
        joueur = j;
        if( joueur == 0 ) {
            symbole = "&#9816;";
        } else {
            symbole = "&#9822;";
        }
        
    }

    @Override
    public String toString() {
        return "Cavaliers [" + "joueur=" + joueur + ", symbole=" + symbole + ']';
    }
    @Override
    public String getSymbole() {
        return symbole;
    }
    @Override
    public ArrayList<int[]> getAvailableMove() {
        ArrayList<int[]> moves;
        moves = new ArrayList<>();
        moves.add(new int[] {1,2});
        moves.add(new int[] {-1,2});
        moves.add(new int[] {1,-2});
        moves.add(new int[] {-1,-2});
        moves.add(new int[] {2,1});
        moves.add(new int[] {-2,1});
        moves.add(new int[] {2,-1});
        moves.add(new int[] {-2,-1});
        return moves;
    }
      @Override
    public int getJoueur() {
        return joueur;
    } 

    @Override
    public boolean isPiece() {
       return true;
    }
}
