package tests.formatter;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ttt.formatter.TicTacToeBoardFormatter;
import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;

public class TicTacToeBoardFormatterTest {
  
  private TicTacToeBoard board;
  private TicTacToeBoardFormatter ticTacToeBoardFormatter;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoard();
    ticTacToeBoardFormatter = new TicTacToeBoardFormatter();
  }

  @Test
  public void testBoardStringRepresentation1() {
    board.addMove(new Move(TicTacToePiece.O, new Point(0, 2)));
    board.addMove(new Move(TicTacToePiece.O, new Point(1, 0)));
    board.addMove(new Move(TicTacToePiece.O, new Point(2, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 1)));
    board.addMove(new Move(TicTacToePiece.X, new Point(1, 2)));
    board.addMove(new Move(TicTacToePiece.X, new Point(2, 0)));
    
    String boardStringRepresentation = ticTacToeBoardFormatter.format(board);
    assertEquals("   0  1  2\n0 [ ][ ][o]\n1 [o][x][x]\n2 [x][ ][o]", boardStringRepresentation);
  }

}
