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
import deliverymechanism.displayers.interfaces.BoardDisplayer;
import deliverymechanism.formatters.interfaces.BoardFormatter;
import deliverymechanism.viewmodels.TicTacToeBoardViewModel;

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
    while (continuePlaying)
      ticTacToeGameInitializer.initializeGame();
  }
  
  @Override
  public void onGameCreated(TicTacToeBoard board, MoveAdder moveAdder) {
    this.moveAdder = moveAdder;
    
    System.out.println("Board created.");
    displayBoard(board);
  }
  
  @Override
  public void onPlayerToStart(TicTacToePiece piece) {
    System.out.println("\nYou are playing as: " + getPieceStringRepresentation(piece) + "\n");
    Point userChosenPoint = inquireUserForPoint();
    moveAdder.addMove(userChosenPoint);
  }
  
  @Override
  public void onComputerToStart(TicTacToePiece piece) {
    System.out.println("\nComputer (" + getPieceStringRepresentation(piece) + ") is starting...");
  };
  
  private String getPieceStringRepresentation(TicTacToePiece piece) {
    return piece == TicTacToePiece.X ? "x" : "o";
  }
  
  @Override
  public void onMoveAdded(TicTacToeBoard board, Point pointWhereAdded) {
    displayBoard(board);
    System.out.println("Point added at " + getStringRepresentationOfPoint(pointWhereAdded) + "\n");
  }
  
  private void displayBoard(TicTacToeBoard board) {
    String boardStringRepresentation = boardFormatter.format(board);
    TicTacToeBoardViewModel boardViewModel = new TicTacToeBoardViewModel();
    boardViewModel.setBoardStringRepresentation(boardStringRepresentation);
    boardDisplayer.display(boardViewModel);
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
    String continueResponse = "";
    while (didNotInputCorrectResponse) {
      System.out.print("Would you like to continue playing? (Y/N): ");
      continueResponse = inputScanner.nextLine();
      didNotInputCorrectResponse = !isValidResponseToGameContinuationInquiry(continueResponse);
    }
    handleResponseToGameContinueationInquiry(continueResponse);
  }
  
  private boolean isValidResponseToGameContinuationInquiry(String response) {
    return response.equalsIgnoreCase("y") ||
        response.equalsIgnoreCase("n") || 
        response.equalsIgnoreCase("yes") ||
        response.equalsIgnoreCase("no");
  }
  
  private void handleResponseToGameContinueationInquiry(String response) {
    if (doesUserWishesToContinuePlaying(response))
      handleUserWishesToContinuePlaying();
    else if (doesUserWishesToStopPlaying(response))
      handleUserWishesToStopPlaying();
  }
  
  private boolean doesUserWishesToContinuePlaying(String response) {
    return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");
  }
  
  private void handleUserWishesToContinuePlaying() {
    continuePlaying = true;
    System.out.println();
  }
  
  private boolean doesUserWishesToStopPlaying(String response) {
    return response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no");
  }
  
  private void handleUserWishesToStopPlaying() {
    continuePlaying = false;
    System.out.println("\nThanks for playing.");
    inputScanner.close();
  }

  @Override
  public void onPlayerTurn(TicTacToePiece piece) {
    Point userChosenPoint = inquireUserForPoint();
    moveAdder.addMove(userChosenPoint);
  }

  @Override
  public void onComputerTurn(TicTacToePiece piece) {
    System.out.println("The computer is thinking...");
  }
  
  @Override
  public void onPlayerMoveOutOfBounds(Point point) {
    System.out.println("\n" + getStringRepresentationOfPoint(point) + " is out of bounds.  Please choose again.\n");
    Point userChosenPoint = inquireUserForPoint();
    moveAdder.addMove(userChosenPoint);
  }
  
  @Override
  public void onPointTaken(Point point) {
    System.out.println("\n" + getStringRepresentationOfPoint(point) + " is already taken.  Please choose again.\n");
    Point userChosenPoint = inquireUserForPoint();
    moveAdder.addMove(userChosenPoint);
  }
  
  private String getStringRepresentationOfPoint(Point point) {
    return "(" + point.x + ", " + point.y + ")";
  }
  
  private Point inquireUserForPoint() {
    Point userChosenPoint = null;
    boolean inputObtained = false;
    while (!inputObtained) {
      try {
        userChosenPoint = inquireUserForCoordinates();
        inputObtained = true;
      } catch (InputMismatchException inputMismatchException) {
        handleUserPointInquiryInputMismatchException();
      }
    }
    return userChosenPoint;
  }
  
  private Point inquireUserForCoordinates() {
    int xCoordinate;
    int yCoordinate;
    
    System.out.print("It is your turn to play.\nPlease enter x-coordinate: ");
    xCoordinate = inputScanner.nextInt();
    inputScanner.nextLine();
    System.out.print("Please enter y-coordinate: ");
    yCoordinate = inputScanner.nextInt();
    inputScanner.nextLine();
    return new Point(xCoordinate, yCoordinate);
  }
  
  private void handleUserPointInquiryInputMismatchException() {
    inputScanner.nextLine();
    System.out.println("\nYou must enter an integer.  Please choose a point again.\n");
  }
  
}
