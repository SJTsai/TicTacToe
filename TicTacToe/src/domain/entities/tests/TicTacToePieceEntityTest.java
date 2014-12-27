package domain.entities.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.entities.TicTacToePieceEntity;

public class TicTacToePieceEntityTest {

  @Test
  public void testTicTacToePieceX() {
    TicTacToePieceEntity xPiece = TicTacToePieceEntity.X;
    assertEquals(TicTacToePieceEntity.X, xPiece);
  }
  
  @Test
  public void testTicTacToePieceO() {
    TicTacToePieceEntity oPiece = TicTacToePieceEntity.O;
    assertEquals(TicTacToePieceEntity.O, oPiece);
  }

}
