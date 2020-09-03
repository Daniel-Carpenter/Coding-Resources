// Daniel Carpenter

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Project_10 
{
	public static void main(String[] args) throws IOException, FileNotFoundException
	{
		// INPUTS TO 2D ARRAY ----------------------------------------------------------------------
			int row 		= 250;
			int col 		= 250;
			int stripeWidth = 10;
			int squareWidth = 10;
			
		// CONSTRUCT IMAGES ------------------------------------------------------------------------
			saveImage("vertical-stripes.pgm"	, createVerticalStripes(row, col, stripeWidth));
			saveImage("horizontal-stripes.pgm"	, createHorizontalStripes(row, col, stripeWidth));
			saveImage("checkerboard.pgm"		, createCheckerboard(row, col, squareWidth));
			saveImage("diagonal-stripes.pgm"	, createDiagonalStripes(row, col, stripeWidth));		
			
	}
	
	// SAVE IMAGE METHOD ---------------------------------------------------------------------------
		public static void saveImage(String filename, int[][] image) throws IOException, FileNotFoundException
		{
			PrintWriter writer = new PrintWriter(new File(filename));
			
			int color = 255; // 255 <- grayscale
			
			// Construct the Image ----------------------------------------------------------------
				writer.println("P2"); 									// P2
				writer.println(image.length + " " + image[0].length);	// row height
				writer.println(color);									// 255
	
				// Create the Actual Image
				for (int i = 0; i < image.length; ++i)
				{
					writer.println(Arrays.toString(image[i]));					// need to make print
				}			

			// Close the File ---------------------------------------------------------------------
				writer.flush();
				writer.close();
		}
		
	// VERTICAL STRIPE METHOD ----------------------------------------------------------------------
		public static int[][] createVerticalStripes(int height, int width, int stripeWidth)
		{
			final int white = 0; // 255 <- grayscale
			final int black = 255;
			int color = black;
						
			int[][] array = new int[height][width];
			
			// Create the Actual array
			for (int row = 0; row < array.length; ++row)
			{
				color = black;
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
					
					array[row][col] = color;
				}
			}
		
		return array;	
		}
	
	// HORIZONAL STRIPE METHOD ---------------------------------------------------------------------
		public static int[][] createHorizontalStripes(int height, int width, int stripeWidth)
		{
			final int white 	= 0; // 255 <- grayscale
			final int black 	= 255;
			int color = black;
						
			int[][] array = new int[height][width];
			
			// Create the Actual array
			for (int row = 0; row < array.length; ++row)
			{	
				if (row % (stripeWidth * 2) >= stripeWidth)
				{
					color = black;
				}
				else
				{
					color = white;
				}
				
				for (int col = 0; col < array[0].length; ++col)
				{
					array[row][col] = color;
				}
			}
			
			return array;
		}
	
	// CHECKBOARD METHOD ---------------------------------------------------------------------------
		public static int[][] createCheckerboard(int height, int width, int squareWidth)
		{
				final int white 	= 0; // 255 <- grayscale
				final int black 	= 255;
				int color = black;
							
				int[][] array = new int[height][width];
				
				// Create the Actual array
				for (int row = 0; row < array.length; ++row)
				{
					// OUTER LOOP --------------------------------------------					
						if (row % squareWidth == 0)
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
							if (col == 0)
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
							if (col % squareWidth == 0)
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
				
				}
			return array;
		}
				
	// DIAGONAL METHOD ----------------------------------------------------------------------------
		public static int[][] createDiagonalStripes(int height, int width, int stripeWidth)
		{
			
			// METHOD BELOW ----------------------------------------------			
				final int white 	= 0; // 255 <- grayscale
				final int black 	= 255;
							
				int[][] array = new int[height][width];
				
				// OUTER LOOP
				for (int row = 0; row < array.length; ++row)
				{
					// INNER LOOP
					for (int col = 0; col < array[0].length; ++col)
					{						
						if ((col + row) % (stripeWidth*2) < stripeWidth)
						{
							array[row][col] = white;
							
						}
						else 
						{
							array[row][col] = black;
						}
					}
					
				
				}
			return array;
		}
}
