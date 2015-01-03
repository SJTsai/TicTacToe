package tests.deliverymechanism.viewmodels;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import deliverymechanism.viewmodels.TicTacToeBoardViewModel;

public class TicTacToeBoardViewModelTest {

  private TicTacToeBoardViewModel boardViewModel;
  
  @Before
  public void setUp() throws Exception {
    boardViewModel = new TicTacToeBoardViewModel();
  }

  @Test
  public void testBoardEqual() {
    String boardStringRepresentation = "[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n";
    boardViewModel.setBoardStringRepresentation(boardStringRepresentation);
    assertEquals(boardStringRepresentation, boardViewModel.getBoardStringRepresentation());
  }

}
