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
public class Vide  implements Piece, Serializable{

    @Override
    public String getSymbole() {
        return "&nbsp;";
    }

    @Override
    public ArrayList<int[]>  getAvailableMove() {
       ArrayList<int[]> moves = new ArrayList<int[]>();
        moves.add(new int[] {0,0});
        return moves;
    }
    @Override
    public int getJoueur() {
        return -1;
    }   

    @Override
    public boolean isPiece() {
    return false;
    }
}
