package main.domain.movegenerator;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.movegenerator.interfaces.MoveRatingGenerator;
import main.domain.verification.interfaces.WinnerVerifier;

public class BestMoveRatingGenerator implements MoveRatingGenerator {
  
  private WinnerVerifier winnerVerifier;
  
  public BestMoveRatingGenerator(WinnerVerifier winnerVerifier) {
    this.winnerVerifier = winnerVerifier;
  }

  @Override
  public MoveRating getMoveRating(TicTacToeBoardEntity board, MoveEntity testMove) {
    return getBestMoveRating(board, testMove, 0);
  }
  
  private MoveRating getBestMoveRating(TicTacToeBoardEntity board, MoveEntity testMove, int depth) {
    TicTacToeBoardEntity boardClone = new TicTacToeBoardEntity(board);
    boardClone.addMove(testMove);
    
    if (winnerVerifier.verifyWinForBoardAndLastMoveMade(boardClone, testMove))
      return new MoveRating(getRatingForWinningMoveWithDepth(depth), depth);
    
    if (boardClone.isFull())
      return new MoveRating(getRatingForTie(), depth);
    
    List<MoveRating> moveRatings = new ArrayList<MoveRating>();
    TicTacToePieceEntity nextPieceToMove = getOpposingPieceWithRespectToPiece(testMove.getPiece());
    for (Point emptyPoint : boardClone.getEmptyPointsClone())
      moveRatings.add(getBestMoveRating(boardClone, new MoveEntity(nextPieceToMove, emptyPoint), depth + 1));
    
    return getBestMoveRatingFromListOfMoveRatingsForAssociatedDepth(moveRatings, depth);
  }
  
  private int getRatingForWinningMoveWithDepth(int depth) {
    return depth % 2 == 0 ? 1 : -1;
  }
  
  private int getRatingForTie() {
    return 0;
  }
  
  private TicTacToePieceEntity getOpposingPieceWithRespectToPiece(TicTacToePieceEntity piece) {
    if (piece == TicTacToePieceEntity.X)
      return TicTacToePieceEntity.O;
    return TicTacToePieceEntity.X;
  }
  
  private MoveRating getBestMoveRatingFromListOfMoveRatingsForAssociatedDepth(List<MoveRating> moveRatings, int depth) {
    MoveRating bestMoveRating = null;
    for (MoveRating moveRatingUnderTest : moveRatings) {
      if (bestMoveRating == null)
        bestMoveRating = moveRatingUnderTest;
      else
        bestMoveRating = getBestMoveRatingWithRespectToDepth(moveRatingUnderTest, bestMoveRating, depth);
    }
    return bestMoveRating;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepth(MoveRating moveRating1, MoveRating moveRating2, int depth) {
    if (wereMoveRatingsGeneratedForOpposingPlayersTurnBasedOnDepth(depth))
      return getBestMoveRatingWithRespectToOpposingPlayersTurn(moveRating1, moveRating2);
    return getBestMoveRatingWithRespectToOriginalPlayersTurn(moveRating1, moveRating2);
  }
  
  private boolean wereMoveRatingsGeneratedForOpposingPlayersTurnBasedOnDepth(int depth) {
    return depth % 2 == 0;
  }
  
  private MoveRating getBestMoveRatingWithRespectToOpposingPlayersTurn(MoveRating moveRating1, MoveRating moveRating2) {
    if (!doMoveRatingsHaveTheSameRating(moveRating1, moveRating2))
      return getBestMoveRatingWithRespectToRatingForOpposingWin(moveRating1, moveRating2);
    return getBestMoveRatingWithRespectToDepthForOpposingWin(moveRating1, moveRating2);
  }
  
  private MoveRating getBestMoveRatingWithRespectToRatingForOpposingWin(MoveRating moveRating1, MoveRating moveRating2) {
    if (moveRating1.getRating() < moveRating2.getRating())
      return moveRating1;
    return moveRating2;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthForOpposingWin(MoveRating moveRating1, MoveRating moveRating2) {
    if (wasLossForOpponentMoveRating(moveRating1))
      return getBestMoveRatingWithRespectToDepthForOpponentLoss(moveRating1, moveRating2);
    return getBestMoveRatingWithRespectToDepthForOpponentWin(moveRating1, moveRating2);
  }
  
  private boolean wasLossForOpponentMoveRating(MoveRating opponentMoveRating) {
    return opponentMoveRating.getRating() == 1;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthForOpponentLoss(MoveRating moveRating1, MoveRating moveRating2) {
    if (moveRating1.getDepth() < moveRating2.getDepth())
      return moveRating1;
    return moveRating2;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthForOpponentWin(MoveRating moveRating1, MoveRating moveRating2) {
    if (moveRating1.getDepth() > moveRating2.getDepth())
      return moveRating1;
    return moveRating2;
  }
  
  private MoveRating getBestMoveRatingWithRespectToOriginalPlayersTurn(MoveRating moveRating1, MoveRating moveRating2) {
    if (!doMoveRatingsHaveTheSameRating(moveRating1, moveRating2))
      return getBestMoveRatingWithRespectToRatingForOriginalPlayersWin(moveRating1, moveRating2);
    return getBestMoveRatingWithRespectToDepthForOriginalPlayersWin(moveRating1, moveRating2);
  }
  
  private boolean doMoveRatingsHaveTheSameRating(MoveRating moveRating1, MoveRating moveRating2) {
    return moveRating1.getRating() == moveRating2.getRating();
  }
  
  private MoveRating getBestMoveRatingWithRespectToRatingForOriginalPlayersWin(MoveRating moveRating1, MoveRating moveRating2) {
    if (moveRating1.getRating() > moveRating2.getRating())
      return moveRating1;
    return moveRating2;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthForOriginalPlayersWin(MoveRating moveRating1, MoveRating moveRating2) {
    if (wasLossForOriginalPlayerMoveRating(moveRating1))
      return getBestMoveRatingWithRespectToDepthForOriginalPlayerLoss(moveRating1, moveRating2);
    return getBestMoveRatingWithRespectToDepthForOriginalPlayerWin(moveRating1, moveRating2);
  }
  
  private boolean wasLossForOriginalPlayerMoveRating(MoveRating originalPlayerMoveRating) {
    return originalPlayerMoveRating.getRating() == -1;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthForOriginalPlayerLoss(MoveRating moveRating1, MoveRating moveRating2) {
    if (moveRating1.getDepth() > moveRating2.getDepth())
      return moveRating1;
    return moveRating2;
  }
  
  private MoveRating getBestMoveRatingWithRespectToDepthForOriginalPlayerWin(MoveRating moveRating1, MoveRating moveRating2) {
    if (moveRating1.getDepth() < moveRating2.getDepth())
      return moveRating1;
    return moveRating2;
  }

}
