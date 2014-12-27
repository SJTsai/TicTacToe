package main.domain.verification.interfaces;

import main.domain.entities.MoveEntity;

public interface CheckRowColumnVerifier {

  public boolean shouldCheckWinForFirstRowForMove(MoveEntity move);
  public boolean shouldCheckWinForSecondRowForMove(MoveEntity move);
  public boolean shouldCheckWinForThirdRowForMove(MoveEntity move);
  public boolean shouldCheckWinForFirstColumnForMove(MoveEntity move);
  public boolean shouldCheckWinForSecondColumnForMove(MoveEntity move);
  public boolean shouldCheckWinForThirdColumnForMove(MoveEntity move);
  public boolean shouldCheckWinForBackSlashDiagonalForMove(MoveEntity move);
  public boolean shouldCheckWinForForwardSlashDiagonalForMove(MoveEntity move);
}
