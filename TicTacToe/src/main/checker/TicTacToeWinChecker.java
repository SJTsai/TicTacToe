package main.checker;

import java.awt.Point;

import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

public class TicTacToeWinChecker {
  
  private TicTacToePieceEntity referencePiece;
  private TicTacToeBoardEntity board;
  
  public boolean isWinningStateForPieceOnBoard(TicTacToePieceEntity piece, TicTacToeBoardEntity board) {
    referencePiece = piece;
    this.board = board;
    return isWinForColumn(0) || isWinForColumn(1) || isWinForColumn(2) ||
        isWinForRow(0) || isWinForRow(1) || isWinForRow(2) ||
        isWinForBackSlashDiagonal() || isWinForForwardSlashDiagonal();
  }
  
  private boolean isWinForColumn(int column) {
    for (int row = 0; row < 3; row++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(row, column));
      if (isInvalidPiece(pieceForCurrentRow))
        return false;
    }
    return true;
  }
  
  private boolean isInvalidPiece(TicTacToePieceEntity piece) {
    return piece == null || piece != referencePiece;
  }
  
  private boolean isWinForRow(int row) {
    for (int column = 0; column < 3; column++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(row, column));
      if (isInvalidPiece(pieceForCurrentRow))
        return false;
    }
    return true;
  }
  
  private boolean isWinForBackSlashDiagonal() {
    for (int rowColumn = 0; rowColumn < 3; rowColumn++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(rowColumn, rowColumn));
      if (isInvalidPiece(pieceForCurrentRow))
        return false;
    }
    return true;
  }
  
  private boolean isWinForForwardSlashDiagonal() {
    int column = 2;
    for (int row = 0; row < 3; row++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(row, column));
      if (isInvalidPiece(pieceForCurrentRow))
        return false;
      column--;
    }
    return true;
  }
}
