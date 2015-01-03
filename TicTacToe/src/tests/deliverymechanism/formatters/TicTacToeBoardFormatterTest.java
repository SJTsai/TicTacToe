package tests.deliverymechanism.formatters;

import static org.junit.Assert.*;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.models.TicTacToeBoard;
import main.domain.models.mappers.TicTacToeBoardMapper;

import org.junit.Before;
import org.junit.Test;

import deliverymechanism.formatters.TicTacToeBoardFormatter;
import deliverymechanism.formatters.interfaces.BoardFormatter;

public class TicTacToeBoardFormatterTest {
  
  private TicTacToeBoardEntity boardEntity;
  private BoardFormatter ticTacToeBoardFormatter;

  @Before
  public void setUp() throws Exception {
    boardEntity = new TicTacToeBoardEntity();
    ticTacToeBoardFormatter = new TicTacToeBoardFormatter();
  }

  @Test
  public void testBoardStringRepresentation1() {
    boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(0, 2)));
    boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 0)));
    boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 2)));
    boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    boardEntity.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 0)));
    
    TicTacToeBoard board = new TicTacToeBoardMapper().mapTicTacToeBoardEntity(boardEntity);
    
    String boardStringRepresentation = ticTacToeBoardFormatter.format(board);
    assertEquals("[ ][ ][o]\n[o][x][x]\n[x][ ][o]\n", boardStringRepresentation);
  }

}
