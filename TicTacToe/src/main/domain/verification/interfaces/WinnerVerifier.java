package main.domain.verification.interfaces;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;

public interface WinnerVerifier {
  
  public boolean verifyWinForBoardAndLastMoveMade(TicTacToeBoardEntity board, MoveEntity lastMoveMade);
}
