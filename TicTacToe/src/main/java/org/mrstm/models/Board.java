package org.mrstm.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.PieceType;
import org.mrstm.factories.piece.Piece;

@Getter
@Setter
public class Board {
    private final int size;
    private final Piece player1;
    private final Piece player2;
    private PieceType[][] playground;
    private Piece lastPlayer;

    public Board(int size, Piece player1, Piece player2) {
        this.size = size;
        this.player1 = player1;
        this.player2 = player2;
        this.playground = new PieceType[size][size];
    }

}
