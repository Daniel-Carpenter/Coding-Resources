import java.lang.Exception;


public class IllegalMoveException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public IllegalMoveException(String moveInfo)
    {
        // Add string to Exceptions class
        super(moveInfo);
    }
}
