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
  private TicTacToeBoardEntity board;
  
  public BestMoveGenerator(MoveRatingGenerator moveRatingGenerator) {
    this.moveRatingGenerator = moveRatingGenerator;
  }

  @Override
  public MoveEntity getBestMoveForBoardAndCurrentPieceToPlay(TicTacToeBoardEntity board, TicTacToePieceEntity pieceToPlay) {
    this.board = board;
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
    
    if (moveRatingIsNeitherWinOrLoss(bestMoveRating)) {
      List<MoveRating> moveRatingsWithRating0 = getMoveRatingsWithRatingFromListOfMoveRatings(0, moveRatings);
      
      if (doAllMoveRatingsHaveSameDepth(moveRatingsWithRating0)) {
        MoveRating bestMoveRatingForAllRating0 = getMoveRatingWithPoint(new Point(1, 1), moveRatingsWithRating0, moveRatingToPointMapping);
        if (bestMoveRatingForAllRating0 != null)
          bestMoveRating = bestMoveRatingForAllRating0;
        else {
          List<Point> cornerPoints = new ArrayList<Point>();
          cornerPoints.add(new Point(0, 0));
          cornerPoints.add(new Point(0, 2));
          cornerPoints.add(new Point(2, 0));
          cornerPoints.add(new Point(2, 2));
          
          HashMap<Point, Point> cornerToCornerMapping = new HashMap<Point, Point>();
          cornerToCornerMapping.put(new Point(0, 0), new Point(2, 2));
          cornerToCornerMapping.put(new Point(0, 2), new Point(2, 0));
          cornerToCornerMapping.put(new Point(2, 0), new Point(0, 2));
          cornerToCornerMapping.put(new Point(2, 2), new Point(0, 0));
          
          for (Point cornerPoint : cornerPoints) {
            if (board.isPointTaken(cornerPoint)) {
              Point associatedCornerPoint = cornerToCornerMapping.get(cornerPoint);
              bestMoveRatingForAllRating0 = getMoveRatingWithPoint(associatedCornerPoint, moveRatingsWithRating0, moveRatingToPointMapping);
              if (bestMoveRatingForAllRating0 != null) {
                bestMoveRating = bestMoveRatingForAllRating0;
                break;
              }
            }
          }
        }
      }
    }
        
    Point pointForBestMoveRating = moveRatingToPointMapping.get(bestMoveRating);
    return new MoveEntity(pieceToPlay, pointForBestMoveRating);
  }
  
  private MoveRating getMoveRatingWithPoint(Point point, List<MoveRating> moveRatings,
      Map<MoveRating, Point> moveRatingToPointMapping) {
    for (MoveRating moveRating : moveRatings)
      if (moveRatingToPointMapping.get(moveRating).equals(point))
        return moveRating;
    return null;
  }
  
  private boolean moveRatingIsNeitherWinOrLoss(MoveRating moveRating) {
    return moveRating.getRating() == 0;
  }
  
  private List<MoveRating> getMoveRatingsWithRatingFromListOfMoveRatings(int rating, 
      List<MoveRating> moveRatings) {
    List<MoveRating> filteredMoveRatings = new ArrayList<MoveRating>();
    for (MoveRating moveRating : moveRatings)
      if (moveRating.getRating() == rating)
        filteredMoveRatings.add(moveRating);
    return filteredMoveRatings;
  }
  
  private boolean doAllMoveRatingsHaveSameDepth(List<MoveRating> moveRatings) {
    if (moveRatings.size() == 0)
      return false;
    
    int ratingToCompareTo = moveRatings.get(0).getRating();
    
    for (MoveRating moveRating : moveRatings)
      if (moveRating.getRating() != ratingToCompareTo)
        return false;
    
    return true;
  }
  
  private List<Point> getPointsForMoveRatings(List<MoveRating> moveRatings,
      Map<MoveRating, Point> moveRatingToPointMapping) {
    List<Point> points = new ArrayList<Point>();
    for (MoveRating moveRating : moveRatings)
      points.add(moveRatingToPointMapping.get(moveRating));
    return points;
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
