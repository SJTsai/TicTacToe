package deliverymechanisms.displayers;

import deliverymechanism.viewmodels.TicTacToeBoardViewModel;
import deliverymechanisms.displayers.interfaces.BoardDisplayer;

public class TicTacToeBoardDisplayer implements BoardDisplayer {

  @Override
  public void display(TicTacToeBoardViewModel boardViewModel) {
    System.out.println(boardViewModel.getBoardStringRepresentation());
  }

}
