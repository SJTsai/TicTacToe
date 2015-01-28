package tests.model;

import static org.junit.Assert.*;

import org.junit.Test;

import ttt.model.TicTacToePiece;

public class TicTacToePieceTest {

  @Test
  public void testTicTacToePieceX() {
    TicTacToePiece xPiece = TicTacToePiece.X;
    assertEquals(TicTacToePiece.X, xPiece);
  }
  
  @Test
  public void testTicTacToePieceO() {
    TicTacToePiece oPiece = TicTacToePiece.O;
    assertEquals(TicTacToePiece.O, oPiece);
  }

}
