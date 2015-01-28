package tests.players;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;
import ttt.player.TicTacToePlayer;

public class TicTacToePlayerTest {
  
  private TicTacToeBoard board;
  private TicTacToePlayer player;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoard();
    player = new TicTacToePlayer(TicTacToePiece.X, board, false);
  }

  @Test
  public void testPieceIsRecordedProperly() {
    Point pointToTake = new Point(1, 1);
    player.makeMoveAtPoint(pointToTake);
    assertEquals(TicTacToePiece.X, board.getPieceForPoint(pointToTake));
    assertTrue(board.doXPointsContainPoint(pointToTake));
    assertFalse(board.isEmpty());
    assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
    assertTrue(board.isPointTaken(pointToTake));
    assertTrue(board.isPieceAtPointXPiece(pointToTake));
  }

}
