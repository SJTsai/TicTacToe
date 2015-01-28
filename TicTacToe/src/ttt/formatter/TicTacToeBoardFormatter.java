package ttt.formatter;

import java.awt.Point;

import ttt.model.TicTacToeBoard;

public class TicTacToeBoardFormatter {

  private TicTacToeBoard board;
  
  public String format(TicTacToeBoard board) {
    this.board = board;
    
    String boardStringRepresentation = "   0  1  2\n";
    for (int row = 0; row < board.getNumberOfRows(); row++)
      boardStringRepresentation += getStringRepresentationOfRow(row) + 
      (row == board.getNumberOfRows() - 1 ? "" : "\n");
    return boardStringRepresentation;
  }
  
  private String getStringRepresentationOfRow(int row) {
    String rowStringRepresentation = row + " ";
    for (int column = 0; column < board.getNumberOfColumns(); column++)
      rowStringRepresentation += getStringRepresentationOfPoint(new Point(row, column));
    return rowStringRepresentation;
  }
  
  private String getStringRepresentationOfPoint(Point point) {
    if (board.isPieceAtPointXPiece(point))
      return getXBox();
    
    if (board.isPieceAtPointOPiece(point))
      return getOBox();
    
    return getEmptyBox();
  }
  
  private String getXBox() {
    return "[x]";
  }
  
  private String getOBox() {
    return "[o]";
  }
  
  private String getEmptyBox() {
    return "[ ]";
  }

}
