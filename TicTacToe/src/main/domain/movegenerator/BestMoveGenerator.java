package main.domain.movegenerator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.movegenerator.interfaces.MoveRatingGenerator;

public class BestMoveGenerator implements MoveGenerator {
  
  private TicTacToeBoardEntity board;
  private TicTacToePieceEntity pieceToPlay;
  private MoveRatingGenerator moveRatingGenerator;
  private List<MoveRating> moveRatingsForEmptyPoints;
  private HashMap<MoveRating, Point> moveRatingToPointMapping;
  
  public BestMoveGenerator(MoveRatingGenerator moveRatingGenerator) {
    this.moveRatingGenerator = moveRatingGenerator;
  }

  @Override
  public MoveEntity getBestMoveForBoardAndCurrentPieceToPlay(TicTacToeBoardEntity board, TicTacToePieceEntity pieceToPlay) {
    this.board = board;
    this.pieceToPlay = pieceToPlay;
    
    List<Point> emptyPoints = board.getEmptyPointsClone();
    moveRatingsForEmptyPoints = new ArrayList<MoveRating>();
    moveRatingToPointMapping = new HashMap<MoveRating, Point>();
    
    updateMoveRatingsAndAssociatedMappedPointsForEmptyPoints(emptyPoints);
        
    MoveRating bestMoveRating = getBestMoveRating(moveRatingsForEmptyPoints);
    
    if (moveRatingIsNeitherWinOrLoss(bestMoveRating))
      bestMoveRating = getBestMoveRatingWhenBestMoveRatingIsZero(bestMoveRating);
        
    Point pointForBestMoveRating = moveRatingToPointMapping.get(bestMoveRating);
    return new MoveEntity(pieceToPlay, pointForBestMoveRating);
  }
  
  private void updateMoveRatingsAndAssociatedMappedPointsForEmptyPoints(List<Point> emptyPoints) {
    for (Point emptyPoint : emptyPoints) {
      MoveEntity testMove = new MoveEntity(pieceToPlay, emptyPoint);
      MoveRating moveRatingForEmptyPoint = moveRatingGenerator.getMoveRating(board, testMove);
      moveRatingsForEmptyPoints.add(moveRatingForEmptyPoint);
      moveRatingToPointMapping.put(moveRatingForEmptyPoint, emptyPoint);
    }
  }
  
  private MoveRating getBestMoveRating(List<MoveRating> moveRatings) {
    MoveRating bestMoveRating = null;
    for (MoveRating moveRatingUnderTest : moveRatings)
      bestMoveRating = getBetterMoveRatingByComparingOriginalBestAndMoveUnderTest(bestMoveRating, moveRatingUnderTest);
    return bestMoveRating;
  }
  
