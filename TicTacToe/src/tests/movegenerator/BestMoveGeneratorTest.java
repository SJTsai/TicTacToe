package tests.movegenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;
import ttt.movegenerator.BestMoveGenerator;

public class BestMoveGeneratorTest {
  
  private TicTacToeBoard board;
  private BestMoveGenerator bestMoveGenerator;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoard();
    bestMoveGenerator = new BestMoveGenerator();
  }
  
  @Test
  public void testBestMoveForLostGameIsPointZeroTwo() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 1)));
    assertEquals(new Point(0, 2), bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePiece.O).getPoint());
  }
  
  @Test
  public void testBestMoveAfterIncorrectSecondMove() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 0)));
    List<Point> goodMoves = new ArrayList<Point>();
    goodMoves.add(new Point(0, 0));
    goodMoves.add(new Point(0, 2));
    goodMoves.add(new Point(2, 0));
    goodMoves.add(new Point(2, 2));
    Move bestMove = bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePiece.X);
    assertTrue(goodMoves.contains(bestMove.getPoint()));
  }
  
  @Test
  public void testBestMoveAfterPointOneOneIsPointZeroZero() {
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    Move bestMove = bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePiece.O);
    Point expectedPoint = new Point(0, 0);
    assertEquals(expectedPoint, bestMove.getPoint());
  }
  
  @Test
  public void testBestMoveAfterPointTwoTwoIsPointOneOne() {
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 2)));
    Move bestMove = bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePiece.O);
    Point expectedPoint = new Point(1, 1);
    assertEquals(expectedPoint, bestMove.getPoint());
  }
  
  @Test
  public void testBestmoveAfterMovingToPointOneOneAndZeroZeroIsPointTwoTwo() {
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(0, 0)));
    Move bestMove = bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePiece.O);
    Point expectedPoint = new Point(2, 2);
    assertEquals(expectedPoint, bestMove.getPoint());
  }
}
