package deliverymechanism.sessions;

import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.domain.models.TicTacToeBoard;
import main.domain.models.TicTacToePiece;
import main.publicusecases.initializers.TicTacToeGameInitializer;
import main.publicusecases.initializers.interfaces.GameInitializer;
import main.publicusecases.initializers.interfaces.TicTacToeGameInitializerCallBack;
import main.publicusecases.moves.interfaces.MoveAdder;
import main.publicusecases.moves.interfaces.TicTacToeMoveAdderCallBack;
import deliverymechanism.formatters.interfaces.BoardFormatter;
import deliverymechanism.viewmodels.TicTacToeBoardViewModel;
import deliverymechanisms.displayers.interfaces.BoardDisplayer;

public class TicTacToeGameSession implements TicTacToeGameInitializerCallBack, TicTacToeMoveAdderCallBack {

  private MoveAdder moveAdder;
  private BoardFormatter boardFormatter;
  private BoardDisplayer boardDisplayer;
  private GameInitializer ticTacToeGameInitializer;
  private boolean continuePlaying;
  private Scanner inputScanner;
  
  public TicTacToeGameSession(BoardFormatter boardFormatter, BoardDisplayer boardDisplayer) {
    this.boardFormatter = boardFormatter;
    this.boardDisplayer = boardDisplayer;
    ticTacToeGameInitializer = new TicTacToeGameInitializer(this, this);
    continuePlaying = true;
    inputScanner = new Scanner(System.in);
  }
  
  public void run() {
    while (continuePlaying) {
      ticTacToeGameInitializer.initializeGame();
    }
  }
  
  @Override
  public void onMoveAdded(TicTacToeBoard board, Point pointWhereAdded) {
    displayBoard(board);
    System.out.println("Point added at " + getStringRepresentationOfPoint(pointWhereAdded) + "\n");
  }

  @Override
  public void onPlayerWon() {
    System.out.println("You have won!");
    promptUserToContinueGameOrNot();
  }

  @Override
  public void onComputerWon() {
    System.out.println("The computer has won.");
    promptUserToContinueGameOrNot();
  }

  @Override
  public void onTieGame() {
    System.out.println("The game has tied.");
    promptUserToContinueGameOrNot();
  }
  
  private void promptUserToContinueGameOrNot() {    
    boolean didNotInputCorrectResponse = true;
    while (didNotInputCorrectResponse) {
      System.out.print("Would you like to continue playing? (Y/N): ");
      String continueResponse = inputScanner.nextLine();
      if (continueResponse.equalsIgnoreCase("y") || continueResponse.equalsIgnoreCase("yes")) {
        continuePlaying = true;
        didNotInputCorrectResponse = false;
      }
      else if (continueResponse.equalsIgnoreCase("n") || continueResponse.equalsIgnoreCase("no")) {
        System.out.println("Thanks for playing.");
        continuePlaying = false;
        didNotInputCorrectResponse = false;
        inputScanner.close();
      }
    }
  }

  @Override
  public void onPlayerTurn(TicTacToePiece piece) {
    Point pointInput = getPointInput();
    moveAdder.addMove(pointInput);
  }

  @Override
  public void onComputerTurn(TicTacToePiece piece) {
    System.out.println("The computer is thinking...");
  }

  @Override
  public void onGameCreated(TicTacToeBoard board, MoveAdder moveAdder) {
    displayBoard(board);
    this.moveAdder = moveAdder;
  }
  
  private void displayBoard(TicTacToeBoard board) {
    String boardStringRepresentation = boardFormatter.format(board);
    TicTacToeBoardViewModel boardViewModel = new TicTacToeBoardViewModel();
    boardViewModel.setBoardStringRepresentation(boardStringRepresentation);
    boardDisplayer.display(boardViewModel);
  }

  @Override
  public void onPlayerToStart(TicTacToePiece piece) {
    String pieceStringRepresentation = piece == TicTacToePiece.X ? "X" : "O";
    System.out.println("You are playing as: " + pieceStringRepresentation + "\n");
    
    Point pointInput = getPointInput();
    moveAdder.addMove(pointInput);
  }
  
  @Override
  public void onComputerToStart(TicTacToePiece piece) {
    System.out.println("Computer (" + getPieceStringRepresentation(piece) + ") is starting...");
  };
  
  @Override
  public void onPlayerMoveOutOfBounds(Point point) {
    System.out.println("\n" + getStringRepresentationOfPoint(point) + " is out of bounds.  Please choose again.\n");
    moveAdder.addMove(getPointInput());
  }
  
  private String getStringRepresentationOfPoint(Point point) {
    return "(" + point.x + ", " + point.y + ")";
  }
  
  private String getPieceStringRepresentation(TicTacToePiece piece) {
    return piece == TicTacToePiece.X ? "x" : "o";
  }
  
  private Point getPointInput() {
    int xCoordinate = 0;
    int yCoordinate = 0;
    boolean inputObtained = false;
    while (!inputObtained) {
      try {
        System.out.print("It is your turn to play.\nPlease enter x-coordinate: ");
        xCoordinate = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.print("Please enter y-coordinate: ");
        yCoordinate = inputScanner.nextInt();
        inputScanner.nextLine();
        inputObtained = true;
      } catch (InputMismatchException inputMismatchException) {
        inputScanner.nextLine();
        System.out.println("\nYou must enter an integer.  Please choose a point again.\n");
      }
    }
    return new Point(xCoordinate, yCoordinate);
  }
  
}
