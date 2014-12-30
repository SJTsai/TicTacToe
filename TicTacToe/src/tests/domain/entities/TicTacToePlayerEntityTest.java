package tests.domain.entities;

import static org.junit.Assert.*;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;

import org.junit.Test;

public class TicTacToePlayerEntityTest {

  @Test
  public void testTicTacToePlayerIsPlayingX() {
    assertEquals(TicTacToePieceEntity.X, new TicTacToePlayerEntity(TicTacToePieceEntity.X, false).getPiece());
  }
  
  @Test
  public void testTicTacToePlayerIsPlayingO() {
    assertEquals(TicTacToePieceEntity.O, new TicTacToePlayerEntity(TicTacToePieceEntity.O, false).getPiece());
  }
  
  @Test
  public void testTicTacToePlayerIsXPlayer() {
    assertTrue(new TicTacToePlayerEntity(TicTacToePieceEntity.X, false).isXPlayer());
  }
  
  @Test
  public void testTicTacToePlayerIsOPlayer() {
    assertTrue(new TicTacToePlayerEntity(TicTacToePieceEntity.O, false).isOPlayer());
  }
  
  @Test
  public void testTicTacToePlayerIsNotXPlayer() {
    assertFalse(new TicTacToePlayerEntity(TicTacToePieceEntity.O, false).isXPlayer());
  }
  
  @Test
  public void testTicTacToePlayerIsNotOPlayer() {
    assertFalse(new TicTacToePlayerEntity(TicTacToePieceEntity.X, false).isOPlayer());
  }
  
  @Test
  public void testTicTacToePlayerIsNotComputer() {
    assertFalse(new TicTacToePlayerEntity(TicTacToePieceEntity.X, false).isComputer());
  }
  
  @Test
  public void testTicTacToePlayerIsComputer() {
    assertTrue(new TicTacToePlayerEntity(TicTacToePieceEntity.X, true).isComputer());
  }

}
