package domain.entities.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import domain.entities.MoveEntity;
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
	  TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
	  Point pointToTake = new Point(1, 1);
	  MoveEntity move = new MoveEntity(pieceToAdd, pointToTake);
		board.addMove(move);
		assertEquals(TicTacToePieceEntity.X, board.getPieceForPoint(pointToTake));
	}
	
	@Test
	public void testPieceOnPointOneOneIsNull() {
	  assertEquals(null, board.getPieceForPoint(new Point(1, 1)));
	}
	
	@Test
	public void testPieceOnPointOneOneIsO() {
	  Point pointToTake = new Point(1, 1);
	  MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
	  board.addMove(move);
	  assertEquals(TicTacToePieceEntity.O, board.getPieceForPoint(pointToTake));
	}
	
	@Test
	public void testPieceOnPointOneOneIsXAfterReplacement() {
	  Point pointToTake = new Point(1, 1);
	  MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    board.addMove(move);
    
    move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    board.addMove(move);
    
    assertEquals(TicTacToePieceEntity.X, board.getPieceForPoint(pointToTake));
	}
	
	@Test
	public void testPieceOnPointOneOneIsOAfterReplacement() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    board.addMove(move);
    
    move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    board.addMove(move);
    
    assertEquals(TicTacToePieceEntity.O, board.getPieceForPoint(pointToTake));
  }
	
	@Test
	public void testXPointsCountIsOne() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
	  assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
	}
	
	@Test
  public void testXPointsCountIsTwo() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    assertEquals(2, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
  public void testXPointsCountIsTwoAfterAddingAnOPiece() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 2)));
    assertEquals(2, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
  public void testXPointsCountIsOneAfterReplacingAnXPieceWithAnOPiece() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
	public void testXPointsContainsPointOneOne() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, pointToTake));
    assertTrue(board.doXPointsContainPoint(pointToTake));
	}
	
	@Test
	public void testXPointsContainsPointsZeroZeroAndOneOne() {
	  Point firstPointToTake = new Point(0, 0);
	  Point secondPointToTake = new Point(1, 1);
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, firstPointToTake));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, secondPointToTake));
    assertTrue(board.doXPointsContainPoint(firstPointToTake));
    assertTrue(board.doXPointsContainPoint(secondPointToTake));
	}
	
	@Test
  public void testOPointsCountIsOne() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    assertEquals(1, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsTwo() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    assertEquals(2, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsTwoAfterAddingAnXPiece() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    assertEquals(2, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsOneAfterReplacingAnOPieceWithAnXPiece() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    assertEquals(1, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsContainsPointOneOne() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, pointToTake));
    assertTrue(board.doOPointsContainPoint(pointToTake));
  }
	
	@Test
  public void testOPointsContainsPointsZeroZeroAndOneOne() {
    Point firstPointToTake = new Point(0, 0);
    Point secondPointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, firstPointToTake));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, secondPointToTake));
    assertTrue(board.doOPointsContainPoint(firstPointToTake));
    assertTrue(board.doOPointsContainPoint(secondPointToTake));
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
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
	  assertFalse(board.isEmpty());
	}
	
	@Test
	public void testPointOneOneIsTaken() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, pointToTake));
	  assertTrue(board.isPointTaken(pointToTake));
	}
	
	@Test
	public void testBoardIsNotFullWithOnePieceShyOfBeingAFullBoard() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1)));
	  assertFalse(board.isFull());
	}
	
	@Test
  public void testBoardIsFull() {
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    assertTrue(board.isFull());
  }
	
	@Test
	public void testPieceAtPointIsX() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new MoveEntity(TicTacToePieceEntity.X, pointToTake));
	  assertTrue(board.isPieceAtPointXPiece(pointToTake));
	}
	
	@Test
	public void testPieceAtPointIsO() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new MoveEntity(TicTacToePieceEntity.O, pointToTake));
    assertTrue(board.isPieceAtPointOPiece(pointToTake));
	}
	
	@Test
	public void testPieceAtPointIsEqualToPiece() {
	  TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
	  Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(pieceToAdd, pointToTake));
    assertTrue(board.isPieceAtPointEqualToPiece(pointToTake, pieceToAdd));
	}

}
