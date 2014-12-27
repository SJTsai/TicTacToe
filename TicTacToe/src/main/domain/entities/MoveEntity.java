package main.domain.entities;

import java.awt.Point;

public class MoveEntity {

  private TicTacToePieceEntity piece;
  private Point pointToTake;
  
  public MoveEntity(TicTacToePieceEntity piece, Point pointToTake) {
    this.piece = piece;
    this.pointToTake = pointToTake;
  }
  
  public TicTacToePieceEntity getPiece() {
    return piece;
  }
  
  public Point getPoint() {
    return pointToTake;
  }
  
  public boolean isForXPiece() {
    return piece == TicTacToePieceEntity.X;
  }
  
  public boolean isForOPiece() {
    return piece == TicTacToePieceEntity.O;
  }
  
  public boolean isForPoint(Point point) {
    return pointToTake.equals(point);
  }
}
