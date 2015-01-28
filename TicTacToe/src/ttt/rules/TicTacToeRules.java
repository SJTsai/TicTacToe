package ttt.rules;

import java.awt.Point;

import ttt.model.TicTacToeBoard;

public class TicTacToeRules {

  private TicTacToeBoard board;
  
  public TicTacToeRules(TicTacToeBoard board) {
    this.board = board;
  }
  
  public boolean isPointOutOfBounds(Point point) {
    return point.x < 0 || point.x >= board.getNumberOfRows() ||
        point.y < 0 || point.y >= board.getNumberOfColumns();
  }
  
  public boolean isPointTaken(Point point) {
    return board.isPointTaken(point);
  }
}
