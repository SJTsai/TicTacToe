package main.domain.models.mappers;

import main.domain.entities.TicTacToeBoardEntity;
import main.domain.models.TicTacToeBoard;

public class TicTacToeBoardMapper {

  public TicTacToeBoard mapTicTacToeBoardEntity(TicTacToeBoardEntity boardEntity) {
    TicTacToeBoard boardModel = new TicTacToeBoard();
    boardModel.setNumberOfRows(boardEntity.getNumberOfRows());
    boardModel.setNumberOfColumns(boardEntity.getNumberOfColumns());
    boardModel.setXPoints(boardEntity.getXPointsClone());
    boardModel.setOPoints(boardEntity.getOPointsClone());
    return boardModel;
  }
}
