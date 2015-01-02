package main.domain.models.mappers;

import main.domain.entities.TicTacToePieceEntity;
import main.domain.models.TicTacToePiece;

public class TicTacToePieceMapper {

  public TicTacToePiece mapTicTacToePieceEntity(TicTacToePieceEntity pieceEntity) {
    return pieceEntity == TicTacToePieceEntity.X ? TicTacToePiece.X : TicTacToePiece.O;
  }
}
