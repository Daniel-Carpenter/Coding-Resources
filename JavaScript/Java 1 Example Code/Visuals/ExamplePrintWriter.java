import java.io.File;  
import java.io.PrintWriter;
import java.util.Arrays; 
	
public class ExamplePrintWriter 
{
	public static void main(String[] args) throws Exception 
	{  
		// MAIN BELOW ------------------------------------------------------------------------
		String filename = "image.txt";
		int row = 3;
		int col = 2;
		int[][] image = new int[row][col];
		
		// METHOD BELOW ----------------------------------------------------------------------
		
		
		PrintWriter writer = new PrintWriter(new File(filename));
		
		row = 0; // remember to re-declare
		col = 0; // remember to re-declare
		int color = 255; // grayscale
		
		// Construct the Image ----------------------------------------------------------------
		for (row = 0; row < image.length; ++row)
		{
			for (col = 0; col < image[0].length; ++col)
			{
				image[row][col] = 42;
			}
		}
		
		// Write the File ---------------------------------------------------------------------
			writer.println("P2");					// P2
			writer.println(row + " " + col);		// row height
			writer.println(color);					// 255
			writer.println(Arrays.toString(image));	// image[row][col]
		
		writer.flush();
		writer.close(); 
	}  
}
