package tictactoe;

import static org.junit.Assert.assertTrue;

import com.sun.org.apache.bcel.internal.util.SecuritySupport;

public class Board
{
	String[][] field = new String[3][3];
	
	public Board()
	{
		int size = field.length;
		for(int i=0; i<size;i++)
			for(int j=0; j<size;j++)
				field[i][j] = "";
	}
	
	public String[][] getField()
	{
		return this.field;
	}
	
	public boolean hasWinner() 
	{
		String p[] = {"X","O"};
		
		for(int nr = 0; nr < 2; nr++)
		{
			for(int i = 0; i<3; i++)
			{
				if(field[i][0].equals(p[nr]) && field[i][1].equals(p[nr]) && field[i][2].equals(p[nr]))
				{
					return true;
				}			
			}
			
			for(int i = 0; i<3; i++)
			{
				if(field[0][i].equals(p[nr]) && field[1][i].equals(p[nr]) && field[2][i].equals(p[nr]))
				{
					return true;
				}			
			}
			
			if ( (field[0][0].equals(p[nr]) && field[1][1].equals(p[nr]) && field[2][2].equals(p[nr]))
			  || (field[2][0].equals(p[nr]) && field[1][1].equals(p[nr]) && field[2][0].equals(p[nr]))
			   ) return true;
		}
		
		return false;
	}

	public void setMark(String mark, int x, int y) throws InvalidPositionException
	{
		if (x > 2 || y > 2) throw new InvalidPositionException("");
		if (mark != "X" && mark != "O") throw new InvalidPositionException("");
		
		this.field[y][x] = mark;
	}
	
	public static void main(String[] args)
	{
		Board board = new Board();
		try 
		{
			board.setMark("X",0,0);
			board.setMark("X",1,0);
			board.setMark("X",2,0);
		} catch (InvalidPositionException e)
		{
			System.out.println("..");
		}
		
		System.out.println(board.hasWinner());
	}
}
