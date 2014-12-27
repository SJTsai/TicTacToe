package domain.entities.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import domain.entities.TicTacToeBoardEntity;
import domain.entities.TicTacToePieceEntity;

public class TicTacToeBoardEntityTest {
  
  private TicTacToeBoardEntity board;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoardEntity();
  }

	@Test
	public void testPieceOnPointOneOneIsX() {
	  Point pointToAddTo = new Point(1, 1);
		board.addPieceToPoint(TicTacToePieceEntity.X, pointToAddTo);
		assertEquals(TicTacToePieceEntity.X, board.getPieceForPoint(pointToAddTo));
	}
	
	@Test
	public void testPieceOnPointOneOneIsNull() {
	  assertEquals(null, board.getPieceForPoint(new Point(1, 1)));
	}
	
	@Test
	public void testPieceOnPointOneOneIsO() {
	  Point pointToAddTo = new Point(1, 1);
	  board.addPieceToPoint(TicTacToePieceEntity.O, pointToAddTo);
	  assertEquals(TicTacToePieceEntity.O, board.getPieceForPoint(pointToAddTo));
	}
	
	@Test
	public void testPieceOnPointOneOneIsXAfterReplacement() {
	  Point pointToAddTo = new Point(1, 1);
    board.addPieceToPoint(TicTacToePieceEntity.O, pointToAddTo);
    board.addPieceToPoint(TicTacToePieceEntity.X, pointToAddTo);
    assertEquals(TicTacToePieceEntity.X, board.getPieceForPoint(pointToAddTo));
	}
	
	@Test
	public void testPieceOnPointOneOneIsOAfterReplacement() {
    Point pointToAddTo = new Point(1, 1);
    board.addPieceToPoint(TicTacToePieceEntity.X, pointToAddTo);
    board.addPieceToPoint(TicTacToePieceEntity.O, pointToAddTo);
    assertEquals(TicTacToePieceEntity.O, board.getPieceForPoint(pointToAddTo));
  }
	
	@Test
	public void testXPointsCountIsOne() {
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
	  assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
	}
	
	@Test
  public void testXPointsCountIsTwo() {
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
    assertEquals(2, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
  public void testXPointsCountIsTwoAfterAddingAnOPiece() {
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(2, 2));
    assertEquals(2, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
  public void testXPointsCountIsOneAfterReplacingAnXPieceWithAnOPiece() {
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(1, 1));
    assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
	public void testXPointsContainsPointOneOne() {
	  Point pointToAddTo = new Point(1, 1);
	  board.addPieceToPoint(TicTacToePieceEntity.X, pointToAddTo);
    assertTrue(board.doXPointsContainPoint(pointToAddTo));
	}
	
	@Test
	public void testXPointsContainsPointsZeroZeroAndOneOne() {
	  Point firstPointToAddTo = new Point(0, 0);
	  Point secondPointToAddTo = new Point(1, 1);
    board.addPieceToPoint(TicTacToePieceEntity.X, firstPointToAddTo);
    board.addPieceToPoint(TicTacToePieceEntity.X, secondPointToAddTo);
    assertTrue(board.doXPointsContainPoint(firstPointToAddTo));
    assertTrue(board.doXPointsContainPoint(secondPointToAddTo));
	}
	
	@Test
  public void testOPointsCountIsOne() {
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(1, 1));
    assertEquals(1, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsTwo() {
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(1, 1));
    assertEquals(2, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsTwoAfterAddingAnXPiece() {
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(1, 1));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(2, 2));
    assertEquals(2, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsOneAfterReplacingAnOPieceWithAnXPiece() {
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.O, new Point(1, 1));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
    assertEquals(1, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsContainsPointOneOne() {
    Point pointToAddTo = new Point(1, 1);
    board.addPieceToPoint(TicTacToePieceEntity.O, pointToAddTo);
    assertTrue(board.doOPointsContainPoint(pointToAddTo));
  }
	
	@Test
  public void testOPointsContainsPointsZeroZeroAndOneOne() {
    Point firstPointToAddTo = new Point(0, 0);
    Point secondPointToAddTo = new Point(1, 1);
    board.addPieceToPoint(TicTacToePieceEntity.O, firstPointToAddTo);
    board.addPieceToPoint(TicTacToePieceEntity.O, secondPointToAddTo);
    assertTrue(board.doOPointsContainPoint(firstPointToAddTo));
    assertTrue(board.doOPointsContainPoint(secondPointToAddTo));
  }
	
	@Test
	public void testNumberOfRowsIs3() {
	  assertEquals(3, board.getNumberOfRows());
	}
	
	@Test
	public void testNumberOfColumnsIs3() {
	  assertEquals(3, board.getNumberOfColumns());
	}
	
	@Test
	public void testBoardIsEmpty() {
	  assertTrue(board.isEmpty());
	}
	
	@Test
	public void testBoardIsNotEmpty() {
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
	  assertFalse(board.isEmpty());
	}
	
	@Test
	public void testPointOneOneIsTaken() {
	  Point pointToAddTo = new Point(1, 1);
	  board.addPieceToPoint(TicTacToePieceEntity.X, pointToAddTo);
	  assertTrue(board.isPointTaken(pointToAddTo));
	}
	
	@Test
	public void testBoardIsNotFullWithOnePieceShyOfBeingAFullBoard() {
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 0));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 1));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 2));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 0));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 2));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(2, 0));
	  board.addPieceToPoint(TicTacToePieceEntity.X, new Point(2, 1));
	  assertFalse(board.isFull());
	}
	
	@Test
  public void testBoardIsFull() {
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 0));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 1));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(0, 2));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 0));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 1));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(1, 2));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(2, 0));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(2, 1));
    board.addPieceToPoint(TicTacToePieceEntity.X, new Point(2, 2));
    assertTrue(board.isFull());
  }

}
