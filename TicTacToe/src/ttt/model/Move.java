package ttt.model;

import java.awt.Point;

public class Move {

  private TicTacToePiece piece;
  private Point pointToTake;
  
  public Move(TicTacToePiece piece, Point pointToTake) {
    this.piece = piece;
    this.pointToTake = pointToTake;
  }
  
  public TicTacToePiece getPiece() {
    return piece;
  }
  
  public Point getPoint() {
    return pointToTake;
  }
  
  public boolean isForXPiece() {
    return piece == TicTacToePiece.X;
  }
  
  public boolean isForOPiece() {
    return piece == TicTacToePiece.O;
  }
  
  public boolean isForPoint(Point point) {
    return pointToTake.equals(point);
  }
}
