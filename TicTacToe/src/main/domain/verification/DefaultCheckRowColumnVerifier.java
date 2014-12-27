package main.domain.verification;

import java.awt.Point;

import main.domain.entities.MoveEntity;
import main.domain.verification.interfaces.CheckRowColumnVerifier;

public class DefaultCheckRowColumnVerifier implements CheckRowColumnVerifier {

  @Override
  public boolean shouldCheckWinForFirstRowForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.x == 0;
  }

  @Override
  public boolean shouldCheckWinForSecondRowForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.x == 1;
  }

  @Override
  public boolean shouldCheckWinForThirdRowForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.x == 2;
  }

  @Override
  public boolean shouldCheckWinForFirstColumnForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.y == 0;
  }

  @Override
  public boolean shouldCheckWinForSecondColumnForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.y == 1;
  }

  @Override
  public boolean shouldCheckWinForThirdColumnForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.y == 2;
  }

  @Override
  public boolean shouldCheckWinForBackSlashDiagonalForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.equals(new Point(0, 0)) ||
        pointForMove.equals(new Point(1, 1)) ||
        pointForMove.equals(new Point(2, 2));
  }

  @Override
  public boolean shouldCheckWinForForwardSlashDiagonalForMove(MoveEntity move) {
    Point pointForMove = move.getPoint();
    return pointForMove.equals(new Point(0, 2)) ||
        pointForMove.equals(new Point(1, 1)) ||
        pointForMove.equals(new Point(2, 0));
  }
}
