import java.util.Arrays;

public class createVerticalStripes_Example 
{
	public static void main(String[] args)
	{
		int height		= 2;
		int width		= 12;
		int stripWidth	= 3;
		
		// METHOD BELOW ----------------------------------------------			
			final int white 	= 0; // 255 <- grayscale
			final int black 	= 255;
			int color = black;
						
			int[][] array = new int[height][width];
			
			// Create the Actual array
			for (int row = 0; row < array.length; ++row)
			{
				color = black;
				for (int col = 0; col < array[0].length; ++col)
				{
					if (col % stripWidth == 0)
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
