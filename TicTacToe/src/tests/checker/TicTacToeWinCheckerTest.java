package tests.checker;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ttt.checker.TicTacToeWinChecker;
import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;

public class TicTacToeWinCheckerTest {
  
  private TicTacToeWinChecker winChecker;
  private TicTacToeBoard board;

  @Before
  public void setUp() throws Exception {
    winChecker = new TicTacToeWinChecker();
    board = new TicTacToeBoard();
  }

  @Test
  public void testEmptyBoardIsNotWinningStateForAnyPiece() {
    for (int row = 0; row < 3; row++)
      for (int column = 0; column < 3; column++)
        assertFalse(winChecker.isWinningStateForMoveOnBoard(new Move(TicTacToePiece.X, new Point(row, column)), board));
  }
  
  @Test
  public void testWinForFirstColumn() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(0, 0)));
    board.addMove(new Move(pieceToAdd, new Point(1, 0)));
    board.addMove(new Move(pieceToAdd, new Point(2, 0)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(2, 0)), board));
  }
  
  @Test
  public void testWinForSecondColumn() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(0, 1)));
    board.addMove(new Move(pieceToAdd, new Point(1, 1)));
    board.addMove(new Move(pieceToAdd, new Point(2, 1)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(2, 1)), board));
  }
  
  @Test
  public void testWinForThirdColumn() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(0, 2)));
    board.addMove(new Move(pieceToAdd, new Point(1, 2)));
    board.addMove(new Move(pieceToAdd, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(2, 2)), board));
  }
  
  @Test
  public void testWinForFirstRow() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(0, 0)));
    board.addMove(new Move(pieceToAdd, new Point(0, 1)));
    board.addMove(new Move(pieceToAdd, new Point(0, 2)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(0, 2)), board));
  }
  
  @Test
  public void testWinForSecondRow() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(1, 0)));
    board.addMove(new Move(pieceToAdd, new Point(1, 1)));
    board.addMove(new Move(pieceToAdd, new Point(1, 2)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(1, 2)), board));
  }
  
  @Test
  public void testWinForThirdRow() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(2, 0)));
    board.addMove(new Move(pieceToAdd, new Point(2, 1)));
    board.addMove(new Move(pieceToAdd, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(2, 2)), board));
  }
  
  @Test
  public void testWinForBackSlashDiagonal() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(0, 0)));
    board.addMove(new Move(pieceToAdd, new Point(1, 1)));
    board.addMove(new Move(pieceToAdd, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(2, 2)), board));
  }
  
  @Test
  public void testWinForForwardSlashDiagonal() {
    TicTacToePiece pieceToAdd = TicTacToePiece.X;
    board.addMove(new Move(pieceToAdd, new Point(0, 2)));
    board.addMove(new Move(pieceToAdd, new Point(1, 1)));
    board.addMove(new Move(pieceToAdd, new Point(2, 0)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(pieceToAdd, new Point(2, 0)), board));
  }
  
  @Test
  public void testBoardIsInWinningState() {
    TicTacToePiece xPiece = TicTacToePiece.X;
    TicTacToePiece oPiece = TicTacToePiece.O;
    board.addMove(new Move(xPiece, new Point(1, 1)));
    board.addMove(new Move(oPiece, new Point(2, 1)));
    board.addMove(new Move(xPiece, new Point(2, 0)));
    board.addMove(new Move(oPiece, new Point(0, 2)));
    board.addMove(new Move(xPiece, new Point(0, 0)));
    board.addMove(new Move(oPiece, new Point(1, 0)));
    board.addMove(new Move(xPiece, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForMoveOnBoard(new Move(xPiece, new Point(2, 2)), board));
  }
  
  @Test
  public void testBoardIsNotInWinningState() {
    TicTacToePiece xPiece = TicTacToePiece.X;
    TicTacToePiece oPiece = TicTacToePiece.O;
    board.addMove(new Move(xPiece, new Point(1, 1)));
    board.addMove(new Move(oPiece, new Point(2, 1)));
    board.addMove(new Move(xPiece, new Point(2, 0)));
    board.addMove(new Move(oPiece, new Point(0, 2)));
    board.addMove(new Move(xPiece, new Point(0, 0)));
    board.addMove(new Move(oPiece, new Point(1, 0)));
    assertFalse(winChecker.isWinningStateForMoveOnBoard(new Move(xPiece, new Point(0, 0)), board));
  }
  
  @Test
  public void testBoardIsNotInWinningStateFor2XsAnd1o() {
    TicTacToePiece xPiece = TicTacToePiece.X;
    TicTacToePiece oPiece = TicTacToePiece.O;
    board.addMove(new Move(xPiece, new Point(0, 0)));
    board.addMove(new Move(xPiece, new Point(1, 1)));
    board.addMove(new Move(oPiece, new Point(2, 2)));
    assertFalse(winChecker.isWinningStateForMoveOnBoard(new Move(xPiece, new Point(1, 1)), board));
  }
  
  @Test
  public void testBoardIsNotInWinningStateFor2Xs() {
    TicTacToePiece xPiece = TicTacToePiece.X;
    board.addMove(new Move(xPiece, new Point(0, 0)));
    board.addMove(new Move(xPiece, new Point(1, 1)));
    assertFalse(winChecker.isWinningStateForMoveOnBoard(new Move(xPiece, new Point(1, 1)), board));
  }

}
