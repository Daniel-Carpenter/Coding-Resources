import java.util.Arrays;

public class createDiagonalStripes_Example 
{
	public static void main(String[] args)
	{
		int height		= 9;
		int width		= 9;
		int stripWidth	= 3;
		
		// METHOD BELOW ----------------------------------------------			
			final int white 	= 0; // 255 <- grayscale
			final int black 	= 255;
			int color = white;
						
			int[][] array = new int[height][width];
			
			// OUTER LOOP
			for (int row = 0; row < array.length; ++row)
			{
				// INNER LOOP
				for (int col = 0; col < array[0].length; ++col)
				{						
					if ((col + row) % (stripWidth*2) < stripWidth)
					{
						array[row][col] = black;
						
					}
					else 
					{
						array[row][col] = white;
					}
				}
				
			}
	}
}


