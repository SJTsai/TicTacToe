package tests.domain.movegenerator;

import static org.junit.Assert.assertEquals;
import main.domain.movegenerator.MoveRating;

import org.junit.Test;

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
