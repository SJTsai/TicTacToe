package tests.publicusecases.moves;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;
import main.domain.keepers.AlternatingTurnKeeper;
import main.domain.keepers.interfaces.TurnKeeper;
import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;
import main.domain.movegenerator.BestMoveGenerator;
import main.domain.movegenerator.BestMoveRatingGenerator;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.DefaultWinnerVerifier;
import main.domain.verification.interfaces.WinnerVerifier;
import main.publicusecases.moves.TicTacToeMoveAdder;
import main.publicusecases.moves.interfaces.MoveAdder;
import main.publicusecases.moves.interfaces.TicTacToeMoveAdderCallBack;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeMoveAdderTest implements TicTacToeMoveAdderCallBack {
  
  private MoveAdder ticTacToeMoveAdder;
  private TicTacToeBoardEntity boardEntity;
  private TicTacToeBoard board;
  private boolean isPlayerTurn;
  private boolean didPlayerWin;
  private boolean didComputerWin;
  private boolean didGameTie;
  private Point pointOutOfBounds;

  @Before
  public void setUp() throws Exception {
    boardEntity = new TicTacToeBoardEntity();
    
    TicTacToePlayerEntity humanPlayer = new TicTacToePlayerEntity(TicTacToePieceEntity.X, false);
    TicTacToePlayerEntity computerPlayer = new TicTacToePlayerEntity(TicTacToePieceEntity.O, true);
    TurnKeeper alternatingTurnKeeper = new AlternatingTurnKeeper(humanPlayer, computerPlayer);
    
    WinnerVerifier defaultWinnerVerifier = new DefaultWinnerVerifier(new DefaultCheckRowColumnVerifier());
    
    MoveGenerator bestMoveGenerator = new BestMoveGenerator(new BestMoveRatingGenerator(defaultWinnerVerifier));
    
    ticTacToeMoveAdder = new TicTacToeMoveAdder(boardEntity, alternatingTurnKeeper, defaultWinnerVerifier, bestMoveGenerator, this);
    
    isPlayerTurn = true;
    didPlayerWin = false;
    didComputerWin = false;
    didGameTie = false;
  }
  
  @Test
  public void testComputerHasntGoneYet() {
    assertTrue(isPlayerTurn);
  }

  @Test
  public void testBoardContainsXOnPointOneOne() {
    Point pointToTake = new Point(1, 1);
    ticTacToeMoveAdder.addMove(pointToTake);
    assertTrue(board.isXPieceAtPoint(pointToTake));
  }
  
  @Test
  public void testComputerMadeMove() {
    Point pointToTake = new Point(1, 1);
    ticTacToeMoveAdder.addMove(pointToTake);
    assertFalse(board.getOPoints().isEmpty());
  }
  
  @Test
  public void testBoardContainsXOnTwoOne() {
    Point pointToTake = new Point(2, 1);
    ticTacToeMoveAdder.addMove(new Point(1, 1));
    ticTacToeMoveAdder.addMove(pointToTake);
    assertTrue(board.isXPieceAtPoint(new Point(1, 1)));
    assertTrue(board.isXPieceAtPoint(pointToTake));
  }
  
  @Test
  public void testComputerWon() {
    ticTacToeMoveAdder.addMove(new Point(1, 1));
    ticTacToeMoveAdder.addMove(new Point(2, 1));
    ticTacToeMoveAdder.addMove(new Point(2, 2));
    assertTrue(didComputerWin);
  }
  
  @Test
  public void testGameTie() {
    ticTacToeMoveAdder.addMove(new Point(1, 1));
    ticTacToeMoveAdder.addMove(new Point(2, 1));
    ticTacToeMoveAdder.addMove(new Point(0, 2));
    ticTacToeMoveAdder.addMove(new Point(1, 0));
    ticTacToeMoveAdder.addMove(new Point(2, 2));
    assertTrue(didGameTie);
  }
  
  @Test
  public void testPlayerDidNotWin() {
    ticTacToeMoveAdder.addMove(new Point(1, 1));
    ticTacToeMoveAdder.addMove(new Point(2, 1));
    ticTacToeMoveAdder.addMove(new Point(0, 2));
    ticTacToeMoveAdder.addMove(new Point(1, 0));
    ticTacToeMoveAdder.addMove(new Point(2, 2));
    assertFalse(didPlayerWin);
  }
  
  @Test
  public void testColumnExceedsNumberOfColumns() {
    Point pointOutOfBounds = new Point(2, 3);
    ticTacToeMoveAdder.addMove(pointOutOfBounds);
    assertEquals(this.pointOutOfBounds, pointOutOfBounds);
  }
  
  @Test
  public void testColumnLessThanZero() {
    Point pointOutOfBounds = new Point(2, -1);
    ticTacToeMoveAdder.addMove(pointOutOfBounds);
    assertEquals(this.pointOutOfBounds, pointOutOfBounds);
  }
  
  @Test
  public void testRowExceedsNumberOfRows() {
    Point pointOutOfBounds = new Point(3, 0);
    ticTacToeMoveAdder.addMove(pointOutOfBounds);
    assertEquals(this.pointOutOfBounds, pointOutOfBounds);
  }
  
  @Test
  public void testRowLessThanZero() {
    Point pointOutOfBounds = new Point(-1, 0);
    ticTacToeMoveAdder.addMove(pointOutOfBounds);
    assertEquals(this.pointOutOfBounds, pointOutOfBounds);
  }

  @Override
  public void onMoveAdded(TicTacToeBoard board) {
    this.board = board;
  }

  @Override
  public void onPlayerWon() {
    didPlayerWin = true;
  }

  @Override
  public void onComputerWon() {
    didComputerWin = true;
  }

  @Override
  public void onTieGame() {
    didGameTie = true;
  }

  @Override
  public void onPlayerTurn(TicTacToePiece piece) {
    isPlayerTurn = true;
  }

  @Override
  public void onComputerTurn(TicTacToePiece piece) {
    isPlayerTurn = false;
  }
  
  @Override
  public void onPlayerMoveOutOfBounds(Point point) {
    pointOutOfBounds = point;
  }

}
