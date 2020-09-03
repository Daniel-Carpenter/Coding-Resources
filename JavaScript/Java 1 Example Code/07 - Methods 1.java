import java.util.Scanner;
import java.util.Arrays;

public class Project_7 
{
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		final int INITIAL_TOKENS = 10;
		final int PLAY_COST = 1;
		String prompt = "Press enter to play (spend " + PLAY_COST + " token) "
					  + "or type 'quit' to stop.";
		
		// Initialize the game.
		int tokens = INITIAL_TOKENS;
		boolean playGame = true;
		
		// Introduce the game to the player.
		System.out.println("Java Slot Machine");
		System.out.println("-----------------");
		
		// Perform a priming read.
		System.out.println("Tokens: " + tokens);
		System.out.println(prompt);
		if (keyboard.nextLine().equalsIgnoreCase("quit")) {
			playGame = false;
		}
		
		// Enter the game loop.
		while (playGame)
		{
			// Decrease the player's tokens by the cost to play the game.
			tokens = tokens - PLAY_COST;
			
			
			
			// DECLARATIONS
			int size = 3;
			int lowerBound = 2;
			int upperBound = 7;
			String message;
			
		//SORT ARRAY
			int[] wheelNums = randomIntArray(lowerBound, upperBound, size);
			System.out.println("Spin: " + Arrays.toString(wheelNums)); // print
			Arrays.sort(wheelNums); // sort
			
		// OUTPUT OF GAME
			int tokensWon = calculateWinnings(wheelNums);
			if (tokensWon == 0)
			{
				message = "Sorry, you lost :(";
			}
			else if (tokensWon == 1)
			{
				message = "Pair! You win 1 token.";
			}
			else if (tokensWon == 2)
			{
				message = "Sequence! You win 2 tokens";
			}
			else if (tokensWon == 50)
			{
				message = "Triple 7s! You win 50 tokens";
			}
			else 
			{
				message ="Triple " + wheelNums[0] + "s! You win " + (wheelNums[0] * size) + " tokens.";
			}
			
			System.out.println(message);
			
			
			//-----------------------------------------------------------------
			
			// Update the player's tokens.
			tokens = tokens + tokensWon;
			
			// Prompt the player if they still have tokens.
			if (tokens > 0) {
				System.out.println("Tokens: " + tokens);
				System.out.println(prompt);
				if (keyboard.nextLine().equalsIgnoreCase("quit")) {
					playGame = false;
				}
			}
			else {
				playGame = false;
			}
		}
		
		// Print final tokens and amount won/lost.
		System.out.println("You quit with " + tokens + " token(s).");
		System.out.println("Your net profit is " + (tokens - INITIAL_TOKENS) 
						 + " token(s).");
		
		keyboard.close();
	}
	
	/** Return a random integer between lowerBound and upperBound (inclusive).
	 * @param lowerBound  the lower bound for the random integer
	 * @param upperBound  the upper bound for the random integer
	 * @return  a random integer uniformly distributed between lowerBound and 
	 * upperBound
	 */
	public static int randomInt(int lowerBound, int upperBound)
	{
		int output = (int) (lowerBound + Math.random() * (upperBound - lowerBound + 1));
		return output;
	}
	
	/** Return an array that contains size random integers, each between 
	 * lowerBound and upperBound (inclusive).
	 * @param lowerBound  the smallest random integer that can be generated
	 * @param upperBound  the largest random integer that can be generated
	 * @param size  the number of integers in the returned array
	 * @return  a newly constructed array containing size random integers
	 */
	public static int[] randomIntArray(int lowerBound, int upperBound, int size)
	{	
	    int[] array = new int[size];
	    
	    for (int i = 0; i < array.length; i++) 
	    {
	    	array[i] = randomInt(lowerBound,upperBound);
	    }
	    return array;
	}

	/** Return the number of tokens that the player won, and print a message to 
	 * the player. (See the project instructions for details.)
	 * @param wheelNums  an array of three integers that are the numbers shown 
	 * on the slot machine wheels
	 * @return  the number of tokens won
	 */
	public static int calculateWinnings(int[] wheelNums)
	{
		int subTotal;
		
		if (wheelNums[1] == wheelNums[0] || wheelNums[2] == wheelNums[0] || wheelNums[0] == wheelNums[1] || wheelNums[2] == wheelNums[1] || wheelNums[0] == wheelNums[2] || wheelNums[1] == wheelNums[2])
		{
			subTotal = 1;
		}
		else if (wheelNums[1] == wheelNums[0] + 1 && wheelNums[2] == wheelNums[1] + 1)
		{
			subTotal = 2;
		}
		else if (wheelNums[0] != 7 && wheelNums[0] == wheelNums[1] && wheelNums[1] == wheelNums[2])
		{
			subTotal = wheelNums[0] * 3;
		}
		else if (wheelNums[0] == wheelNums[1] && wheelNums[1] == wheelNums[2] && wheelNums[0] == 7 && wheelNums[1] == 7 && wheelNums[2] == 7)
		{
			subTotal = 50;
		}
		else
		{
			subTotal = 0;
		}
	
		return subTotal;
		
	}	
}
