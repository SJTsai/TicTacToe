package main.domain.verification;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.verification.interfaces.CheckRowColumnVerifier;
import main.domain.verification.interfaces.WinnerVerifier;

public class DefaultWinnerVerifier implements WinnerVerifier {
  
  private TicTacToeBoardEntity board;
  private CheckRowColumnVerifier checkRowColumnVerifier;
  private TicTacToePieceEntity lastPieceAdded;
  
  public DefaultWinnerVerifier(TicTacToeBoardEntity board, CheckRowColumnVerifier checkRowColumnVerifier) {
    this.board = board;
    this.checkRowColumnVerifier = checkRowColumnVerifier;
  }

  @Override
  public boolean verifyWinForBoardAndLastMoveMade(MoveEntity lastMoveMade) {
    this.lastPieceAdded = lastMoveMade.getPiece();
    
    boolean isWin = false;
    
    if (checkRowColumnVerifier.shouldCheckWinForFirstRowForMove(lastMoveMade))
      isWin = isWin || isWinForFirstRow();
    
    if (checkRowColumnVerifier.shouldCheckWinForFirstColumnForMove(lastMoveMade))
      isWin = isWin || isWinForFirstColumn();
    
    if (checkRowColumnVerifier.shouldCheckWinForSecondRowForMove(lastMoveMade))
      isWin = isWin || isWinForSecondRow();
    
    if (checkRowColumnVerifier.shouldCheckWinForSecondColumnForMove(lastMoveMade))
      isWin = isWin || isWinForSecondColumn();
    
    if (checkRowColumnVerifier.shouldCheckWinForThirdRowForMove(lastMoveMade))
      isWin = isWin || isWinForThirdRow();
    
    if (checkRowColumnVerifier.shouldCheckWinForThirdColumnForMove(lastMoveMade))
      isWin = isWin || isWinForThirdColumn();
    
    if (checkRowColumnVerifier.shouldCheckWinForBackSlashDiagonalForMove(lastMoveMade))
      isWin = isWin || isWinForBackSlashDiagonal();
    
    if (checkRowColumnVerifier.shouldCheckWinForForwardSlashDiagonalForMove(lastMoveMade))
      isWin = isWin || isWinForForwardSlashDiagonal();
    
    return isWin;
  }
  
  private boolean isWinForFirstRow() {
    boolean isWin = true;
    List<Point> pointsForFirstRow = getPointsForFirstRow();
    for (Point pointInFirstRow : pointsForFirstRow)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInFirstRow, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForFirstRow() {
    List<Point> pointsForFirstRow = new ArrayList<Point>();
    for (int column = 0; column < board.getNumberOfColumns(); column++)
      pointsForFirstRow.add(new Point(0, column));
    return pointsForFirstRow;
  }
  
  private boolean isWinForFirstColumn() {
    boolean isWin = true;
    List<Point> pointsForFirstColumn = getPointsForFirstColumn();
    for (Point pointInFirstColumn : pointsForFirstColumn)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInFirstColumn, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForFirstColumn() {
    List<Point> pointsForFirstColumn = new ArrayList<Point>();
    for (int row = 0; row < board.getNumberOfRows(); row++)
      pointsForFirstColumn.add(new Point(row, 0));
    return pointsForFirstColumn;
  }
  
  private boolean isWinForSecondRow() {
    boolean isWin = true;
    List<Point> pointsForSecondRow = getPointsForSecondRow();
    for (Point pointInSecondRow : pointsForSecondRow)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInSecondRow, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForSecondRow() {
    List<Point> pointsForSecondRow = new ArrayList<Point>();
    for (int column = 0; column < board.getNumberOfColumns(); column++)
      pointsForSecondRow.add(new Point(1, column));
    return pointsForSecondRow;
  }
  
  private boolean isWinForSecondColumn() {
    boolean isWin = true;
    List<Point> pointsForSecondColumn = getPointsForSecondColumn();
    for (Point pointInSecondColumn : pointsForSecondColumn)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInSecondColumn, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForSecondColumn() {
    List<Point> pointsForSecondColumn = new ArrayList<Point>();
    for (int row = 0; row < board.getNumberOfRows(); row++)
      pointsForSecondColumn.add(new Point(row, 1));
    return pointsForSecondColumn;
  }
  
  private boolean isWinForThirdRow() {
    boolean isWin = true;
    List<Point> pointsForThirdRow = getPointsForThirdRow();
    for (Point pointInThirdRow : pointsForThirdRow)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInThirdRow, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForThirdRow() {
    List<Point> pointsForThirdRow = new ArrayList<Point>();
    for (int column = 0; column < board.getNumberOfColumns(); column++)
      pointsForThirdRow.add(new Point(2, column));
    return pointsForThirdRow;
  }
  
  private boolean isWinForThirdColumn() {
    boolean isWin = true;
    List<Point> pointsForThirdColumn = getPointsForThirdColumn();
    for (Point pointInThirdColumn : pointsForThirdColumn)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInThirdColumn, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForThirdColumn() {
    List<Point> pointsForThirdColumn = new ArrayList<Point>();
    for (int row = 0; row < board.getNumberOfRows(); row++)
      pointsForThirdColumn.add(new Point(row, 2));
    return pointsForThirdColumn;
  }
  
  private boolean isWinForBackSlashDiagonal() {
    boolean isWin = true;
    List<Point> pointsForBackSlashDiagonal = getPointsForBackSlashDiagonal();
    for (Point pointInBackSlashDiagonal : pointsForBackSlashDiagonal)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInBackSlashDiagonal, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForBackSlashDiagonal() {
    List<Point> pointsForBackSlashDiagonal = new ArrayList<Point>();
    for (int rowColumn = 0; rowColumn < board.getNumberOfColumns(); rowColumn++)
      pointsForBackSlashDiagonal.add(new Point(rowColumn, rowColumn));
    return pointsForBackSlashDiagonal;
  }
  
  private boolean isWinForForwardSlashDiagonal() {
    boolean isWin = true;
    List<Point> pointsForForwardSlashDiagonal = getPointsForForwardSlashDiagonal();
    for (Point pointInForwardSlashDiagonal : pointsForForwardSlashDiagonal)
      isWin = isWin && board.isPieceAtPointEqualToPiece(pointInForwardSlashDiagonal, lastPieceAdded);
    return isWin;
  }
  
  private List<Point> getPointsForForwardSlashDiagonal() {
    int currentColumnWithForwardSlashDiagonalPoint = board.getNumberOfColumns() - 1;
    List<Point> pointsForForwardSlashDiagonal = new ArrayList<Point>();
    for (int row = 0; row < board.getNumberOfColumns(); row++) {
      pointsForForwardSlashDiagonal.add(new Point(row, currentColumnWithForwardSlashDiagonalPoint));
      currentColumnWithForwardSlashDiagonalPoint -= 1;
    }
    return pointsForForwardSlashDiagonal;
  }

}
