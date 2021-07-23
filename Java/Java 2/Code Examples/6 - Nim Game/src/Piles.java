import java.util.Arrays;
import java.lang.Integer;

public class Piles 
{
	private int[] sizes;
	private int[] move;
	
	public Piles(int[] sizes) throws InvalidInitPilesException
	{		
		// Test if error in Pile constructor then throw InvalidInitPilesException, else set private array to sizes
			try
			{
				// See if Array is Null
					if (sizes == null)
					{
						throw new InvalidInitPilesException();												
					}
				
				// See if Array has length of Zero
					if (sizes.length == 0)
					{
						throw new InvalidInitPilesException();								
					}
				
				// See if Array contains Negative values in Elements
					int iters = sizes.length - 1;
					
					for (int SIZE_ELMT = 0; SIZE_ELMT <= iters; ++SIZE_ELMT)
					{
						if (sizes[SIZE_ELMT] < 1)
						{
							throw new InvalidInitPilesException();				
						}					
					}		
				
				// See Array if passes all conditions (throws will go straight to catch)
					this.sizes = Arrays.copyOf(sizes, sizes.length);
			}
		
		// Iferror then send InvalidInitPilesException to console
			catch (InvalidInitPilesException excpt)
			{
				throw excpt;
			}
	}
	
	public int[] getSizes()
	{
		// Copy sizes to protect data
		int[] copyOfSizes = Arrays.copyOf(sizes, sizes.length);
		
		// Return stored 
		return copyOfSizes;
	}

	public void removeObjects(int[] move) throws IllegalMoveException
	{
		final int PILE_IDX = 0;
		final int NUM_IDX  = 1;
		final int CORRECT_LENGTH = 2;
		
		try
		{
			// EXCEPTIONS LIST -------------------------------------------------------------------------
				// Null Array Exception
					if (move == null)
					{
						throw new IllegalMoveException("null move");
					}
				
				// Incorrect Length (not 2) Exception
					if (move.length != CORRECT_LENGTH)
					{
						throw new IllegalMoveException("Invalid length: " + move.length);
					}
					
				// Pile index != pile.length - 1
					if (move[PILE_IDX] > this.sizes.length - 1 || move[PILE_IDX] < 0)
					{
						throw new IllegalMoveException("Pile index out of range: " + move[PILE_IDX]);					
					}
					
				// pile has a size of 0 exception
					if (this.getSizes()[move[PILE_IDX]] == 0)
					{
						throw new IllegalMoveException("Pile " + move[PILE_IDX] + " is empty.");										
					}
				
				// object number is less than or equal to 0
					if (move[NUM_IDX] < 0)
					{
						throw new IllegalMoveException("Nonpositive object number: " + move[NUM_IDX]);										
					}
					
				// object number is greater than the pile size
					if (move[NUM_IDX] > this.getSizes()[move[PILE_IDX]])
					{
						throw new IllegalMoveException("Object number greater than pile size: " 
														+ move[NUM_IDX] + " > " + this.getSizes()[move[PILE_IDX]]);
					}
				
			// ELSE -> Remove num from idx --------------------------------------------------------------
				this.sizes[move[PILE_IDX]] -= move[NUM_IDX];
				this.move = move;
		}
		
		catch (IllegalMoveException illMove)
		{
			throw illMove;
		}
	}
	
	public boolean isEmpty()
	{
		int count = 0;
		
		// Count number of empty piles
			for (int PILE_IDX = 0; PILE_IDX < this.getSizes().length; ++PILE_IDX)
			{
				if (this.getSizes()[PILE_IDX] == 0)
				{
					++count;
				}
			}
		
		// Return true if all the piles are empty
			if (count == this.getSizes().length)
			{
				return true;
			}
			else
			{
				return false;
			}
	}
}

