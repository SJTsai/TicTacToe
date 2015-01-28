package tests.model;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import ttt.model.Move;
import ttt.model.TicTacToePiece;

public class MoveTest {
  
  @Test
  public void testPieceForMoveIsX() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.X, pointToTake);
    assertEquals(TicTacToePiece.X, move.getPiece());
  }
  
  @Test
  public void testPieceForMoveIsO() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.O, pointToTake);
    assertEquals(TicTacToePiece.O, move.getPiece());
  }
  
  @Test
  public void testMoveIsForPointOneOne() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.O, pointToTake);
    assertEquals(pointToTake, move.getPoint());
  }

  @Test
  public void testMoveIsX() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.X, pointToTake);
    assertTrue(move.isForXPiece());
  }
  
  @Test
  public void testMoveIsO() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.O, pointToTake);
    assertTrue(move.isForOPiece());
  }
  
  @Test
  public void testPointForMoveIsOneOne() {
    Point pointToTake = new Point(1, 1);
    Move move = new Move(TicTacToePiece.X, pointToTake);
    assertTrue(move.isForPoint(pointToTake));
  }

}
