package deliverymechanism.game;

import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;

import ttt.checker.TicTacToeWinChecker;
import ttt.formatter.TicTacToeBoardFormatter;
import ttt.model.Move;
import ttt.model.TicTacToeBoard;
import ttt.model.TicTacToePiece;
import ttt.movegenerator.BestMoveGenerator;
import ttt.player.TicTacToePlayer;
import ttt.rules.TicTacToeRules;

public class TicTacToeGame {

  private TicTacToeBoard board;
  
  private TicTacToePlayer player1;
  private TicTacToePlayer player2;
  private TicTacToePlayer currentPlayer;
  private TicTacToePlayer playerToStart;
  
  private boolean isGameFinished;
  private boolean shouldContinuePlaying;
  
  private BestMoveGenerator bestMoveGenerator;
  private TicTacToeWinChecker winChecker;
  private TicTacToeBoardFormatter boardFormatter;
  private TicTacToeRules rules;
  
  private Scanner inputScanner;
  
  public TicTacToeGame() {
    board = new TicTacToeBoard();
    
    player1 = new TicTacToePlayer(TicTacToePiece.X, board, false);
    player2 = new TicTacToePlayer(TicTacToePiece.O, board, true);
    playerToStart = currentPlayer = player1;
    
    bestMoveGenerator = new BestMoveGenerator();
    winChecker = new TicTacToeWinChecker();
    boardFormatter = new TicTacToeBoardFormatter();
    rules = new TicTacToeRules(board);
    
    shouldContinuePlaying = true;
    
    inputScanner = new Scanner(System.in);
  }
  
  public void run() {
    while (shouldContinuePlaying)
      handleTicTacToeGame();
  }
  
  private void handleTicTacToeGame() {
    System.out.println("You are playing as X.\n");
    System.out.println(boardFormatter.format(board));
    displayWhoStarts();
    
    isGameFinished = false;
    
    while (!isGameFinished) {
      Move move = getMoveForCurrentPlayer();
      makeMoveForCurrentPlayerWithDisplayUpdates(move);
      if (winChecker.isWinningStateForMoveOnBoard(move, board))
        handleWinForCurrentPlayer();
      else if (board.isFull())
        handleTie();
      else
        updateCurrentPlayerToNextPlayer();
    }
  }
  
  private void displayWhoStarts() {
    if (currentPlayer.isComputer())
      System.out.println("\nComputer starts.");
    else
      System.out.println("\nYou start.");
  }
  
  private Move getMoveForCurrentPlayer() {
    Move move;
    if (currentPlayer.isComputer())
      move = bestMoveGenerator.getBestMoveForBoardAndCurrentPieceToPlay(board, currentPlayer.getPiece());
    else
      move = getMoveFromCurrentPlayer();
    return move;
  }
  
  private Move getMoveFromCurrentPlayer() {
    boolean isValidPoint = false;
    Point point = null;
    while (!isValidPoint) {
      point = inquireUserForPoint();
      if (rules.isPointOutOfBounds(point)) {
        System.out.println("\n" + getStringRepresentationForPoint(point) + " is out of bounds.");
        System.out.println("Please enter the coordinates again.");
      } else if (rules.isPointTaken(point)) {
        System.out.println("\n" + getStringRepresentationForPoint(point) + " is already taken.");
        System.out.println("Please enter the coordinates again.");
      } else
        isValidPoint = true;
    }
    return new Move(currentPlayer.getPiece(), point);
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
    
    System.out.print("\nIt is your turn to play.\nPlease enter x-coordinate: ");
    xCoordinate = inputScanner.nextInt();
    inputScanner.nextLine();
    System.out.print("Please enter y-coordinate: ");
    yCoordinate = inputScanner.nextInt();
    inputScanner.nextLine();
    return new Point(xCoordinate, yCoordinate);
  }
  
  private void handleUserPointInquiryInputMismatchException() {
    inputScanner.nextLine();
    System.out.println("\nYou must enter an integer.  Please choose a point again.");
  }
  
  private String getStringRepresentationForPoint(Point point) {
    return "(" + point.x + ", " + point.y + ")";
  }
  
  private void makeMoveForCurrentPlayerWithDisplayUpdates(Move move) {
    currentPlayer.makeMoveAtPoint(move.getPoint());
    System.out.println("\n" + boardFormatter.format(board));
    
    String playerWhoMoved = currentPlayer.isComputer() ? "Computer" : "You";
    System.out.println(playerWhoMoved + " made a move at " + getStringRepresentationForPoint(move.getPoint()) + ".");
  }
  
  private void handleWinForCurrentPlayer() {
    isGameFinished = true;
    if (currentPlayer.isComputer())
      System.out.println("\nThe computer has won.");
    else
      System.out.println("\nYou have won!");
    promptUserToContinueGameOrNot();
  }
  
  private void handleTie() {
    isGameFinished = true;
    System.out.println("\nThe game has tied!");
    promptUserToContinueGameOrNot();
  }
  
  private void updateCurrentPlayerToNextPlayer() {
    if (currentPlayer == player1)
      currentPlayer = player2;
    else
      currentPlayer = player1;
  }
  
  private void promptUserToContinueGameOrNot() {    
    boolean didNotInputCorrectResponse = true;
    String continueResponse = "";
    while (didNotInputCorrectResponse) {
      System.out.print("\nWould you like to continue playing? (Y/N): ");
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
    board.reset();
    if (playerToStart == player1)
      playerToStart = currentPlayer = player2;
    else
      playerToStart = currentPlayer = player1;
    System.out.println();
  }
  
  private boolean doesUserWishesToStopPlaying(String response) {
    return response.equalsIgnoreCase("n") || response.equalsIgnoreCase("no");
  }
  
  private void handleUserWishesToStopPlaying() {
    shouldContinuePlaying = false;
    System.out.println("\nThanks for playing.");
    inputScanner.close();
  }
}
