package org.mrstm;

import org.mrstm.enums.PieceType;
import org.mrstm.factories.piece.Circle;
import org.mrstm.factories.piece.Cross;
import org.mrstm.factories.piece.PieceFactory;
import org.mrstm.models.Board;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle player1 = (Circle) PieceFactory.get(PieceType.O);
        Cross player2 = (Cross) PieceFactory.get(PieceType.X);
        Board board = new Board(3, player1, player2);

        GameManager gm = new GameManager(board);

        gm.draw(player1 , 0, 0);
        gm.draw(player2  , 0, 1);

        gm.draw(player1 , 1, 1);
        gm.draw(player2  , 0, 2);

        gm.draw(player1 , 2, 2);

    }
}