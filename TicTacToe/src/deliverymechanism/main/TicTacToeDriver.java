package deliverymechanism.main;

import deliverymechanism.formatters.TicTacToeBoardFormatter;
import deliverymechanism.sessions.TicTacToeGameSession;
import deliverymechanisms.displayers.TicTacToeBoardDisplayer;

public class TicTacToeDriver {

  public static void main(String[] args) {
    TicTacToeGameSession gameSession = new TicTacToeGameSession(new TicTacToeBoardFormatter(), new TicTacToeBoardDisplayer());
    gameSession.run();
  }

}
