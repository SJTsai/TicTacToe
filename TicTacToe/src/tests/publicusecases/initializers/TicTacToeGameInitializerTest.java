package tests.publicusecases.initializers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;
import main.publicusecases.initializers.TicTacToeGameInitializer;
import main.publicusecases.initializers.interfaces.GameInitializer;
import main.publicusecases.initializers.interfaces.TicTacToeGameInitializerCallBack;
import main.publicusecases.moves.interfaces.MoveAdder;
import main.publicusecases.moves.interfaces.TicTacToeMoveAdderCallBack;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeGameInitializerTest implements TicTacToeGameInitializerCallBack, TicTacToeMoveAdderCallBack {
  
  // Note: I am testing the TicTacToeGameInitializerCallBack, so TicTacToeMoveAdderCallBack methods
  // are unimplemented.  I just need to pass in a TicTacToeMoveAdderCallBack into TicTacToeGameInitializer's
  // constructor.
  
  private GameInitializer ticTacToeGameInitializer;
  private TicTacToeBoard board;
  private MoveAdder moveAdder;
  private TicTacToePiece pieceToPlay;
  
  @Before
  public void setUp() {
    ticTacToeGameInitializer = new TicTacToeGameInitializer(this, this);
    ticTacToeGameInitializer.initializeGame();
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
  public void testXPointsIsEmpty() {
    assertTrue(board.getXPoints().size() == 0);
  }
  
  @Test
  public void testOPointsIsEmpty() {
    assertTrue(board.getOPoints().size() == 0);
  }
  
  @Test
  public void testBoardEmpty() {
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.isPointTaken(new Point(row, column)));
  }
  
  @Test
  public void testBoardContainsNoOPoints() {
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.isXPieceAtPoint(new Point(row, column)));
  }
  
  @Test
  public void testBoardContainsNoXPoints() {
    for (int row = 0; row < board.getNumberOfRows(); row++)
      for (int column = 0; column < board.getNumberOfColumns(); column++)
        assertFalse(board.isOPieceAtPoint(new Point(row, column)));
  }
  
  @Test
  public void testMoveAdderIsNotNull() {
    assertTrue(moveAdder != null);
  }
  
  @Test
  public void testPieceForPlayerToPlayIsX() {
    assertEquals(TicTacToePiece.X, pieceToPlay);
  }
  
  @Test
  public void testMoveAdderNotNullWhenPlayerToPlay() {
    assertTrue(moveAdder != null);
  }
  
  @Override
  public void onGameCreated(TicTacToeBoard board, MoveAdder moveAdder) {
    this.board = board;
    this.moveAdder = moveAdder;
  }
  
  @Override
  public void onPlayerToPlay(TicTacToePiece piece) {
    this.pieceToPlay = piece;
  };

  @Override
  public void onMoveAdded(TicTacToeBoard board) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void onPlayerWon() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void onComputerWon() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void onTieGame() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void onPlayerTurn(TicTacToePiece piece) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void onComputerTurn(TicTacToePiece piece) {
    // TODO Auto-generated method stub
    
  }

}
