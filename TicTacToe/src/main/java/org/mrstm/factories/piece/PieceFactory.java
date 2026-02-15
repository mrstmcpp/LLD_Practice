package org.mrstm.factories.piece;

import org.mrstm.enums.PieceType;

public class PieceFactory {
    public static Piece get(PieceType pieceType){
        switch (pieceType){
            case X -> {return new Cross();}
            case O -> {return new Circle();}
        }
        return null;
    }
}
