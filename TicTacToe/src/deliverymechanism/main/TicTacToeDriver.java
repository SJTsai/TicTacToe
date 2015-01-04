package deliverymechanism.main;

import deliverymechanism.displayers.TicTacToeBoardDisplayer;
import deliverymechanism.formatters.TicTacToeBoardFormatter;
import deliverymechanism.sessions.TicTacToeGameSession;

public class TicTacToeDriver {

  public static void main(String[] args) {
    TicTacToeGameSession gameSession = new TicTacToeGameSession(new TicTacToeBoardFormatter(), new TicTacToeBoardDisplayer());
    gameSession.run();
  }

}
