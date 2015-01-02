package main.publicusecases.moves.interfaces;

import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;

public interface TicTacToeMoveAdderCallBack {

  public void onMoveAdded(TicTacToeBoard board);
  public void onPlayerWon();
  public void onComputerWon();
  public void onTieGame();
  public void onPlayerTurn(TicTacToePiece piece);
  public void onComputerTurn(TicTacToePiece piece);
}
