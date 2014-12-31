package main.domain.keepers;

import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;
import main.domain.keepers.interfaces.TurnKeeper;

public class AlternatingTurnKeeper implements TurnKeeper {
  
  private TicTacToePlayerEntity player1;
  private TicTacToePlayerEntity player2;
  private TicTacToePlayerEntity currentPlayer;
  
  public AlternatingTurnKeeper(TicTacToePlayerEntity player1, TicTacToePlayerEntity player2) {
    this.player1 = player1;
    this.player2 = player2;
  }
  
  @Override
  public void setCurrentPlayer(TicTacToePlayerEntity currentPlayer) {
    this.currentPlayer = currentPlayer;
  }
  
  @Override
  public TicTacToePlayerEntity getCurrentPlayer() {
    if (currentPlayer == null)
      currentPlayer = player1;
    return currentPlayer;
  }

  @Override
  public TicTacToePlayerEntity switchToNextPlayer() {
    if (currentPlayer == null) {
      currentPlayer = player1;
      return currentPlayer;
    }
    
    if (currentPlayer.equals(player1)) {
      currentPlayer = player2;
      return currentPlayer;
    }
    
    currentPlayer = player1;
    return currentPlayer;
  }

  @Override
  public TicTacToePieceEntity getPieceForCurrentPlayer() {
    return getCurrentPlayer().getPiece();
  }

  @Override
  public boolean isCurrentPlayerAComputer() {
    return getCurrentPlayer().isComputer();
  }

}
