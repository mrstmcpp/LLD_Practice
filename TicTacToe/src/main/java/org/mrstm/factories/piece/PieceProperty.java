package org.mrstm.factories.piece;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.mrstm.enums.PieceType;

@Getter
@Setter
@AllArgsConstructor
public abstract class PieceProperty {
    private PieceType pieceType;
}
