import java.util.Arrays;

public class createHorizontalStripes_Example 
{
	public static void main(String[] args)
	{
		int height		= 4;
		int width		= 6;
		int stripeWidth	= 1;
		
		// METHOD BELOW ----------------------------------------------			
			final int white 	= 0; // 255 <- grayscale
			final int black 	= 255;
			int color = black;
						
			int[][] array = new int[height][width];
			
			// Create the Actual array
			for (int row = 0; row < array.length; ++row)
			{
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
				
				for (int col = 0; col < array[0].length; ++col)
				{
					array[row][col] = color;
				}
				System.out.println(Arrays.toString(array[row]));
			}
	}
}
