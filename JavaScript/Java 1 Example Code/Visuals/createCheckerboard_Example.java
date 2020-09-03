import java.util.Arrays;

public class createCheckerboard_Example 
{
	public static void main(String[] args)
	{
		int height		= 25;
		int width		= 25;
		int stripeWidth	= 5;
		
		// METHOD BELOW ----------------------------------------------			
			final int white 	= 0; // 255 <- grayscale
			final int black 	= 255;
			int color = white;
						
			int[][] array = new int[height][width];
			
			// Create the Actual array
			for (int row = 0; row < array.length; ++row)
			{
				// OUTER LOOP --------------------------------------------
					if (row % stripeWidth == 0)
					{
						if (color == white)
						{
							color = black;
						}
						else
						{
							color = white;
						}
					}
				// INNER LOOP --------------------------------------------
					for (int col = 0; col < array[0].length; ++col)
					{						
						if (col % stripeWidth == 0)
						{
							if (color == white)
							{
								color = black;
							}
							else
							{
								color = white;
							}
						}
						
						if (col == (width - 1))
						{
							if (color == white)
							{
								color = black;
							}
							else
							{
								color = white;
							}
						}
						
						array[row][col] = color;

					}
				System.out.println(Arrays.toString(array[row]));
			}
	}
}
