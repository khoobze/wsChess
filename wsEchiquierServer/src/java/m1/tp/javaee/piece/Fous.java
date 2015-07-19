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
public class Fous implements Piece, Serializable{
    private final int joueur;
    private final String symbole;
    
    public Fous (int j) {
        joueur = j;
        if ( joueur == 0 ) {
            symbole = "&#9815;";
        } else {
            symbole = "&#9821;";
        }
        
    }
    @Override
    public String getSymbole() {
        return symbole;
    }

    @Override
    public ArrayList<int[]>  getAvailableMove() {
        ArrayList<int[]> moves = new ArrayList<int[]> ();
        for (int i = 1; i < 8; i++) {
            moves.add(new int[] {i,-i});
            moves.add(new int[] {i,i});
            moves.add(new int[] {-i,-i});
            moves.add(new int[] {-i,i});
        }
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
