package domain.entities;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoardEntity {

  private TicTacToePieceEntity[][] board;
  private List<Point> xPoints;
  private List<Point> oPoints;
  private List<Point> emptyPoints;
  private List<Point> takenPoints;
  private final int numberOfRows = 3;
  private final int numberOfColumns = 3;
  
  public TicTacToeBoardEntity() {
    board = new TicTacToePieceEntity[numberOfRows][numberOfColumns];
    xPoints = new ArrayList<Point>(5);
    oPoints = new ArrayList<Point>(5);
    takenPoints = new ArrayList<Point>(9);
    emptyPoints = new ArrayList<Point>(9);
    
    for (int row = 0; row < numberOfRows; row++)
      for (int column = 0; column < numberOfColumns; column++)
        emptyPoints.add(new Point(row, column));
  }
  
  public void addMove(MoveEntity move) {
    Point pointToTake = move.getPoint();
    TicTacToePieceEntity pieceToAdd = move.getPiece();
    board[pointToTake.x][pointToTake.y] = pieceToAdd;
    if (pieceToAdd == TicTacToePieceEntity.X) {
      if (oPoints.contains(pointToTake))
        oPoints.remove(pointToTake);
      xPoints.add(pointToTake);
    } else {
      if (xPoints.contains(pointToTake))
        xPoints.remove(pointToTake);
      oPoints.add(pointToTake);
    }
    
    if (!takenPoints.contains(pointToTake))
      takenPoints.add(pointToTake);
    
    emptyPoints.remove(pointToTake);
  }
  
  public TicTacToePieceEntity getPieceForPoint(Point point) {
    return board[point.x][point.y];
  }
  
  public int getNumberOfXPiecesOnTheBoard() {
    return xPoints.size();
  }
  
  public boolean doXPointsContainPoint(Point point) {
    return xPoints.contains(point);
  }
  
  public int getNumberOfOPiecesOnTheBoard() {
    return oPoints.size();
  }
  
  public boolean doOPointsContainPoint(Point point) {
    return oPoints.contains(point);
  }
  
  public int getNumberOfRows() {
    return board.length;
  }
  
  public int getNumberOfColumns() {
    return board[0].length;
  }
  
  public boolean isEmpty() {
    return takenPoints.size() == 0;
  }
  
  public boolean isPointTaken(Point point) {
    return takenPoints.contains(point);
  }
  
  public boolean isFull() {
    return emptyPoints.size() == 0;
  }
  
  public boolean isPieceAtPointXPiece(Point point) {
    if (isPointTaken(point))
        return getPieceForPoint(point) == TicTacToePieceEntity.X;
    return false;
  }
  
  public boolean isPieceAtPointOPiece(Point point) {
    if (isPointTaken(point))
        return getPieceForPoint(point) == TicTacToePieceEntity.O;
    return false;
  }
  
  public boolean isPieceAtPointEqualToPiece(Point point, TicTacToePieceEntity piece) {
    if (isPointTaken(point))
      return getPieceForPoint(point) == piece;
    return false;
  }
  
}
