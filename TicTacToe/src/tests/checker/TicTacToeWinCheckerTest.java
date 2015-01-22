package tests.checker;

import static org.junit.Assert.*;

import java.awt.Point;

import main.checker.TicTacToeWinChecker;
import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeWinCheckerTest {
  
  private TicTacToeWinChecker winChecker;
  private TicTacToeBoardEntity board;

  @Before
  public void setUp() throws Exception {
    winChecker = new TicTacToeWinChecker();
    board = new TicTacToeBoardEntity();
  }

  @Test
  public void testEmptyBoardIsNotWinningStateForAnyPiece() {
    assertFalse(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForFirstColumn() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 0)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 0)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 0)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForSecondColumn() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 1)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForThirdColumn() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 2)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 2)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForFirstRow() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 0)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 2)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForSecondRow() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 0)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 2)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForThirdRow() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 0)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForBackSlashDiagonal() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 0)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testWinForForwardSlashDiagonal() {
    TicTacToePieceEntity pieceToAdd = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(pieceToAdd, new Point(0, 2)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(1, 1)));
    board.addMove(new MoveEntity(pieceToAdd, new Point(2, 0)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testBoardIsInWinningState() {
    TicTacToePieceEntity xPiece = TicTacToePieceEntity.X;
    TicTacToePieceEntity oPiece = TicTacToePieceEntity.O;
    board.addMove(new MoveEntity(xPiece, new Point(1, 1)));
    board.addMove(new MoveEntity(oPiece, new Point(2, 1)));
    board.addMove(new MoveEntity(xPiece, new Point(2, 0)));
    board.addMove(new MoveEntity(oPiece, new Point(0, 2)));
    board.addMove(new MoveEntity(xPiece, new Point(0, 0)));
    board.addMove(new MoveEntity(oPiece, new Point(1, 0)));
    board.addMove(new MoveEntity(xPiece, new Point(2, 2)));
    assertTrue(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testBoardIsNotInWinningState() {
    TicTacToePieceEntity xPiece = TicTacToePieceEntity.X;
    TicTacToePieceEntity oPiece = TicTacToePieceEntity.O;
    board.addMove(new MoveEntity(xPiece, new Point(1, 1)));
    board.addMove(new MoveEntity(oPiece, new Point(2, 1)));
    board.addMove(new MoveEntity(xPiece, new Point(2, 0)));
    board.addMove(new MoveEntity(oPiece, new Point(0, 2)));
    board.addMove(new MoveEntity(xPiece, new Point(0, 0)));
    board.addMove(new MoveEntity(oPiece, new Point(1, 0)));
    assertFalse(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testBoardIsNotInWinningStateFor2XsAnd1o() {
    TicTacToePieceEntity xPiece = TicTacToePieceEntity.X;
    TicTacToePieceEntity oPiece = TicTacToePieceEntity.O;
    board.addMove(new MoveEntity(xPiece, new Point(0, 0)));
    board.addMove(new MoveEntity(xPiece, new Point(1, 1)));
    board.addMove(new MoveEntity(oPiece, new Point(2, 2)));
    assertFalse(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }
  
  @Test
  public void testBoardIsNotInWinningStateFor2Xs() {
    TicTacToePieceEntity xPiece = TicTacToePieceEntity.X;
    board.addMove(new MoveEntity(xPiece, new Point(0, 0)));
    board.addMove(new MoveEntity(xPiece, new Point(1, 1)));
    assertFalse(winChecker.isWinningStateForPieceOnBoard(TicTacToePieceEntity.X, board));
  }

}
