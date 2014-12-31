package tests.domain.models;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.domain.models.TicTacToeBoard;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeBoardTest {
  
  private TicTacToeBoard board;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoard();
  }

  @Test
  public void testGivenNumberOfRowsIsSameWhenRetrieved() {
    board.setNumberOfRows(3);
    assertEquals(3, board.getNumberOfRows());
  }
  
  @Test
  public void testGivenNumberOfColumnsIsSameWhenRetrieved() {
    board.setNumberOfColumns(3);
    assertEquals(3, board.getNumberOfColumns());
  }
  
  @Test
  public void testGivenListOfXPointsIsSameWhenRetrieved() {
    List<Point> xPoints = new ArrayList<Point>();
    xPoints.add(new Point(1, 1));
    xPoints.add(new Point(0, 1));
    xPoints.add(new Point(0, 2));
    xPoints.add(new Point(2, 1));
    board.setXPoints(xPoints);
    assertTrue(xPoints.equals(board.getXPoints()));
  }
  
  @Test
  public void testGivenListOfOPointsIsSameWhenRetrieved() {
    List<Point> oPoints = new ArrayList<Point>();
    oPoints.add(new Point(1, 1));
    oPoints.add(new Point(0, 1));
    oPoints.add(new Point(0, 2));
    oPoints.add(new Point(2, 1));
    board.setOPoints(oPoints);
    assertTrue(oPoints.equals(board.getOPoints()));
  }
  
  @Test
  public void testBoardContainsPointTwoOne() {
    List<Point> oPoints = new ArrayList<Point>();
    oPoints.add(new Point(1, 1));
    oPoints.add(new Point(0, 1));
    oPoints.add(new Point(0, 2));
    oPoints.add(new Point(2, 1));
    board.setXPoints(new ArrayList<Point>());
    board.setOPoints(oPoints);
    assertTrue(board.isPointTaken(new Point(2, 1)));
  }
  
  @Test
  public void testBoardDoesntContainPointTwoTwo() {
    List<Point> oPoints = new ArrayList<Point>();
    oPoints.add(new Point(1, 1));
    oPoints.add(new Point(0, 1));
    oPoints.add(new Point(0, 2));
    oPoints.add(new Point(2, 1));
    board.setXPoints(new ArrayList<Point>());
    board.setOPoints(oPoints);
    assertFalse(board.isPointTaken(new Point(2, 2)));
  }
  
  @Test
  public void testPieceAtPointTwoOneIsOPiece() {
    List<Point> oPoints = new ArrayList<Point>();
    oPoints.add(new Point(1, 1));
    oPoints.add(new Point(0, 1));
    oPoints.add(new Point(0, 2));
    oPoints.add(new Point(2, 1));
    board.setOPoints(oPoints);
    assertTrue(board.isOPieceAtPoint(new Point(2, 1)));
  }
  
  @Test
  public void testPieceAtPointTwoOneIsXPiece() {
    List<Point> xPoints = new ArrayList<Point>();
    xPoints.add(new Point(1, 1));
    xPoints.add(new Point(0, 1));
    xPoints.add(new Point(0, 2));
    xPoints.add(new Point(2, 1));
    board.setXPoints(xPoints);
    assertTrue(board.isXPieceAtPoint(new Point(2, 1)));
  }

}
