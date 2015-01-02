package main.publicusecases.moves;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.keepers.interfaces.TurnKeeper;
import main.domain.models.mappers.TicTacToeBoardMapper;
import main.domain.models.mappers.TicTacToePieceMapper;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.verification.interfaces.WinnerVerifier;
import main.publicusecases.moves.interfaces.MoveAdder;
import main.publicusecases.moves.interfaces.TicTacToeMoveAdderCallBack;

public class TicTacToeMoveAdder implements MoveAdder {
  
  private TicTacToeBoardEntity board;
  private TurnKeeper turnKeeper;
  private WinnerVerifier winnerVerifier;
  private MoveGenerator moveGenerator;
  private TicTacToeMoveAdderCallBack callBack;
  private TicTacToeBoardMapper boardMapper;
  private TicTacToePieceMapper pieceMapper;
  private MoveEntity lastMoveMade;
  
  public TicTacToeMoveAdder(TicTacToeBoardEntity board, 
      TurnKeeper turnKeeper, WinnerVerifier winnerVerifier, MoveGenerator moveGenerator,
      TicTacToeMoveAdderCallBack callBack) {
    this.board = board;
    this.turnKeeper = turnKeeper;
    this.winnerVerifier = winnerVerifier;
    this.moveGenerator = moveGenerator;
    this.callBack = callBack;
    boardMapper = new TicTacToeBoardMapper();
  }

  @Override
  public void addMove(Point pointToTake) {
    MoveEntity move = new MoveEntity(turnKeeper.getPieceForCurrentPlayer(), pointToTake);
    board.addMove(move);
    lastMoveMade = move;
    
    callBack.onMoveAdded(boardMapper.mapTicTacToeBoardEntity(board));
    
    if (wasLastMoveAWin())
      handleWin();
    else if (wasLastMoveATie())
      handleTie();
    else
      handleGameMustContinue();
  }
  
  private boolean wasLastMoveAWin() {
    return winnerVerifier.verifyWinForBoardAndLastMoveMade(board, lastMoveMade);
  }
  
  private void handleWin() {
    if (turnKeeper.isCurrentPlayerAComputer())
      callBack.onComputerWon();
    else
      callBack.onPlayerWon();
  }
  
  private boolean wasLastMoveATie() {
    return board.isFull();
  }
  
  private void handleTie() {
    callBack.onTieGame();
  }
  
  private void handleGameMustContinue() {
    turnKeeper.switchToNextPlayer();
    if (turnKeeper.isCurrentPlayerAComputer())
      handleComputersTurnToPlay();
    else
      callBack.onPlayerTurn(pieceMapper.mapTicTacToePieceEntity(turnKeeper.getPieceForCurrentPlayer()));
  }
  
  private void handleComputersTurnToPlay() {
    callBack.onComputerTurn(pieceMapper.mapTicTacToePieceEntity(turnKeeper.getPieceForCurrentPlayer()));
    MoveEntity bestMoveForComputer = moveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, 
        turnKeeper.getPieceForCurrentPlayer());
    addMove(bestMoveForComputer.getPoint());
  }

}
