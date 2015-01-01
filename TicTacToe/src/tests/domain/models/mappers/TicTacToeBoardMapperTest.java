package tests.domain.models.mappers;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.models.TicTacToeBoard;
import main.domain.models.mappers.TicTacToeBoardMapper;

import org.junit.Test;

public class TicTacToeBoardMapperTest {

  @Test
  public void testBoardEntityToBoardMapperIsConsistent() {
    List<Point> xPointsToTake = new ArrayList<Point>();
    xPointsToTake.add(new Point(0, 0));
    xPointsToTake.add(new Point(0, 1));
    xPointsToTake.add(new Point(0, 2));
    xPointsToTake.add(new Point(1, 0));
    
    List<Point> oPointsToTake = new ArrayList<Point>();
    oPointsToTake.add(new Point(1, 1));
    oPointsToTake.add(new Point(1, 2));
    oPointsToTake.add(new Point(2, 2));
    
    TicTacToeBoardEntity boardEntity = new TicTacToeBoardEntity();
    
    for (Point point : xPointsToTake)
      boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.X, point));
    
    for (Point point : oPointsToTake)
      boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.O, point));
    
    TicTacToeBoardMapper boardMapper = new TicTacToeBoardMapper();
    TicTacToeBoard board = boardMapper.mapTicTacToeBoardEntity(boardEntity);
    
    assertEquals(3, board.getNumberOfRows());
    assertEquals(3, board.getNumberOfColumns());
    assertTrue(xPointsToTake.equals(board.getXPoints()));
    assertTrue(oPointsToTake.equals(board.getOPoints()));
  }

}
