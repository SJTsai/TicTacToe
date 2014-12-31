package main.domain.models;

import java.awt.Point;
import java.util.List;

public class TicTacToeBoard {

  private int numberOfRows;
  private int numberOfColumns;
  private List<Point> xPoints;
  private List<Point> oPoints;
  
  public void setNumberOfRows(int numberOfRows) {
    this.numberOfRows = numberOfRows;
  }
  
  public int getNumberOfRows() {
    return numberOfRows;
  }
  
  public void setNumberOfColumns(int numberOfColumns) {
    this.numberOfColumns = numberOfColumns;
  }
  
  public int getNumberOfColumns() {
    return numberOfColumns;
  }
  
  public void setXPoints(List<Point> xPoints) {
    this.xPoints = xPoints;
  }
  
  public List<Point> getXPoints() {
    return xPoints;
  }
  
  public void setOPoints(List<Point> oPoints) {
    this.oPoints = oPoints;
  }
  
  public List<Point> getOPoints() {
    return oPoints;
  }
  
}
