package domain.entities.tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import domain.entities.MoveEntity;
import domain.entities.TicTacToePieceEntity;

public class MoveEntityTest {
  
  @Test
  public void testPieceForMoveIsX() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    assertEquals(TicTacToePieceEntity.X, move.getPiece());
  }
  
  @Test
  public void testPieceForMoveIsO() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    assertEquals(TicTacToePieceEntity.O, move.getPiece());
  }
  
  @Test
  public void testMoveIsForPointOneOne() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    assertEquals(pointToTake, move.getPoint());
  }

  @Test
  public void testMoveIsX() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    assertTrue(move.isForXPiece());
  }
  
  @Test
  public void testMoveIsO() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.O, pointToTake);
    assertTrue(move.isForOPiece());
  }
  
  @Test
  public void testPointForMoveIsOneOne() {
    Point pointToTake = new Point(1, 1);
    MoveEntity move = new MoveEntity(TicTacToePieceEntity.X, pointToTake);
    assertTrue(move.isForPoint(pointToTake));
  }

}