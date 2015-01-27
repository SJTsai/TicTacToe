package main.players;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

public class TicTacToePlayer {
  
  private TicTacToeBoardEntity board;
  private TicTacToePieceEntity piece;
  private boolean isComputer;
  
  public TicTacToePlayer(TicTacToePieceEntity piece, TicTacToeBoardEntity board, boolean isComputer) {
    this.board = board;
    this.piece = piece;
    this.isComputer = isComputer;
  }
  
  public TicTacToePieceEntity getPiece() {
    return piece;
  }
  
  public boolean isComputer() {
    return isComputer;
  }
  
  public void makeMoveAtPoint(Point point) {
    board.addMove(new MoveEntity(piece, point));
  }
}
