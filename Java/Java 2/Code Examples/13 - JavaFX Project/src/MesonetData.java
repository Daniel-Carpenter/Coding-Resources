import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads in station ID data from mesonet.txt and outputs 
 * 
 * @author Daniel Carpenter
 * @version 4.19
 */
public class MesonetData {
	/**
	 * Name of file to read; contains Mesonet data of station ID's
	 */
	private static String filename = "Mesonet.txt";


	/**
	 * Reads in mesonet.txt
	 * 
	 * @throws IOException
	 */
	public static ArrayList<String> getStationIDList() throws IOException {
		
		// List to store station IDs
		ArrayList<String> listOfStationIDs = new ArrayList<String>();
		
		// Create Reader
		Scanner scnr = new Scanner(new File(filename));

		// Instantiate		// Read in file via loop
		while (scnr.hasNextLine()) 
		{
				String line = scnr.nextLine();
				listOfStationIDs.add(line);
		}

		scnr.close();
		
		return listOfStationIDs;
	}
}
