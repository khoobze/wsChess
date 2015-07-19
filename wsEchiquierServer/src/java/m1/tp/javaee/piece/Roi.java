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
public class Roi implements Piece, Serializable {
    private final int joueur;
    private final String symbole;   
    
    public Roi(int j) {
        joueur = j;
        if( joueur == 0 ) {
            symbole = "&#9812;";
        } else {
            symbole = "&#9818;";
        }
        
    }
    @Override
    public String getSymbole() {
        return symbole;
    }
    @Override
    public ArrayList<int[]> getAvailableMove() {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        moves.add(new int[] {1,0});
        moves.add(new int[] {1,1});
        moves.add(new int[] {0,1});
        moves.add(new int[] {-1,1});
        moves.add(new int[] {-1,0});
        moves.add(new int[] {-1,-1});
        moves.add(new int[] {0,-1});
        moves.add(new int[] {1,-1});
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
