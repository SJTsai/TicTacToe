package tests.domain.keepers;

import static org.junit.Assert.*;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;
import main.domain.keepers.AlternatingTurnKeeper;
import main.domain.keepers.interfaces.TurnKeeper;

import org.junit.Before;
import org.junit.Test;

public class AlternatingTurnKeeperTest {
  
  private TicTacToePlayerEntity player1;
  private TicTacToePlayerEntity player2;
  private TurnKeeper alternatingTurnKeeper;

  @Before
  public void setUp() throws Exception {
    player1 = new TicTacToePlayerEntity(TicTacToePieceEntity.X, false);
    player2 = new TicTacToePlayerEntity(TicTacToePieceEntity.O, true);
    alternatingTurnKeeper = new AlternatingTurnKeeper(player1, player2);
  }

  @Test
  public void testNextPlayerWithoutSettingFirstPlayerIsPlayerOne() {
    assertTrue(player1.equals(alternatingTurnKeeper.switchToNextPlayer()));
  }
  
  @Test
  public void testCurrentPlayerAfterSettingFirstPlayerIsPlayerOne() {
    alternatingTurnKeeper.setCurrentPlayer(player1);
    assertTrue(player1.equals(alternatingTurnKeeper.getCurrentPlayer()));
  }
  
  @Test
  public void testCurrentPlayerWithoutSettingFirstPlayerIsPlayerOne() {
    assertTrue(player1.equals(alternatingTurnKeeper.getCurrentPlayer()));
  }
  
  @Test
  public void testNextPlayerAfterSettingFirstPlayerIsPlayerTwo() {
    alternatingTurnKeeper.setCurrentPlayer(player1);
    assertTrue(player2.equals(alternatingTurnKeeper.switchToNextPlayer()));
  }
  
  @Test
  public void testNextPlayerAfterSettingFirstPlayerIsPlayerOne() {
    alternatingTurnKeeper.setCurrentPlayer(player2);
    assertTrue(player1.equals(alternatingTurnKeeper.switchToNextPlayer()));
  }
  
  @Test
  public void testCurrentPlayerAfterSwitchingToNextPlayerIsPlayerOne() {
    alternatingTurnKeeper.setCurrentPlayer(player2);
    alternatingTurnKeeper.switchToNextPlayer();
    assertTrue(player1.equals(alternatingTurnKeeper.getCurrentPlayer()));
  }
  
  @Test
  public void testPieceForCurrentPlayerIsX() {
    alternatingTurnKeeper.setCurrentPlayer(player1);
    assertEquals(TicTacToePieceEntity.X, alternatingTurnKeeper.getPieceForCurrentPlayer());
  }
  
  @Test
  public void testPieceForCurrentPlayerAfterSwitchingIsO() {
    alternatingTurnKeeper.setCurrentPlayer(player1);
    alternatingTurnKeeper.switchToNextPlayer();
    assertEquals(TicTacToePieceEntity.O, alternatingTurnKeeper.getPieceForCurrentPlayer());
  }
  
  @Test
  public void testPlayerWithoutSettingCurrentPlayerIsNotComputer() {
    assertFalse(alternatingTurnKeeper.isCurrentPlayerAComputer());
  }
  
  @Test
  public void testPlayerAfterSettingPlayerIsNotComputer() {
    alternatingTurnKeeper.setCurrentPlayer(player1);
    assertFalse(alternatingTurnKeeper.isCurrentPlayerAComputer());
  }
  
  @Test
  public void testPlayerAfterSettingPlayerIsComputer() {
    alternatingTurnKeeper.setCurrentPlayer(player2);
    assertTrue(alternatingTurnKeeper.isCurrentPlayerAComputer());
  }
  
  @Test
  public void testPlayerAfterSwitchingIsComputer() {
    alternatingTurnKeeper.setCurrentPlayer(player1);
    alternatingTurnKeeper.switchToNextPlayer();
    assertTrue(alternatingTurnKeeper.isCurrentPlayerAComputer());
  }
  
  @Test
  public void testPlayerAfterSwitchingIsNotComputer() {
    alternatingTurnKeeper.setCurrentPlayer(player2);
    alternatingTurnKeeper.switchToNextPlayer();
    assertFalse(alternatingTurnKeeper.isCurrentPlayerAComputer());
  }

}
