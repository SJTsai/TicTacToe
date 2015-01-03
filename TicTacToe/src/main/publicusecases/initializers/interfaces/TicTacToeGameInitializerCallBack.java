package main.publicusecases.initializers.interfaces;

import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;
import main.publicusecases.moves.interfaces.MoveAdder;

public interface TicTacToeGameInitializerCallBack {

  public void onGameCreated(TicTacToeBoard board, MoveAdder moveAdder);
  public void onPlayerToStart(TicTacToePiece piece);
  public void onComputerToStart(TicTacToePiece piece);
}
