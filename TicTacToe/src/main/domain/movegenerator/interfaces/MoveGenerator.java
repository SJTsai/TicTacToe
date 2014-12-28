package main.domain.movegenerator.interfaces;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

public interface MoveGenerator {

  public MoveEntity getBestMoveForBoardAndCurrentPieceToPlay(TicTacToeBoardEntity board, TicTacToePieceEntity pieceToPlay);
}
