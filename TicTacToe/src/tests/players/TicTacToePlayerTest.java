package tests.players;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.players.TicTacToePlayer;

import org.junit.Before;
import org.junit.Test;

public class TicTacToePlayerTest {
  
  private TicTacToeBoardEntity board;
  private TicTacToePlayer player;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoardEntity();
    player = new TicTacToePlayer(TicTacToePieceEntity.X, board, false);
  }

  @Test
  public void testPieceIsRecordedProperly() {
    Point pointToTake = new Point(1, 1);
    player.makeMoveAtPoint(pointToTake);
    assertEquals(TicTacToePieceEntity.X, board.getPieceForPoint(pointToTake));
    assertTrue(board.doXPointsContainPoint(pointToTake));
    assertFalse(board.isEmpty());
    assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
    assertTrue(board.isPointTaken(pointToTake));
    assertTrue(board.isPieceAtPointXPiece(pointToTake));
  }

}
