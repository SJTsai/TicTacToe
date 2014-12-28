package main.domain.movegenerator;

public class MoveRating {

  private int rating;
  private int depth;
  
  public MoveRating(int rating, int depth) {
    this.rating = rating;
    this.depth = depth;
  }
  
  public int getRating() {
    return rating;
  }
  
  public int getDepth() {
    return depth;
  }
}
