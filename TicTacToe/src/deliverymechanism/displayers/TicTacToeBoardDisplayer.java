package deliverymechanism.displayers;

import deliverymechanism.displayers.interfaces.BoardDisplayer;
import deliverymechanism.viewmodels.TicTacToeBoardViewModel;

public class TicTacToeBoardDisplayer implements BoardDisplayer {

  @Override
  public void display(TicTacToeBoardViewModel boardViewModel) {
    System.out.println(boardViewModel.getBoardStringRepresentation());
  }

}
