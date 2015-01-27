package main.publicusecases.initializers;

import java.awt.Point;

import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;
import main.domain.keepers.AlternatingTurnKeeper;
import main.domain.keepers.interfaces.TurnKeeper;
import main.domain.models.TicTacToeBoard;
import main.domain.models.mappers.TicTacToeBoardMapper;
import main.domain.models.mappers.TicTacToePieceMapper;
import main.domain.movegenerator.BestMoveGenerator;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.DefaultWinnerVerifier;
import main.domain.verification.interfaces.CheckRowColumnVerifier;
import main.domain.verification.interfaces.WinnerVerifier;
import main.publicusecases.initializers.interfaces.GameInitializer;
import main.publicusecases.initializers.interfaces.TicTacToeGameInitializerCallBack;
import main.publicusecases.moves.TicTacToeMoveAdder;
import main.publicusecases.moves.interfaces.MoveAdder;
import main.publicusecases.moves.interfaces.TicTacToeMoveAdderCallBack;

public class TicTacToeGameInitializer implements GameInitializer {
  
  private TicTacToeGameInitializerCallBack gameInitializerCallBack;
  private TicTacToeMoveAdderCallBack moveAdderCallBack;
  private TicTacToePieceMapper pieceMapper;
  private boolean humanGoesFirst;
  
  public TicTacToeGameInitializer(TicTacToeGameInitializerCallBack gameInitializerCallBack,
      TicTacToeMoveAdderCallBack moveAdderCallBack) {
    this.gameInitializerCallBack = gameInitializerCallBack;
    this.moveAdderCallBack = moveAdderCallBack;
    pieceMapper = new TicTacToePieceMapper();
  }

  @Override
  public void initializeGame() {
    humanGoesFirst = !humanGoesFirst;
    
    TicTacToeBoardEntity board = new TicTacToeBoardEntity();
    TurnKeeper alternatingTurnKeeper = getTurnKeeper();
    MoveAdder moveAdder = new TicTacToeMoveAdder(board, 
        alternatingTurnKeeper, getWinnerVerifier(), getMoveGenerator(), moveAdderCallBack);
    
    TicTacToeBoardMapper boardMapper = new TicTacToeBoardMapper();
    TicTacToeBoard boardToSendToCallBack = boardMapper.mapTicTacToeBoardEntity(board);
    gameInitializerCallBack.onGameCreated(boardToSendToCallBack, moveAdder);
    
    if (humanGoesFirst)
      gameInitializerCallBack.onPlayerToStart(pieceMapper.mapTicTacToePieceEntity(alternatingTurnKeeper.getPieceForCurrentPlayer()));
    else
      handleComputerGoesFirst(alternatingTurnKeeper, moveAdder);
  }
  
  private TurnKeeper getTurnKeeper() {
    TicTacToePlayerEntity humanPlayer = new TicTacToePlayerEntity(TicTacToePieceEntity.X, false);
    TicTacToePlayerEntity computerPlayer = new TicTacToePlayerEntity(TicTacToePieceEntity.O, true);
    TurnKeeper alternatingTurnKeeper = new AlternatingTurnKeeper(humanPlayer, computerPlayer);
    return alternatingTurnKeeper;
  }
  
  private MoveGenerator getMoveGenerator() {
    return new BestMoveGenerator();
  }
  
  private WinnerVerifier getWinnerVerifier() {
    CheckRowColumnVerifier defaultCheckRowColumnVerifier = new DefaultCheckRowColumnVerifier();
    WinnerVerifier defaultWinnerVerifier = new DefaultWinnerVerifier(defaultCheckRowColumnVerifier);
    return defaultWinnerVerifier;
  }
  
  private void handleComputerGoesFirst(TurnKeeper turnKeeper, MoveAdder moveAdder) {
    if (!turnKeeper.isCurrentPlayerAComputer())
      turnKeeper.switchToNextPlayer();
    
    gameInitializerCallBack.onComputerToStart(pieceMapper.mapTicTacToePieceEntity(turnKeeper.getPieceForCurrentPlayer()));
    moveAdder.addMove(new Point(1, 1));
  }

}
