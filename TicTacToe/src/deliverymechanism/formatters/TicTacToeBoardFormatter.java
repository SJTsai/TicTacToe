package deliverymechanism.formatters;

import java.awt.Point;

import main.domain.models.TicTacToeBoard;
import deliverymechanism.formatters.interfaces.BoardFormatter;

public class TicTacToeBoardFormatter implements BoardFormatter {

  private TicTacToeBoard board;
  
  @Override
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
    if (board.isXPieceAtPoint(point))
      return getXBox();
    
    if (board.isOPieceAtPoint(point))
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
