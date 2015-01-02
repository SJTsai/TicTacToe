package main.publicusecases.initializers.interfaces;

import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;
import main.publicusecases.moves.interfaces.MoveAdder;

public interface TicTacToeGameInitializerCallBack {

  public void onGameCreated(TicTacToeBoard board, MoveAdder moveAdder);
  public void onPlayerToPlay(TicTacToePiece piece);
}
