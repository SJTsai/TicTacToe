package tests.domain.verification;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.DefaultWinnerVerifier;
import main.domain.verification.interfaces.CheckRowColumnVerifier;
import main.domain.verification.interfaces.WinnerVerifier;

import org.junit.Before;
import org.junit.Test;

public class DefaultWinnerVerifierTest {
  
  private TicTacToeBoardEntity board;
  private CheckRowColumnVerifier defaultCheckRowColumnVerifier;
  private WinnerVerifier defaultWinnerVerifier;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoardEntity();
    defaultCheckRowColumnVerifier = new DefaultCheckRowColumnVerifier();
    defaultWinnerVerifier = new DefaultWinnerVerifier(defaultCheckRowColumnVerifier);
  }

  @Test
  public void testPointZeroZeroWinsWithXsInFirstRowOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointZeroZeroWinsWithXsInFirstColumnOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointOneOneWinsWithXsInSecondRowOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointOneOneWinsWithXsInSecondColumnOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointTwoZeroWinsWithXsInThirdRowOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointZeroTwoWinsWithXsInThirdColumnOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointOneOneWinsWithXsInBackSlashDiagonalOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }
  
  @Test
  public void testPointOneOneWinsWithXsInForwardSlashDiagonalOnly() {
    MoveEntity moveToVerifyWin = new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1));
    board.addMove(moveToVerifyWin);
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
    assertTrue(defaultWinnerVerifier.verifyWinForBoardAndLastMoveMade(board, moveToVerifyWin));
  }

}
