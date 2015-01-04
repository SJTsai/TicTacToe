package tests.deliverymechanism.displayers;

import org.junit.Before;
import org.junit.Test;

import deliverymechanism.displayers.TicTacToeBoardDisplayer;
import deliverymechanism.displayers.interfaces.BoardDisplayer;
import deliverymechanism.viewmodels.TicTacToeBoardViewModel;

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
