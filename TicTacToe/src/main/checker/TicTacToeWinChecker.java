package main.checker;

import java.awt.Point;

import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

public class TicTacToeWinChecker {
  
  private TicTacToePieceEntity referencePiece;
  
  public boolean isWinningStateForPieceOnBoard(TicTacToePieceEntity piece, TicTacToeBoardEntity board) {
    referencePiece = piece;
    return isWinForColumnOnBoard(0, board) || isWinForColumnOnBoard(1, board) || isWinForColumnOnBoard(2, board) ||
        isWinForRowOnBoard(0, board) || isWinForRowOnBoard(1, board) || isWinForRowOnBoard(2, board) ||
        isWinForBackSlashDiagonal(board) || isWinForForwardSlashDiagonal(board);
  }
  
  private boolean isWinForColumnOnBoard(int column, TicTacToeBoardEntity board) {
    for (int row = 0; row < 2; row++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(row, column));
      TicTacToePieceEntity pieceForNextRow = board.getPieceForPoint(new Point(row + 1, column));
      if (isInvalidSetOfPieces(pieceForCurrentRow, pieceForNextRow))
        return false;
    }
    return true;
  }
  
  private boolean isInvalidSetOfPieces(TicTacToePieceEntity piece1, TicTacToePieceEntity piece2) {
    return piece1 != referencePiece || piece2 != referencePiece || piece1 == null || piece2 == null || piece1 != piece2;
  }
  
  private boolean isWinForRowOnBoard(int row, TicTacToeBoardEntity board) {
    for (int column = 0; column < 2; column++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(row, column));
      TicTacToePieceEntity pieceForNextRow = board.getPieceForPoint(new Point(row, column + 1));
      if (isInvalidSetOfPieces(pieceForCurrentRow, pieceForNextRow))
        return false;
    }
    return true;
  }
  
  private boolean isWinForBackSlashDiagonal(TicTacToeBoardEntity board) {
    for (int rowColumn = 0; rowColumn < 2; rowColumn++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(rowColumn, rowColumn));
      TicTacToePieceEntity pieceForNextRow = board.getPieceForPoint(new Point(rowColumn + 1, rowColumn + 1));
      if (isInvalidSetOfPieces(pieceForCurrentRow, pieceForNextRow))
        return false;
    }
    return true;
  }
  
  private boolean isWinForForwardSlashDiagonal(TicTacToeBoardEntity board) {
    int column = 2;
    for (int row = 0; row < 2; row++) {
      TicTacToePieceEntity pieceForCurrentRow = board.getPieceForPoint(new Point(row, column));
      TicTacToePieceEntity pieceForNextRow = board.getPieceForPoint(new Point(row + 1, column - 1));
      if (isInvalidSetOfPieces(pieceForCurrentRow, pieceForNextRow))
        return false;
      column--;
    }
    return true;
  }
}