  private MoveRating getBetterMoveRatingByComparingOriginalBestAndMoveUnderTest(MoveRating originalBestMoveRating, MoveRating moveRatingUnderTest) {
    if (originalBestMoveRating == null)
      return moveRatingUnderTest;
    
    int ratingUnderTest = moveRatingUnderTest.getRating();
    int originalBestRating = originalBestMoveRating.getRating();
    
    if (ratingUnderTest > originalBestRating)
      return moveRatingUnderTest;
    
    if (ratingUnderTest == originalBestRating)
      return getBestMoveRatingWithRespectToDepthByComparingOriginalBestAndMoveUnderTest(originalBestMoveRating, moveRatingUnderTest);
    
    return originalBestMoveRating;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthByComparingOriginalBestAndMoveUnderTest(MoveRating originalBestMoveRating, MoveRating moveRatingUnderTest) {
    int ratingUnderTest = moveRatingUnderTest.getRating();
    MoveRating bestMoveRatingWithRespectToDepth = originalBestMoveRating;
    if (ratingUnderTest == 1)
      bestMoveRatingWithRespectToDepth = getBestMoveRatingWithRespectToDepthByComparingOriginalBestAndMoveUnderTestWithRatingOfOne(originalBestMoveRating, moveRatingUnderTest);
    else if (ratingUnderTest == -1)
      bestMoveRatingWithRespectToDepth = getBestMoveRatingWithRespectToDepthByComparingOriginalBestAndMoveUnderTestWithRatingOfNegativeOne(originalBestMoveRating, moveRatingUnderTest);
    return bestMoveRatingWithRespectToDepth;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthByComparingOriginalBestAndMoveUnderTestWithRatingOfOne(MoveRating originalBestMoveRating, MoveRating moveRatingUnderTest) {
    if (moveRatingUnderTest.getDepth() < originalBestMoveRating.getDepth())
      return moveRatingUnderTest;
    return originalBestMoveRating;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthByComparingOriginalBestAndMoveUnderTestWithRatingOfNegativeOne(MoveRating originalBestMoveRating, MoveRating moveRatingUnderTest) {
    if (moveRatingUnderTest.getDepth() > originalBestMoveRating.getDepth())
      return moveRatingUnderTest;
    return originalBestMoveRating;
  }
  
  private boolean moveRatingIsNeitherWinOrLoss(MoveRating moveRating) {
    return moveRating.getRating() == 0;
  }
  
  private MoveRating getBestMoveRatingWhenBestMoveRatingIsZero(MoveRating originalBestMoveRating) {
    List<MoveRating> moveRatingsWithRating0 = getMoveRatingsWithRatingFromListOfMoveRatings(0, moveRatingsForEmptyPoints);
    MoveRating bestMoveRatingWhenBestRatingIs0 = originalBestMoveRating;
    
    if (doAllMoveRatingsHaveSameDepth(moveRatingsWithRating0)) {
      MoveRating bestMoveRatingForAllRating0 = getMoveRatingWithPoint(new Point(1, 1), moveRatingsWithRating0);
      if (bestMoveRatingForAllRating0 != null)
        bestMoveRatingWhenBestRatingIs0 = bestMoveRatingForAllRating0;
      else {
        MoveRating bestCornerRating = getBestMoveRatingForCornerPoints(moveRatingsWithRating0);
        if (bestCornerRating != null)
          bestMoveRatingWhenBestRatingIs0 = bestCornerRating;
      }
    }
    
    return bestMoveRatingWhenBestRatingIs0;
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
  
  private MoveRating getBestMoveRatingForCornerPoints(List<MoveRating> moveRatingsWithRating0) {
    List<Point> cornerPoints = getCornerPoints();
    HashMap<Point, Point> cornerToCornerMapping = getCornerToCornerMapping();
    
    MoveRating bestCornerMoveRating = null;
    for (Point cornerPoint : cornerPoints) {
      if (board.isPointTaken(cornerPoint)) {
        Point associatedCornerPoint = cornerToCornerMapping.get(cornerPoint);
        MoveRating bestMoveRatingForAllRating0 = getMoveRatingWithPoint(associatedCornerPoint, moveRatingsWithRating0);
        if (bestMoveRatingForAllRating0 != null) {
          bestCornerMoveRating = bestMoveRatingForAllRating0;
          break;
        }
      }
    }
    
    return bestCornerMoveRating;
  }
  
  private List<Point> getCornerPoints() {
    List<Point> cornerPoints = new ArrayList<Point>();
    cornerPoints.add(new Point(0, 0));
    cornerPoints.add(new Point(0, 2));
    cornerPoints.add(new Point(2, 0));
    cornerPoints.add(new Point(2, 2));
    return cornerPoints;
  }
  
  private HashMap<Point, Point> getCornerToCornerMapping() {
    HashMap<Point, Point> cornerToCornerMapping = new HashMap<Point, Point>();
    cornerToCornerMapping.put(new Point(0, 0), new Point(2, 2));
    cornerToCornerMapping.put(new Point(0, 2), new Point(2, 0));
    cornerToCornerMapping.put(new Point(2, 0), new Point(0, 2));
    cornerToCornerMapping.put(new Point(2, 2), new Point(0, 0));
    return cornerToCornerMapping;
  }
  
  private MoveRating getMoveRatingWithPoint(Point point, List<MoveRating> moveRatings) {
    for (MoveRating moveRating : moveRatings)
      if (moveRatingToPointMapping.get(moveRating).equals(point))
        return moveRating;
    return null;
  }

}
