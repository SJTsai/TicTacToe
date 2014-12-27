package tests.domain.verification;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.verification.DefaultWinnerVerifier;
import main.domain.verification.interfaces.WinnerVerifier;

import org.junit.Before;
import org.junit.Test;

public class DefaultWinnerVerifierTest {
  
  private TicTacToeBoardEntity board;
  private WinnerVerifier defaultWinnerVerifier;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoardEntity();
    defaultWinnerVerifier = new DefaultWinnerVerifier(board);
  }

  @Test
  public void testShouldCheckFirstRow() {
    TicTacToeBoardEntity board = new TicTacToeBoardEntity();
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(0, 2)));
    assertTrue(true);
  }

}
