package org.mrstm.factories.piece;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.PieceType;

@Getter
@Builder
@Setter
public class Cross extends PieceProperty implements Piece{
    public Cross(){
        super(PieceType.X);
    }
    @Override
    public PieceType getInstance() {
        return getPieceType();
    }
}
