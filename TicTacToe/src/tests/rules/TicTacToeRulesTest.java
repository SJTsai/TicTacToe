package tests.rules;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;
import ttt.rules.TicTacToeRules;

public class TicTacToeRulesTest {
  
  private TicTacToeBoard board;
  private TicTacToeRules rules;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoard();
    rules = new TicTacToeRules(board);
  }

  @Test
  public void testPointIsTaken() {
    Point pointToTake = new Point(1, 1);
    board.addMove(new Move(TicTacToePiece.O, pointToTake));
    assertTrue(rules.isPointTaken(pointToTake));
  }
  
  @Test
  public void testPointsAreOutOfBounds() {
    Point outOfBoundsPoint1 = new Point(-1, 1);
    Point outOfBoundsPoint2 = new Point(3, 1);
    Point outOfBoundsPoint3 = new Point(0, -1);
    Point outOfBoundsPoint4 = new Point(0, 3);
    assertTrue(rules.isPointOutOfBounds(outOfBoundsPoint1));
    assertTrue(rules.isPointOutOfBounds(outOfBoundsPoint2));
    assertTrue(rules.isPointOutOfBounds(outOfBoundsPoint3));
    assertTrue(rules.isPointOutOfBounds(outOfBoundsPoint4));
  }

}
