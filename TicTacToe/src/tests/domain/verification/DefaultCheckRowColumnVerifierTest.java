package tests.domain.verification;

import static org.junit.Assert.assertTrue;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.interfaces.CheckRowColumnVerifier;

import org.junit.Before;
import org.junit.Test;

public class DefaultCheckRowColumnVerifierTest {
  
  private TicTacToeBoardEntity board;
  private CheckRowColumnVerifier defaultCheckRowColumnVerifier;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoardEntity();
    defaultCheckRowColumnVerifier = new DefaultCheckRowColumnVerifier(board);
  }

  @Test
  public void testShouldCheckWinForFirstRowForPointZeroZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForFirstRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForFirstColumnForPointZeroZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForFirstColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForBackSlashDiagonalForPointZeroZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForBackSlashDiagonalForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForFirstRowForPointZeroOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForFirstRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForSecondColumnForPointZeroOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForSecondColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForFirstRowForPointZeroTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForFirstRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForThirdColumnForPointZeroTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForThirdColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForForwardSlashDiagonalForPointZeroTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForForwardSlashDiagonalForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForSecondRowForPointOneZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForSecondRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForFirstColumnForPointOneZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForFirstColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForSecondRowForPointOneOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForSecondRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForSecondColumnForPointOneOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForSecondColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForBackSlashDiagonalForPointOneOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForBackSlashDiagonalForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForForwardSlashDiagonalForPointOneOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForForwardSlashDiagonalForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForSecondRowForPointOneTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForSecondRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForThirdColumnForPointOneTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForThirdColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForThirdRowForPointTwoZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForThirdRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForFirstColumnForPointTwoZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForFirstColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForForwardSlashDiagonalForPointTwoZero() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForForwardSlashDiagonalForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForThirdRowForPointTwoOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForThirdRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForSecondColumnForPointTwoOne() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForSecondColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForThirdRowForPointTwoTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForThirdRowForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForThirdColumnForPointTwoTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForThirdColumnForMove(lastMoveMade));
  }
  
  @Test
  public void testShouldCheckWinForBackSlashDiagonalForPointTwoTwo() {
    MoveEntity lastMoveMade = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2));
    assertTrue(defaultCheckRowColumnVerifier.shouldCheckWinForBackSlashDiagonalForMove(lastMoveMade));
  }

}
