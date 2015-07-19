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
public class Tours implements Piece, Serializable{
    private final int joueur;
    private final String symbole;
    
    public Tours (int j) {
        joueur = j;
        if ( joueur == 0 ) {
            symbole = "&#9814;";
        } else {
            symbole = "&#9820;";
        }
        
    }
    @Override
    public String getSymbole() {
        return symbole;
    }

    @Override
    public ArrayList<int[]> getAvailableMove() {
       ArrayList<int[]> moves = new ArrayList<int[]>();
        int x = 0, y = 1;      
        for (int i = 1; i < 8; i++) {
            moves.add(new int[] {0,i });
            moves.add(new int[] {0,-i});
            moves.add(new int[] {-i,0});
            moves.add(new int[] {+i,0}); 
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

