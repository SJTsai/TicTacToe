package tests.movegenerator;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;
import ttt.movegenerator.BestMoveRatingGenerator;

public class BestMoveRatingGeneratorTest {
  
  private TicTacToeBoard board;
  private BestMoveRatingGenerator bestMoveRatingGenerator;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoard();
    bestMoveRatingGenerator = new BestMoveRatingGenerator();
  }

  @Test
  public void testBestRatingForPointOneOneOnEmptyBoardIsZero() {
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.X, new Point(1, 1))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroZeroOnEmptyBoardIsZero() {
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.X, new Point(0, 0))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroOneOnEmptyBoardIsZero() {
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.X, new Point(0, 0))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroOneAfterInitialCenterMoveIsNegativeOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    assertEquals(-1, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(0, 1))).getRating());
  }
  
  @Test
  public void testBestRatingForPointTwoZeroAfterInitialCenterMoveIsZero() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(2, 0))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroTwoForCorrectSecondResponseIsZero() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.X, new Point(0, 2))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroTwoForIncorrectSecondResponseIsOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 0)));
    assertEquals(1, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.X, new Point(0, 2))).getRating());
  }
  
  @Test
  public void testBestMoveRatingDepthForPointZeroTwoForDefiniteLossIsThree() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 1)));
    assertEquals(3, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(0, 2))).getDepth());
  }
  
  @Test
  public void testBestRatingForPointZeroTwoForADefinitelyLostGameIsNegativeOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 1)));
    assertEquals(-1, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(0, 2))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroOneForADefinitelyWonGameIsOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 1)));
    assertEquals(1, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.X, new Point(0, 1))).getRating());
  }
  
  @Test
  public void testBestMoveRatingDepthForPointZeroZeroForDefiniteLossIsOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 1)));
    assertEquals(1, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(0, 0))).getDepth());
  }
  
  @Test
  public void testBestRatingForPointZeroZeroForDefiniteLossIsNegativeOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 1)));
    assertEquals(-1, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(0, 0))).getRating());
  }
  
  @Test
  public void testBestMoveRatingDepthForEmptyBoardIsEight() {
    assertEquals(8, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(1, 1))).getDepth());
  }
  
  @Test
  public void testBestMoveRatingForPointZeroZeroAfterPointZeroOneIsZero() {
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 1)));
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new Move(TicTacToePiece.O, new Point(0, 0))).getRating());
  }

}
