package tests.domain.movegenerator;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.movegenerator.BestMoveRatingGenerator;
import main.domain.movegenerator.interfaces.MoveRatingGenerator;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.DefaultWinnerVerifier;

import org.junit.Before;
import org.junit.Test;

public class BestMoveRatingGeneratorTest {
  
  private TicTacToeBoardEntity board;
  private MoveRatingGenerator bestMoveRatingGenerator;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoardEntity();
    bestMoveRatingGenerator = new BestMoveRatingGenerator(new DefaultWinnerVerifier(new DefaultCheckRowColumnVerifier()));
  }

  @Test
  public void testBestRatingForPointOneOneOnEmptyBoardIsZero() {
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroZeroOnEmptyBoardIsZero() {
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroOneOnEmptyBoardIsZero() {
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroOneAfterInitialCenterMoveIsNegativeOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    assertEquals(-1, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(0, 1))).getRating());
  }
  
  @Test
  public void testBestRatingForPointTwoZeroAfterInitialCenterMoveIsZero() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroTwoForCorrectSecondResponseIsZero() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    assertEquals(0, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroTwoForIncorrectSecondResponseIsOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 0)));
    assertEquals(1, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2))).getRating());
  }
  
  @Test
  public void testBestMoveRatingDepthForPointZeroTwoForDefiniteLossIsThree() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 1)));
    assertEquals(3, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(0, 2))).getDepth());
  }
  
  @Test
  public void testBestRatingForPointZeroTwoForADefinitelyLostGameIsNegativeOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 1)));
    assertEquals(-1, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(0, 2))).getRating());
  }
  
  @Test
  public void testBestRatingForPointZeroOneForADefinitelyWonGameIsOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 1)));
    assertEquals(1, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1))).getRating());
  }
  
  @Test
  public void testBestMoveRatingDepthForPointZeroZeroForDefiniteLossIsOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 1)));
    assertEquals(1, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0))).getDepth());
  }
  
  @Test
  public void testBestRatingForPointZeroZeroForDefiniteLossIsNegativeOne() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 1)));
    assertEquals(-1, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(0, 0))).getRating());
  }
  
  @Test
  public void testBestMoveRatingDepthForEmptyBoardIsEight() {
    assertEquals(8, bestMoveRatingGenerator.getMoveRating(board, new MoveEntity(TicTacToePieceEntity.O, new Point(1, 1))).getDepth());
  }

}
