package tictactoe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author abq275
 *
 */

public class BoardTest
{
	Board board;
	
	@Before
	public void setUp()
	{
		this.board = new Board();
	}
	
	@After
	public void tearDown()
	{
		this.board = null;
	}
	
	@Test
	public void emptyBoard()
	{
		String field[][] = board.getField();
		for(String[] row : field)
		{
			for(String cell : row)
			{
				assertTrue(cell == "");
			}
		}
	}
	
	@Test
	public void setValidMarkNoWinner() throws InvalidPositionException
	{
		board.setMark("X", 0, 0);
		assertEquals(board.getField()[0][0],"X");
		assertFalse(board.hasWinner());
	}
	
	@Test
	public void setValidMarkWinner() throws InvalidPositionException
	{
		board.setMark("X",0,0);
		board.setMark("X",1,0);
		board.setMark("X",2,0);
		assertTrue(board.hasWinner());
		
		board = new Board();
		board.setMark("O",0,0);
		board.setMark("O",1,1);
		board.setMark("O",2,2);
		assertTrue(board.hasWinner());
		
	}
	
	@Test (expected = InvalidPositionException.class)
	public void SetNonValidMark() throws InvalidPositionException
	{
		board.setMark("A",0,0);
		board.setMark("X",3,3);
	}

}
