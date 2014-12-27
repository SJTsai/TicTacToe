package tests.domain.entities;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

import org.junit.Before;
import org.junit.Test;

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
	
	@Test
  public void testPieceOnPointOneOneOfClonedBoardIsX() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(pieceToAdd, pointToTake);
    board.addMove(move);
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(TicTacToePieceEntity.X, boardClone.getPieceForPoint(pointToTake));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsNull() {
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(null, boardClone.getPieceForPoint(new Point(1, 1)));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsO() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    board.addMove(move);
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(TicTacToePieceEntity.O, boardClone.getPieceForPoint(pointToTake));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsXAfterReplacement() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    board.addMove(move);
    
    move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    board.addMove(move);
    
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    
    assertEquals(TicTacToePieceEntity.X, boardClone.getPieceForPoint(pointToTake));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsOAfterReplacement() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    board.addMove(move);
    
    move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    board.addMove(move);
    
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    
    assertEquals(TicTacToePieceEntity.O, boardClone.getPieceForPoint(pointToTake));
  }
	
	@Test
  public void testXPointsCountForClonedBoardIsOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(1, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsCountForClonedBoardIsTwo() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(2, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsCountForClonedBoardIsTwoAfterAddingAnOPiece() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 2)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(2, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsCountForClonedBoardIsOneAfterReplacingAnXPieceWithAnOPiece() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(1, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsForClonedBoardContainsPointOneOne() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, pointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.doXPointsContainPoint(pointToTake));
  }
  
  @Test
  public void testXPointsForClonedBoardContainsPointsZeroZeroAndOneOne() {
    Point firstPointToTake = new Point(0, 0);
    Point secondPointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, firstPointToTake));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, secondPointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.doXPointsContainPoint(firstPointToTake));
    assertTrue(boardClone.doXPointsContainPoint(secondPointToTake));
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(1, boardClone.getNumberOfOPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsTwo() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(2, boardClone.getNumberOfOPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsTwoAfterAddingAnXPiece() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(2, boardClone.getNumberOfOPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsOneAfterReplacingAnOPieceWithAnXPiece() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(1, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsForClonedBoardContainsPointOneOne() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, pointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.doOPointsContainPoint(pointToTake));
  }
  
  @Test
  public void testOPointsForClonedBoardContainsPointsZeroZeroAndOneOne() {
    Point firstPointToTake = new Point(0, 0);
    Point secondPointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, firstPointToTake));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, secondPointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.doOPointsContainPoint(firstPointToTake));
    assertTrue(boardClone.doOPointsContainPoint(secondPointToTake));
  }
  
  @Test
  public void testNumberOfRowsOnClonedBoardIs3() {
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(3, boardClone.getNumberOfRows());
  }
  
  @Test
  public void testNumberOfColumnsOnClonedBoardIs3() {
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertEquals(3, boardClone.getNumberOfColumns());
  }
  
  @Test
  public void testClonedBoardIsEmpty() {
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.isEmpty());
  }
  
  @Test
  public void testClonedBoardIsNotEmpty() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertFalse(boardClone.isEmpty());
  }
  
  @Test
  public void testPointOneOneOnClonedBoardIsTaken() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, pointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.isPointTaken(pointToTake));
  }
  
  @Test
  public void testClonedBoardIsNotFullWithOnePieceShyOfBeingAFullBoard() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertFalse(boardClone.isFull());
  }
  
  @Test
  public void testClonedBoardIsFull() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.isFull());
  }
  
  @Test
  public void testPieceAtPointOnClonedBoardIsX() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, pointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.isPieceAtPointXPiece(pointToTake));
  }
  
  @Test
  public void testPieceAtPointOnClonedBoardIsO() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, pointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.isPieceAtPointOPiece(pointToTake));
  }
  
  @Test
  public void testPieceAtPointOnClonedBoardIsEqualToPiece() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    Point pointToTake = new Point(1, 1);
    board.addMove(new MoveEntity(pieceToAdd, pointToTake));
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    assertTrue(boardClone.isPieceAtPointEqualToPiece(pointToTake, pieceToAdd));
  }

}
