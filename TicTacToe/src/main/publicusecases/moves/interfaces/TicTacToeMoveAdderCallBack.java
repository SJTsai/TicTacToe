package main.publicusecases.moves.interfaces;

import java.awt.Point;

import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;

public interface TicTacToeMoveAdderCallBack {

  public void onMoveAdded(TicTacToeBoard board, Point pointWhereAdded);
  public void onPlayerWon();
  public void onComputerWon();
  public void onTieGame();
  public void onPlayerTurn(TicTacToePiece piece);
  public void onComputerTurn(TicTacToePiece piece);
  public void onPlayerMoveOutOfBounds(Point point);
}
