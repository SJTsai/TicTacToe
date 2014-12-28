package main.domain.verification.interfaces;

import main.domain.entities.MoveEntity;

public interface WinnerVerifier {

  public boolean verifyWinForBoardAndLastMoveMade(MoveEntity lastMoveMade);
}
