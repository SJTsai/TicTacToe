package main.domain.keepers.interfaces;

import main.domain.entities.TicTacToePlayerEntity;

public interface TurnKeeper {

  public TicTacToePlayerEntity getNextPlayer();
}
