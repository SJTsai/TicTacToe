package tests.domain.movegenerator;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.movegenerator.BestMoveGenerator;
import main.domain.movegenerator.BestMoveRatingGenerator;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.movegenerator.interfaces.MoveRatingGenerator;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.DefaultWinnerVerifier;
import main.domain.verification.interfaces.CheckRowColumnVerifier;
import main.domain.verification.interfaces.WinnerVerifier;

import org.junit.Before;
import org.junit.Test;

public class BestMoveGeneratorTest {
  
  private TicTacToeBoardEntity board;
  private MoveGenerator bestMoveGenerator;
  
  @Before
  public void setUp() {
    board = new TicTacToeBoardEntity();
    
    CheckRowColumnVerifier defaultCheckRowColumnVerifier = new DefaultCheckRowColumnVerifier();
    WinnerVerifier defaultWinnerVerifier = new DefaultWinnerVerifier(defaultCheckRowColumnVerifier);
    MoveRatingGenerator bestMoveRatingGenerator = new BestMoveRatingGenerator(defaultWinnerVerifier);
    
    bestMoveGenerator = new BestMoveGenerator(bestMoveRatingGenerator);
  }
  
  @Test
  public void testBestMoveForLostGameIsPointZeroTwo() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(2, 2)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 0)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(2, 1)));
    assertEquals(new Point(0, 2), bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePieceEntity.O).getPoint());
  }
  
  @Test
  public void testBestMoveAfterIncorrectSecondMove() {
    board.addMove(new MoveEntity(TicTacToePieceEntity.X, new Point(1, 1)));
    board.addMove(new MoveEntity(TicTacToePieceEntity.O, new Point(1, 0)));
    List<Point> goodMoves = new ArrayList<Point>();
    goodMoves.add(new Point(0, 0));
    goodMoves.add(new Point(0, 2));
    goodMoves.add(new Point(2, 0));
    goodMoves.add(new Point(2, 2));
    MoveEntity bestMove = bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, TicTacToePieceEntity.X);
    assertTrue(goodMoves.contains(bestMove.getPoint()));
  }
}
