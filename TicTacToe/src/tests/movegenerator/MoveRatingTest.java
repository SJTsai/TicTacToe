package tests.movegenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ttt.movegenerator.MoveRating;

public class MoveRatingTest {

  @Test
  public void testMoveRatingIsSame() {
    MoveRating moveRating = new MoveRating(1, 4);
    assertEquals(1, moveRating.getRating());
  }
  
  @Test
  public void testMoveRatingDepthIsSame() {
    MoveRating moveRating = new MoveRating(1, 4);
    assertEquals(4, moveRating.getDepth());
  }

}
