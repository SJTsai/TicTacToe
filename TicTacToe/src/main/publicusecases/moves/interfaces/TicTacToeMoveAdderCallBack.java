package main.publicusecases.moves.interfaces;

import main.domain.models.TicTacToeBoard;

public interface TicTacToeMoveAdderCallBack {

  public void onMoveAdded(TicTacToeBoard board);
  public void onPlayerWon();
  public void onComputerWon();
  public void onTieGame();
  public void onPlayerTurn();
  public void onComputerTurn();
}
