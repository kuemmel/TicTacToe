package tictactoe;

public class InvalidPositionException extends Exception
{
	public InvalidPositionException(String string)
	{
		super(string);
	}
}
