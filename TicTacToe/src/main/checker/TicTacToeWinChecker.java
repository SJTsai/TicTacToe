package main.checker;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

public class TicTacToeWinChecker {
  
  private TicTacToePieceEntity referencePiece;
  private TicTacToeBoardEntity board;
  
  public boolean isWinningStateForMoveOnBoard(MoveEntity move, TicTacToeBoardEntity board) {
    referencePiece = move.getPiece();
    this.board = board;
    
    boolean isWinForColumn = isWinForColumn(move.getPoint().y);
    boolean isWinForRow = isWinForRow(move.getPoint().x);
    
    boolean isWinForBackSlashDiagonal = false;
    if (doesMoveContainPointForBackSlashDiagonal(move))
      isWinForBackSlashDiagonal = isWinForBackSlashDiagonal();
    
    boolean isWinForForwardSlashDiagonal = false;
    if (doesMoveContainPointForForwardSlashDiagonal(move))
      isWinForForwardSlashDiagonal = isWinForForwardSlashDiagonal();
    
    return isWinForColumn || isWinForRow || isWinForBackSlashDiagonal || isWinForForwardSlashDiagonal;
  }
  
  private boolean isWinForColumn(int column) {
    for (int row = 0; row < 3; row++)
      if (!board.isPieceAtPointEqualToPiece(new Point(row, column), referencePiece))
        return false;
    return true;
  }
  
  private boolean isWinForRow(int row) {
    for (int column = 0; column < 3; column++)
      if (!board.isPieceAtPointEqualToPiece(new Point(row, column), referencePiece))
        return false;
    return true;
  }
  
  private boolean doesMoveContainPointForBackSlashDiagonal(MoveEntity move) {
    return move.getPoint().equals(new Point(0, 0)) || move.getPoint().equals(new Point(2, 2)) || move.getPoint().equals(new Point(1, 1));
  }
  
  private boolean isWinForBackSlashDiagonal() {
    for (int rowColumn = 0; rowColumn < 3; rowColumn++)
      if (!board.isPieceAtPointEqualToPiece(new Point(rowColumn, rowColumn), referencePiece))
        return false;
    return true;
  }
  
  private boolean doesMoveContainPointForForwardSlashDiagonal(MoveEntity move) {
    return move.getPoint().equals(new Point(0, 2)) || move.getPoint().equals(new Point(2, 0)) || move.getPoint().equals(new Point(1, 1));
  }
  
  private boolean isWinForForwardSlashDiagonal() {
    int column = 2;
    for (int row = 0; row < 3; row++) {
      if (!board.isPieceAtPointEqualToPiece(new Point(row, column), referencePiece))
        return false;
      column--;
    }
    return true;
  }
}
