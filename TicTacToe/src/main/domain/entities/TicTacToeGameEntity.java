package main.domain.entities;

import java.awt.Point;

import main.domain.keepers.interfaces.TurnKeeper;

public class TicTacToeGameEntity {

  private TicTacToeBoardEntity board;
  private TurnKeeper turnKeeper;
  
  public TicTacToeGameEntity(TurnKeeper turnKeeper) {
    board = new TicTacToeBoardEntity();
    this.turnKeeper = turnKeeper;
  }
  
  public void addPieceToPointForCurrentPlayer(Point pointToTake) {
    MoveEntity move = new MoveEntity(turnKeeper.getPieceForCurrentPlayer(), pointToTake);
    board.addMove(move);
  }
  
  public TicTacToeBoardEntity getBoard() {
    return new TicTacToeBoardEntity(board);
  }
  
  public TicTacToePlayerEntity getCurrentPlayer() {
    return turnKeeper.getCurrentPlayer();
  }
}
