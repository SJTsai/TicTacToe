package main.domain.keepers.interfaces;

import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;

public interface TurnKeeper {

  public void setCurrentPlayer(TicTacToePlayerEntity currentPlayer);
  public TicTacToePlayerEntity getCurrentPlayer();
  public TicTacToePlayerEntity switchToNextPlayer();
  public TicTacToePieceEntity getPieceForCurrentPlayer();
  public boolean isCurrentPlayerAComputer();
}
