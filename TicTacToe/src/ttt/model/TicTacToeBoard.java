package ttt.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeBoard {

  private TicTacToePiece[][] board;
  private List<Point> xPoints;
  private List<Point> oPoints;
  private List<Point> emptyPoints;
  private List<Point> takenPoints;
  private final int numberOfRows = 3;
  private final int numberOfColumns = 3;
  
  public TicTacToeBoard() {
    board = new TicTacToePiece[numberOfRows][numberOfColumns];
    xPoints = new ArrayList<Point>(5);
    oPoints = new ArrayList<Point>(5);
    takenPoints = new ArrayList<Point>(9);
    initializeEmptyPoints();
  }
  
  private void initializeEmptyPoints() {
    emptyPoints = new ArrayList<Point>(9);
    for (int row = 0; row < numberOfRows; row++)
      for (int column = 0; column < numberOfColumns; column++)
        emptyPoints.add(new Point(row, column));
  }
  
  public void reset() {
    for (int row = 0; row < numberOfRows; row++)
      for (int column = 0; column < numberOfColumns; column++)
        board[row][column] = null;
    
    xPoints.clear();
    oPoints.clear();
    takenPoints.clear();
    initializeEmptyPoints();
  }
  
  public TicTacToeBoard(TicTacToeBoard boardToClone) {
    board = boardToClone.board.clone();
    xPoints = getCloneOfXPointsFromBoard(boardToClone);
    oPoints = getCloneOfOPointsFromBoard(boardToClone);
    takenPoints = getCloneOfTakenPointsFromBoard(boardToClone);
    emptyPoints = boardToClone.getEmptyPointsClone();
  }
  
  private List<Point> getCloneOfXPointsFromBoard(TicTacToeBoard board) {
    List<Point> xPointsClone = new ArrayList<Point>();
    for (Point xPointToClone : board.xPoints)
      xPointsClone.add(new Point(xPointToClone));
    return xPointsClone;
  }
  
  private List<Point> getCloneOfOPointsFromBoard(TicTacToeBoard board) {
    List<Point> oPointsClone = new ArrayList<Point>();
    for (Point oPointToClone : board.oPoints)
      oPointsClone.add(new Point(oPointToClone));
    return oPointsClone;
  }
  
  private List<Point>getCloneOfTakenPointsFromBoard(TicTacToeBoard board) {
    List<Point> takenPointsClone = new ArrayList<Point>();
    for (Point takenPointToClone : board.takenPoints)
      takenPointsClone.add(new Point(takenPointToClone));
    return takenPointsClone;
  }
  
  public List<Point> getEmptyPointsClone() {
    List<Point> emptyPointsClone = new ArrayList<Point>();
    for (Point emptyPointToClone : emptyPoints)
      emptyPointsClone.add(new Point(emptyPointToClone));
    return emptyPointsClone;
  }
  
  public List<Point>getXPointsClone() {
    List<Point> xPointsClone = new ArrayList<Point>();
    for (Point xPointToClone : xPoints)
      xPointsClone.add(new Point(xPointToClone));
    return xPointsClone;
  }
  
  public List<Point>getOPointsClone() {
    List<Point> oPointsClone = new ArrayList<Point>();
    for (Point oPointToClone : oPoints)
      oPointsClone.add(new Point(oPointToClone));
    return oPointsClone;
  }
  
  public void addMove(Move move) {
    Point pointToTake = move.getPoint();
    TicTacToePiece pieceToAdd = move.getPiece();
    board[pointToTake.x][pointToTake.y] = pieceToAdd;
    updateTrackedPointsForAdditionOfMove(move);
  }
  
  private void updateTrackedPointsForAdditionOfMove(Move move) {
    if (move.getPiece() == TicTacToePiece.X)
      updateTrackedPointsForAdditionOfXMove(move.getPoint());
    else
      updateTrackedPointsForAdditionOfOMove(move.getPoint());
  }
  
  private void updateTrackedPointsForAdditionOfXMove(Point pointWhereAdded) {
    if (oPoints.contains(pointWhereAdded))
      oPoints.remove(pointWhereAdded);
    
    if (!xPoints.contains(pointWhereAdded))
      xPoints.add(pointWhereAdded);
    
    updateTakenPointsForPointAdded(pointWhereAdded);
    updateEmptyPointsForPointAdded(pointWhereAdded);
  }
  
  private void updateTrackedPointsForAdditionOfOMove(Point pointWhereAdded) {
    if (xPoints.contains(pointWhereAdded))
      xPoints.remove(pointWhereAdded);
    
    if (!oPoints.contains(pointWhereAdded))
      oPoints.add(pointWhereAdded);
    
    updateTakenPointsForPointAdded(pointWhereAdded);
    updateEmptyPointsForPointAdded(pointWhereAdded);
  }
  
  private void updateTakenPointsForPointAdded(Point pointWhereAdded) {
    if (!takenPoints.contains(pointWhereAdded))
      takenPoints.add(pointWhereAdded);
  }
  
  private void updateEmptyPointsForPointAdded(Point pointWhereAdded) {
    if (emptyPoints.contains(pointWhereAdded))
      emptyPoints.remove(pointWhereAdded);
  }
  
  public TicTacToePiece getPieceForPoint(Point point) {
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
        return getPieceForPoint(point) == TicTacToePiece.X;
    return false;
  }
  
  public boolean isPieceAtPointOPiece(Point point) {
    if (isPointTaken(point))
        return getPieceForPoint(point) == TicTacToePiece.O;
    return false;
  }
  
  public boolean isPieceAtPointEqualToPiece(Point point, TicTacToePiece piece) {
    if (isPointTaken(point))
      return getPieceForPoint(point) == piece;
    return false;
  }
  
}
