import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class RandomPlayer extends Player 
{
	private Random generator;
	
	// Base Constrcutor without Seed
		public  RandomPlayer(String name) 
		{
			super(name);
		}
	
	// Constructor w/Seed
		public RandomPlayer(String name, long seed) 
		{
			super(name);
			Random randomGenerator = new Random();
				
			// Make local generator equal to this w/seed
				this.generator = randomGenerator;
				
			// Set seeD
				this.generator.setSeed(seed);
		}
	

	@Override
	public int[] getMove(int[] pileSizes) 
	{
		// local generator
			Random randNum =  this.generator;
		
		// Create list of possible (>0) move indices -------------------------------
			
			// Calculate size of Array if elements > 0
				int arrSize = 0;
				
				for (int i = 0; i < pileSizes.length; ++i)
				{
					if (pileSizes[i] > 0)
					{
						++arrSize;
					}
				}
			
			// Put Elements indices that are > 0 into new array
				int[] nonZeroList = new int[arrSize];
				
				int arrElement = 0;
				for (int i = 0; i < pileSizes.length; ++i)
				{
					if (pileSizes[i] > 0)
					{
						nonZeroList[arrElement] = i;
						++arrElement;
					}
				}
		
		// Choose element between 0 and pileSizes.length
			int selectIdx = randNum.nextInt(arrSize);
			int moveIndex = nonZeroList[selectIdx];
			
		// Create Move between 1 and max(pile)
			int moveNumber = randNum.nextInt(pileSizes[moveIndex]) + 1;
			
		// Generate Move
			int[] move = {moveIndex, moveNumber};
		
		return move;
	}

}
