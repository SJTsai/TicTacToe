package tests.domain.models.mappers;

import static org.junit.Assert.*;
import main.domain.entities.TicTacToePieceEntity;
import main.domain.models.TicTacToePiece;
import main.domain.models.mappers.TicTacToePieceMapper;

import org.junit.Before;
import org.junit.Test;

public class TicTacToePieceMapperTest {

  private TicTacToePieceMapper pieceMapper;
  
  @Before
  public void setUp() throws Exception {
    pieceMapper = new TicTacToePieceMapper();
  }

  @Test
  public void testMappedPieceIsX() {
    TicTacToePieceEntity xPieceEntity = TicTacToePieceEntity.X;
    TicTacToePiece xPiece = pieceMapper.mapTicTacToePieceEntity(xPieceEntity);
    assertEquals(TicTacToePiece.X, xPiece);
  }
  
  @Test
  public void testMappedPieceIsO() {
    TicTacToePieceEntity oPieceEntity = TicTacToePieceEntity.O;
    TicTacToePiece oPiece = pieceMapper.mapTicTacToePieceEntity(oPieceEntity);
    assertEquals(TicTacToePiece.O, oPiece);
  }

}
