package org.mrstm.factories.piece;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.PieceType;

@Getter
@Builder
@Setter
public class Circle extends PieceProperty implements Piece{
    public Circle() {
        super(PieceType.O);
    }

    @Override
    public PieceType getInstance() {
        return getPieceType();
    }
}
