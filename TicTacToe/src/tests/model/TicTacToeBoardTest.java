package tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;

public class TicTacToeBoardTest {
  
  private TicTacToeBoard board;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoard();
  }

	@Test
	public void testPieceOnPointOneOneIsX() {
	  TicTacToePiece pieceToAdd = TicTacToePiece.X;
	  Point pointToTake = new Point(1, 1);
	  Move move = new Move(pieceToAdd, pointToTake);
		board.addMove(move);
		assertEquals(TicTacToePiece.X, board.getPieceForPoint(pointToTake));
	}
	
	@Test
	public void testPieceOnPointOneOneIsNull() {
	  assertEquals(null, board.getPieceForPoint(new Point(1, 1)));
	}
	
	@Test
	public void testPieceOnPointOneOneIsO() {
	  Point pointToTake = new Point(1, 1);
	  Move move = new Move(TicTacToePiece.O, pointToTake);
	  board.addMove(move);
	  assertEquals(TicTacToePiece.O, board.getPieceForPoint(pointToTake));
	}
	
	@Test
	public void testPieceOnPointOneOneIsXAfterReplacement() {
	  Point pointToTake = new Point(1, 1);
	  Move move = new Move(TicTacToePiece.O, pointToTake);
    board.addMove(move);
    
    move = new Move(TicTacToePiece.X, pointToTake);
    board.addMove(move);
    
    assertEquals(TicTacToePiece.X, board.getPieceForPoint(pointToTake));
	}
	
	@Test
	public void testPieceOnPointOneOneIsOAfterReplacement() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.X, pointToTake);
    board.addMove(move);
    
    move = new Move(TicTacToePiece.O, pointToTake);
    board.addMove(move);
    
    assertEquals(TicTacToePiece.O, board.getPieceForPoint(pointToTake));
  }
	
	@Test
	public void testXPointsCountIsOne() {
	  board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
	  assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
	}
	
	@Test
  public void testXPointsCountIsTwo() {
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    assertEquals(2, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
  public void testXPointsCountIsTwoAfterAddingAnOPiece() {
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
	  board.addMove(new Move(TicTacToePiece.O, new Point(2, 2)));
    assertEquals(2, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
  public void testXPointsCountIsOneAfterReplacingAnXPieceWithAnOPiece() {
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
  }
	
	@Test
	public void testXPointsContainsPointOneOne() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new Move(TicTacToePiece.X, pointToTake));
    assertTrue(board.doXPointsContainPoint(pointToTake));
	}
	
	@Test
	public void testXPointsContainsPointsZeroZeroAndOneOne() {
	  Point firstPointToTake = new Point(0, 0);
	  Point secondPointToTake = new Point(1, 1);
	  board.addMove(new Move(TicTacToePiece.X, firstPointToTake));
	  board.addMove(new Move(TicTacToePiece.X, secondPointToTake));
    assertTrue(board.doXPointsContainPoint(firstPointToTake));
    assertTrue(board.doXPointsContainPoint(secondPointToTake));
	}
	
	@Test
  public void testOPointsCountIsOne() {
	  board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    assertEquals(1, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsTwo() {
	  board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    assertEquals(2, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsTwoAfterAddingAnXPiece() {
	  board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
	  board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    assertEquals(2, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsCountIsOneAfterReplacingAnOPieceWithAnXPiece() {
	  board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    assertEquals(1, board.getNumberOfOPiecesOnTheBoard());
  }
	
	@Test
  public void testOPointsContainsPointOneOne() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.O, pointToTake));
    assertTrue(board.doOPointsContainPoint(pointToTake));
  }
	
	@Test
  public void testOPointsContainsPointsZeroZeroAndOneOne() {
    Point firstPointToTake = new Point(0, 0);
    Point secondPointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.O, firstPointToTake));
    board.addMove(new Move(TicTacToePiece.O, secondPointToTake));
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
	  board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
	  assertFalse(board.isEmpty());
	}
	
	@Test
	public void testPointOneOneIsTaken() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new Move(TicTacToePiece.X, pointToTake));
	  assertTrue(board.isPointTaken(pointToTake));
	}
	
	@Test
	public void testBoardIsNotFullWithOnePieceShyOfBeingAFullBoard() {
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 2)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(1, 0)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(2, 0)));
	  board.addMove(new Move(TicTacToePiece.X, new Point(2, 1)));
	  assertFalse(board.isFull());
	}
	
	@Test
  public void testBoardIsFull() {
	  board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    assertTrue(board.isFull());
  }
	
	@Test
	public void testPieceAtPointIsX() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new Move(TicTacToePiece.X, pointToTake));
	  assertTrue(board.isPieceAtPointXPiece(pointToTake));
	}
	
	@Test
	public void testPieceAtPointIsO() {
	  Point pointToTake = new Point(1, 1);
	  board.addMove(new Move(TicTacToePiece.O, pointToTake));
    assertTrue(board.isPieceAtPointOPiece(pointToTake));
	}
	
	@Test
	public void testPieceAtPointIsEqualToPiece() {
	  TicTacToePiece pieceToAdd = TicTacToePiece.X;
	  Point pointToTake = new Point(1, 1);
    board.addMove(new Move(pieceToAdd, pointToTake));
    assertTrue(board.isPieceAtPointEqualToPiece(pointToTake, pieceToAdd));
	}
	
	@Test
  public void testPieceOnPointOneOneOfClonedBoardIsX() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    Point pointToTake = new Point(1, 1);
    Move move = new Move(pieceToAdd, pointToTake);
    board.addMove(move);
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(TicTacToePiece.X, boardClone.getPieceForPoint(pointToTake));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsNull() {
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(null, boardClone.getPieceForPoint(new Point(1, 1)));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsO() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.O, pointToTake);
    board.addMove(move);
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(TicTacToePiece.O, boardClone.getPieceForPoint(pointToTake));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsXAfterReplacement() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.O, pointToTake);
    board.addMove(move);
    
    move = new Move(TicTacToePiece.X, pointToTake);
    board.addMove(move);
    
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    
    assertEquals(TicTacToePiece.X, boardClone.getPieceForPoint(pointToTake));
  }
  
  @Test
  public void testPieceOnPointOneOneOfClonedBoardIsOAfterReplacement() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.X, pointToTake);
    board.addMove(move);
    
    move = new Move(TicTacToePiece.O, pointToTake);
    board.addMove(move);
    
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    
    assertEquals(TicTacToePiece.O, boardClone.getPieceForPoint(pointToTake));
  }
	
	@Test
  public void testXPointsCountForClonedBoardIsOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(1, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsCountForClonedBoardIsTwo() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(2, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsCountForClonedBoardIsTwoAfterAddingAnOPiece() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 2)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(2, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsCountForClonedBoardIsOneAfterReplacingAnXPieceWithAnOPiece() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(1, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testXPointsForClonedBoardContainsPointOneOne() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.X, pointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.doXPointsContainPoint(pointToTake));
  }
  
  @Test
  public void testXPointsForClonedBoardContainsPointsZeroZeroAndOneOne() {
    Point firstPointToTake = new Point(0, 0);
    Point secondPointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.X, firstPointToTake));
    board.addMove(new Move(TicTacToePiece.X, secondPointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.doXPointsContainPoint(firstPointToTake));
    assertTrue(boardClone.doXPointsContainPoint(secondPointToTake));
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsOne() {
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(1, boardClone.getNumberOfOPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsTwo() {
    board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(2, boardClone.getNumberOfOPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsTwoAfterAddingAnXPiece() {
    board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(2, boardClone.getNumberOfOPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsCountForClonedBoardIsOneAfterReplacingAnOPieceWithAnXPiece() {
    board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(1, boardClone.getNumberOfXPiecesOnTheBoard());
  }
  
  @Test
  public void testOPointsForClonedBoardContainsPointOneOne() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.O, pointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.doOPointsContainPoint(pointToTake));
  }
  
  @Test
  public void testOPointsForClonedBoardContainsPointsZeroZeroAndOneOne() {
    Point firstPointToTake = new Point(0, 0);
    Point secondPointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.O, firstPointToTake));
    board.addMove(new Move(TicTacToePiece.O, secondPointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.doOPointsContainPoint(firstPointToTake));
    assertTrue(boardClone.doOPointsContainPoint(secondPointToTake));
  }
  
  @Test
  public void testNumberOfRowsOnClonedBoardIs3() {
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(3, boardClone.getNumberOfRows());
  }
  
  @Test
  public void testNumberOfColumnsOnClonedBoardIs3() {
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertEquals(3, boardClone.getNumberOfColumns());
  }
  
  @Test
  public void testClonedBoardIsEmpty() {
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.isEmpty());
  }
  
  @Test
  public void testClonedBoardIsNotEmpty() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertFalse(boardClone.isEmpty());
  }
  
  @Test
  public void testPointOneOneOnClonedBoardIsTaken() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.X, pointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.isPointTaken(pointToTake));
  }
  
  @Test
  public void testClonedBoardIsNotFullWithOnePieceShyOfBeingAFullBoard() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 1)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertFalse(boardClone.isFull());
  }
  
  @Test
  public void testClonedBoardIsFull() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.isFull());
  }
  
  @Test
  public void testPieceAtPointOnClonedBoardIsX() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.X, pointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.isPieceAtPointXPiece(pointToTake));
  }
  
  @Test
  public void testPieceAtPointOnClonedBoardIsO() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.O, pointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.isPieceAtPointOPiece(pointToTake));
  }
  
  @Test
  public void testPieceAtPointOnClonedBoardIsEqualToPiece() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(pieceToAdd, pointToTake));
    TicTacToeBoard boardClone = new TicTacToeBoard(board);
    assertTrue(boardClone.isPieceAtPointEqualToPiece(pointToTake, pieceToAdd));
  }
  
  @Test
  public void testClonedXPointsIsEqualToOriginal() {
    List<Point> xPointsToTake = new ArrayList<Point>();
    xPointsToTake.add(new Point(1, 1));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    assertTrue(xPointsToTake.equals(board.getXPointsClone()));
  }
  
  @Test
  public void testClonedOPointsIsEqualToOriginal() {
    List<Point> oPointsToTake = new ArrayList<Point>();
    oPointsToTake.add(new Point(1, 1));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    assertTrue(oPointsToTake.equals(board.getOPointsClone()));
  }
  
  @Test
  public void testBoardReset() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(0, 0)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 2)));
    board.reset();
    
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertEquals(null, board.getPieceForPoint(new Point(row, column)));
    
    assertEquals(0, board.getNumberOfXPiecesOnTheBoard());
    
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.doXPointsContainPoint(new Point(row, column)));
    
    assertEquals(0, board.getNumberOfOPiecesOnTheBoard());
    
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.doOPointsContainPoint(new Point(row, column)));
    
    assertTrue(board.isEmpty());
    
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.isPointTaken(new Point(row, column)));
    
    assertFalse(board.isFull());
    
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.isPieceAtPointXPiece(new Point(row, column)));
    
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.isPieceAtPointOPiece(new Point(row, column)));
  }

}
