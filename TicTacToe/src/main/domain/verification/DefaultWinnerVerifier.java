package main.domain.verification;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.verification.interfaces.WinnerVerifier;

public class DefaultWinnerVerifier implements WinnerVerifier {

  @Override
  public boolean verifyWinForBoardAndLastMoveMade(TicTacToeBoardEntity board, MoveEntity lastMoveMade) {
    
    return false;
  }

}
