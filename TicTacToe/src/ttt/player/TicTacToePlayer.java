package ttt.player;

import java.awt.Point;

import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;

public class TicTacToePlayer {
  
  private TicTacToeBoard board;
  private TicTacToePiece piece;
  private boolean isComputer;
  
  public TicTacToePlayer(TicTacToePiece piece, TicTacToeBoard board, boolean isComputer) {
    this.board = board;
    this.piece = piece;
    this.isComputer = isComputer;
  }
  
  public TicTacToePiece getPiece() {
    return piece;
  }
  
  public boolean isComputer() {
    return isComputer;
  }
  
  public void makeMoveAtPoint(Point point) {
    board.addMove(new Move(piece, point));
  }
}
