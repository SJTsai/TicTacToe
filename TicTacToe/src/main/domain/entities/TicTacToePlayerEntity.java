package main.domain.entities;

public class TicTacToePlayerEntity {

  private TicTacToePieceEntity piece;
  private boolean isComputer;
  
  public TicTacToePlayerEntity(TicTacToePieceEntity piece, boolean isComputer) {
    this.piece = piece;
    this.isComputer = isComputer;
  }
  
  public TicTacToePieceEntity getPiece() {
    return piece;
  }
  
  public boolean isXPlayer() {
    return getPiece() == TicTacToePieceEntity.X;
  }
  
  public boolean isOPlayer() {
    return getPiece() == TicTacToePieceEntity.O;
  }
  
  public boolean isComputer() {
    return isComputer;
  }
}
