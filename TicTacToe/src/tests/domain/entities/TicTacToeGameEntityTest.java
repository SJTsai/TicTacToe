package tests.domain.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToeGameEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;
import main.domain.keepers.AlternatingTurnKeeper;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameEntityTest {
  
  private TicTacToePlayerEntity player1, player2;
  private TicTacToeGameEntity game;

  @Before
  public void setUp() throws Exception {
    player1 = new TicTacToePlayerEntity(TicTacToePieceEntity.X, false);
    player2 = new TicTacToePlayerEntity(TicTacToePieceEntity.O, true);
    game = new TicTacToeGameEntity(new AlternatingTurnKeeper(player1, player2));
  }

  @Test
  public void testAddXPieceToGameForPointOneOne() {
    Point pointToTake = new Point(1, 1);
    game.addPieceToPointForCurrentPlayer(pointToTake);
    TicTacToeBoardEntity board = game.getBoard();
    assertTrue(board.doXPointsContainPoint(pointToTake));
    assertEquals(1, board.getNumberOfXPiecesOnTheBoard());
    assertTrue(board.isPieceAtPointXPiece(pointToTake));
  }
  
//  @Test
//  public void testCurrentPlayerIsPlayer2AfterMakingMove() {
//    Point pointToTake = new Point(1, 1);
//    game.addPieceToPointForCurrentPlayer(pointToTake);
//    assertTrue(player2.equals(game.getCurrentPlayer()));
//  }

}
