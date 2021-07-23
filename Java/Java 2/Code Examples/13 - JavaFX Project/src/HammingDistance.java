import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Calculates the Hamming Distance of two String station ID's
 * 
 * @author Daniel Carpenter
 * @version 4.19
 */
public class HammingDistance {

	// Sum and Avg Calculations in Constructor
	/**
	 * First element (char) of a four letter station ID
	 */
	private static final int FIRST_ID_CHARACTER = 0;
	/**
	 * Last element (char) of a four letter station ID
	 */
	private static final int LAST_ID_CHARACTER = 4;

	
	/**
	 * Takes the average of the ASCII values for a four letter stID String
	 * 
	 * @param Two station ID's to calculate the hamming distances between
	 * @return Hamming distance between two four-letter Strings
	 */
	public static int calcHammDistOfSTID(String stID1, String stID2)
	{
		// Initialize Count to 0
			int STID_Count = 0;	
			
		// Count characters that equal each other from two parameter STIDS
			for (int LETTER = FIRST_ID_CHARACTER; LETTER < LAST_ID_CHARACTER; ++LETTER)
			{
				if (stID1.charAt(LETTER) != stID2.charAt(LETTER))
				{
					++STID_Count;
				}
			}
		
		return STID_Count;
	}
	
	/**
	 * Creates a list of stID's that have matching Hamming Distances as the provided stID
	 * 
	 * @param stID Given four-letter String representing a station ID
	 * @param selectedHammDist int hamming distance value to compare
	 * @return returns a list of stID's that match the HD of the the stID's from mesonet.txt file, 
	 * then evaluating if the value equals the selectedHammDist
	 * @throws IOException
	 */
	public static ArrayList<String> getListOfSameHammDists(String stID, 
														   int selectedHammDist, 
														   List<String> stIDList) throws IOException
	{
		// ArrayList of same hamming distances as the stID passed in the method
			ArrayList<String> sameStIDList = new ArrayList<String>();
			
			
		// Count Number of Same Hamming Distances of each in list and Parameter STID
			
			for (String otherStID : stIDList)
			{
				if (calcHammDistOfSTID(stID, otherStID) == selectedHammDist)
				{
					sameStIDList.add(otherStID);
				}
			}
		
		return sameStIDList;
	}
	
	/**
	 * Creates a HashMap<Integer, Integer> resembling a frequency table.
	 * The table shows a count of stID's per Hamming Distances with resepect to the
	 * given stID
	 * 
	 * @param stID Given four-letter String representing a station ID
	 * @return HashMap<Integer, Integer>, where the key represents a given hamming distance (from 0 - 4),
	 * and the value is a count of the stID's with the same hamming distance with respect to the selected stID
	 * @throws IOException
	 */
	public static HashMap<Integer, Integer> getHDFrequency(String stID, List<String> stIDList) throws IOException
	{
		
		// Hashmap of the distance, and frequency
		HashMap<Integer, Integer> frequencyTable = new HashMap<Integer, Integer>();
		// Count Number Hamming Distances per tier (0-4)
		
		final int LOWER_BOUND = 0; // inclusive
		final int UPPER_BOUND = 4; // inclusive
		
		for (Integer i = LOWER_BOUND; i <= UPPER_BOUND; ++i)
		{
			Integer count = 0;
			
			for (String otherStID : stIDList)
			{
				if (calcHammDistOfSTID(stID, otherStID) == i)
				{
					++count;
				}				
			}
			frequencyTable.put(i, count);
		}
		
		return frequencyTable;
	}
}