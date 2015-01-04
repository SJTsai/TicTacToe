package tests.deliverymechanism.displayers;

import org.junit.Before;
import org.junit.Test;

import deliverymechanism.viewmodels.TicTacToeBoardViewModel;
import deliverymechanisms.displayers.TicTacToeBoardDisplayer;
import deliverymechanisms.displayers.interfaces.BoardDisplayer;

public class TicTacToeBoardDisplayerTest {

  private BoardDisplayer ticTacToeBoardDisplayer;
  
  @Before
  public void setUp() throws Exception {
    ticTacToeBoardDisplayer = new TicTacToeBoardDisplayer();
  }

  @Test
  public void testBoardWasPrintedOut() {
    TicTacToeBoardViewModel boardViewModel = new TicTacToeBoardViewModel();
    boardViewModel.setBoardStringRepresentation("[ ][ ][x]\n[ ][ ][ ]\n[ ][ ][o]\n");
    ticTacToeBoardDisplayer.display(boardViewModel);
  }

}
