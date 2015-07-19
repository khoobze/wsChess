/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.tp.javaee.piece;

import java.util.ArrayList;

/**
 *
 * @author mohammed
 */
public interface Piece {
    public String getSymbole();

    /**
     *  get Available Move
     * @return x,y array
     */
    public ArrayList<int[]> getAvailableMove();
    public int getJoueur();
    public boolean isPiece();
}
