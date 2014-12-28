package main.domain.movegenerator.interfaces;

import main.domain.entities.MoveEntity;
import main.domain.entities.TicTacToeBoardEntity;
import main.domain.movegenerator.MoveRating;

public interface MoveRatingGenerator {

  public MoveRating getMoveRating(TicTacToeBoardEntity board, MoveEntity testMove);
}
