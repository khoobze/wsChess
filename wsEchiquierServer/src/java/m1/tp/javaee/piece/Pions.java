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
public class Pions  implements Piece, Serializable{
    private final int joueur;
    private final String symbole;
    
    public Pions (int j) {
        joueur = j;
        if ( joueur == 0 ) {
            symbole = "&#9817;";
        } else {
            symbole = "&#9823;";
        }
        
    }
    @Override
    public String getSymbole() {
        return symbole;
    }

    @Override
    public ArrayList<int[]> getAvailableMove() {
        ArrayList<int[]> moves = new ArrayList<>();
        if ( joueur == 0 ) {
             moves.add(new int[]{1,0});
             moves.add(new int[]{2,0});
             moves.add(new int[]{1,1});
             moves.add(new int[]{1,-1});
        } else {
             moves.add(new int[]{-1,0});
            moves.add(new int[]{-2,0});
            moves.add(new int[]{-1,1});
            moves.add(new int[]{-1,-1});
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