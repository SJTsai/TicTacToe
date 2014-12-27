package tests.domain.entities;

import static org.junit.Assert.*;
import main.domain.entities.TicTacToePieceEntity;

import org.junit.Test;

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
