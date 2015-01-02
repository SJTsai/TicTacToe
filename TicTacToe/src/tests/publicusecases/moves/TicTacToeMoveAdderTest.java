package tests.publicusecases.moves;

import static org.junit.Assert.fail;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.entities.TicTacToePlayerEntity;
import main.domain.keepers.AlternatingTurnKeeper;
import main.domain.keepers.interfaces.TurnKeeper;
import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;
import main.domain.movegenerator.BestMoveGenerator;
import main.domain.movegenerator.BestMoveRatingGenerator;
import main.domain.movegenerator.interfaces.MoveGenerator;
import main.domain.verification.DefaultCheckRowColumnVerifier;
import main.domain.verification.DefaultWinnerVerifier;
import main.domain.verification.interfaces.WinnerVerifier;
import main.publicusecases.moves.TicTacToeMoveAdder;
import main.publicusecases.moves.interfaces.MoveAdder;
import main.publicusecases.moves.interfaces.TicTacToeMoveAdderCallBack;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeMoveAdderTest implements TicTacToeMoveAdderCallBack {
  
  private MoveAdder ticTacToeMoveAdder;
  private TicTacToeBoardEntity board;
  private boolean isPlayerTurn;
  private boolean didPlayerWin;
  private boolean didGameTie;

  @Before
  public void setUp() throws Exception {
    board = new TicTacToeBoardEntity();
    
    TicTacToePlayerEntity humanPlayer = new TicTacToePlayerEntity(TicTacToePieceEntity.X, false);
    TicTacToePlayerEntity computerPlayer = new TicTacToePlayerEntity(TicTacToePieceEntity.O, true);
    TurnKeeper alternatingTurnKeeper = new AlternatingTurnKeeper(humanPlayer, computerPlayer);
    
    WinnerVerifier defaultWinnerVerifier = new DefaultWinnerVerifier(new DefaultCheckRowColumnVerifier());
    
    MoveGenerator bestMoveGenerator = new BestMoveGenerator(new BestMoveRatingGenerator(defaultWinnerVerifier));
    
    ticTacToeMoveAdder = new TicTacToeMoveAdder(board, alternatingTurnKeeper, defaultWinnerVerifier, bestMoveGenerator, this);
  }

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  @Override
  public void onMoveAdded(TicTacToeBoard board) {
    
  }

  @Override
  public void onPlayerWon() {
    didPlayerWin = true;
  }

  @Override
  public void onComputerWon() {
    didPlayerWin = false;
  }

  @Override
  public void onTieGame() {
    didGameTie = true;
  }

  @Override
  public void onPlayerTurn(TicTacToePiece piece) {
    isPlayerTurn = true;
  }

  @Override
  public void onComputerTurn(TicTacToePiece piece) {
    isPlayerTurn = false;
  }

}
