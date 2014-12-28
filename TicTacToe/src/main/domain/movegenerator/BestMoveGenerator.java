package main.domain.movegenerator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.movegenerator.interfaces.MoveRatingGenerator;

public class BestMoveGenerator implements MoveGenerator {
  
  private MoveRatingGenerator moveRatingGenerator;
  
  public BestMoveGenerator(MoveRatingGenerator moveRatingGenerator) {
    this.moveRatingGenerator = moveRatingGenerator;
  }

  @Override
  public MoveEntity getBestMoveForBoardAndCurrentPieceToPlay(TicTacToeBoardEntity board, TicTacToePieceEntity pieceToPlay) {
    List<Point> emptyPoints = board.getEmptyPointsClone();
    List<MoveRating> moveRatings = new ArrayList<MoveRating>();
    Map<MoveRating, Point> moveRatingToPointMapping = new HashMap<MoveRating, Point>();
    for (Point emptyPoint : emptyPoints) {
      MoveEntity testMove = new MoveEntity(pieceToPlay, emptyPoint);
      MoveRating moveRatingForEmptyPoint = moveRatingGenerator.getMoveRating(board, testMove);
      moveRatings.add(moveRatingForEmptyPoint);
      moveRatingToPointMapping.put(moveRatingForEmptyPoint, emptyPoint);
    }
    MoveRating bestMoveRating = getBestMoveRating(moveRatings);
    Point pointForBestMoveRating = moveRatingToPointMapping.get(bestMoveRating);
    return new MoveEntity(pieceToPlay, pointForBestMoveRating);
  }
  
  private MoveRating getBestMoveRating(List<MoveRating> moveRatings) {
    MoveRating bestMoveRating = null;
    for (MoveRating moveRatingUnderTest : moveRatings) {
      if (bestMoveRating == null)
        bestMoveRating = moveRatingUnderTest;
      else {
        int ratingUnderTest = moveRatingUnderTest.getRating();
        int currentBestRating = bestMoveRating.getRating();
        
        if (ratingUnderTest > currentBestRating)
          bestMoveRating = moveRatingUnderTest;
        else if (ratingUnderTest == currentBestRating) {
          if (ratingUnderTest == 1) {
            if (moveRatingUnderTest.getDepth() < bestMoveRating.getDepth())
              bestMoveRating = moveRatingUnderTest;
          } else if (ratingUnderTest == -1) {
            if (moveRatingUnderTest.getDepth() > bestMoveRating.getDepth())
              bestMoveRating = moveRatingUnderTest;
          }
        }
      }
    }
    return bestMoveRating;
  }

}
