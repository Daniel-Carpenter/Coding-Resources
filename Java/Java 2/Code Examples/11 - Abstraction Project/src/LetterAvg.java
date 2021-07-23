import java.io.IOException;
import java.util.ArrayList;

/**
 * Calculates the average ASCII value each character in a sting and then reports
 * other String objects with the same average
 * 
 * @author Daniel Carpenter
 * @version 2.21
 */
public class LetterAvg {
	/**
	 * Storage of constructor parameter
	 */
	private char letterAvg;
	/**
	 * ArrayList<String> that stores String stID's
	 */
	private ArrayList<String> stationIDs;
	/**
	 * Concatenated String that stores a names of stID's with matching ASCII values
	 */
	private String matchingStIDs;
	/**
	 * Count of stID's with matching ASCII values
	 */
	private int matchingCount;

	/**
	 * Constructs LetterAvg and stores parameter in Class. Creates a posAvg object
	 * which reads in stID data from "Mesonet.txt"
	 * 
	 * @param letterAvg an int value representing an average ASCII value
	 * @throws IOException
	 */
	public LetterAvg(char letterAvg) throws IOException {
		this.letterAvg = letterAvg;
		this.matchingStIDs = "";

		// Get List of stationIDs
		PosAvg posAvg = new PosAvg();
		this.stationIDs = posAvg.getListOfStationIDs();
	}

	/**
	 * Counts the number of stID's in the ArrayList<String> stationID's with the
	 * same given average ASCII value from the constructor
	 * 
	 * @return Returns a count of stID's with the same average ASCII value as the
	 *         one passed in the constructor
	 */
	public int numberOfStationWithLetterAvg() {
		int MAX_ROW = this.getStationIDs().size();
		int FIRST_CHAR = 0;

		// For loop looking through the arrayList from PosAvg
		for (int row = 0; row < MAX_ROW; ++row) {
			if (this.letterAvg == this.getStationIDs().get(row).charAt(FIRST_CHAR)) {
				// Add matching (char) letter avgs to new private arraylist
				this.matchingStIDs += this.getStationIDs().get(row) + " ";

				// count number of matching chars with starting var
				++this.matchingCount;
			}
		}

		return this.getMatchingCount();
	}

	/**
	 * Returns a concatenated String that stores a names of stID's with matching
	 * ASCII values
	 * 
	 * @return Returns a concatenated String that stores a names of stID's with
	 *         matching ASCII values
	 */
	public String toString() {
		return "These stations are: " + matchingStIDs.trim();
	}

	// Getters
	// -------------------------------------------------------------------------

	/**
	 * Returns ArrayList<String> of stID data received from posAvg class object
	 * 
	 * @return Returns ArrayList<String> of stID data received from posAvg class
	 *         object
	 */
	public ArrayList<String> getStationIDs() {
		return this.stationIDs;
	}

	/**
	 * Returns count of stID's with matching ASCII values
	 * 
	 * @return Returns count of stID's with matching ASCII values
	 */
	public int getMatchingCount() {
		return matchingCount;
	}

}
