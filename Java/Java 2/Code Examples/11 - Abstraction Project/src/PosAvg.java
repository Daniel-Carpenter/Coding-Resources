import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reads the file "Mesonet.txt" and calculates the position of a given station
 * ID. Also, it calculates combinations of other station ID's that average the
 * aforementioned position.
 * 
 * @author Daniel Carpenter
 * @version 2.21
 */
public class PosAvg {
	/**
	 * Stores String stID (or stationID) passed in constructor
	 */
	private String stID;
	/**
	 * The position of the stID in the file (idx + 1)
	 */
	private int indexOfStationID;
	/**
	 * ArrayList<String> that stores the the stID names from "Mesonet.txt"
	 */
	public ArrayList<String> listOfStationIDs = new ArrayList<String>();

	/**
	 * Filename that stores station ID's
	 */
	private String filename = "Mesonet.txt";
	/**
	 * First row of the file
	 */
	private int FIRST_ROW_OF_FILE = 1;
	/**
	 * Number of rows to not read (or ignore)
	 */
	private int NUM_NULL_ROWS_TO_IGNORE = 4; // number of rows that do not contain data
	/**
	 * Index of first character within the given String stID
	 */
	private int FIRST_LETTER_IN_STID = 0;
	/**
	 * Index of last character within the given String stID
	 */
	private int LAST_LETTER_IN_STID = 5;

	/**
	 * Creates PosAvg object and reads in "Mesonet.txt," which includes station ID
	 * data
	 * 
	 * @throws IOException
	 */
	public PosAvg() throws IOException {
		// Read in Data from Mesonet.txt
		readFileStationIDs(this.filename);
	}

	/**
	 * Creates PosAvg object while storing the String stID, while reading
	 * "Mesonet.txt," which includes station ID data
	 * 
	 * @throws IOException
	 */
	public PosAvg(String stID) throws IOException {
		// Store stID Arg
		this.stID = stID;

		// Read in Data from Mesonet.txt
		readFileStationIDs(this.filename);
	}

	/**
	 * Reads in file and parses four character String objects into an
	 * ArrayList<String>
	 * 
	 * @param filename Name of file to read
	 * @throws IOException
	 */
	public void readFileStationIDs(String filename) throws IOException {
		// Create Reader
		BufferedReader reader = new BufferedReader(new FileReader(filename));

		// Instantiate
		int rowNum = FIRST_ROW_OF_FILE;
		String line = reader.readLine();

		// Read in file via loop
		while (line != null) {
			// Don't read in data describing what the data is
			if (rowNum < NUM_NULL_ROWS_TO_IGNORE) {
				line = reader.readLine();
			}

			// Read in Actual Data
			else {
				// Parse first column of STID's
				String newStationID = line.substring(this.FIRST_LETTER_IN_STID, this.LAST_LETTER_IN_STID).trim();
				this.listOfStationIDs.add(newStationID);

				// Get index of the Input stID from constructor
				if (newStationID.equals(this.stID)) {
					this.indexOfStationID = rowNum - this.NUM_NULL_ROWS_TO_IGNORE;
				}

				// Read in next Line
				line = reader.readLine();
			}

			// Increment to next Line
			++rowNum;
		}

		reader.close();
	}

	/**
	 * Calculates the position of the stID in the file (idx + 1)
	 * 
	 * @return Returns the position of the stID in the file (idx + 1)
	 */
	public int indexOfStation() // from file
	{
		// This is straight from the project description:
		// ----------------------------------------------------------
		// If you calculate the Index of NRMN in the Mesonet.txt file,
		// starting from 1 is 77. Remember, array index 0 is the
		// first element, i.e., for the first element, index is 1.
		return this.indexOfStationID + this.FIRST_ROW_OF_FILE;
	}

	/**
	 * The actual index (not "position") of the stID in the file
	 * 
	 * @return Returns the actual index (not "position") of the stID in the file
	 */
	private int getActualIndexOfStation() // from ArrayList
	{
		return this.indexOfStationID; // Position Index of input stID
	}

	/**
	 * Generates a String describing the position value, as well as some
	 * combinations of stID's that average to the given ASCII average
	 * 
	 * @return Returns the concenated String from the method's summary description
	 */
	public String toString() {
		// stIDs that avg to input stID (not a loop because finite)
		int oneBelowStationIDIdex = this.getActualIndexOfStation() - 1;
		int oneAboveStationIDIdex = this.getActualIndexOfStation() + 1;
		int twoBelowStationIDIdex = this.getActualIndexOfStation() - 2;
		int twoAboveStationIDIdex = this.getActualIndexOfStation() + 2;

		// Get the Contents (Strings) of the stID(idx)
		String avgStationIDFromMinusOne = this.getStationIDFromIndex(oneBelowStationIDIdex);
		String avgStationIDFromPlusOne = this.getStationIDFromIndex(oneAboveStationIDIdex);
		String avgStationIDFromMinusTwo = this.getStationIDFromIndex(twoBelowStationIDIdex);
		String avgStationIDFromPlusTwo = this.getStationIDFromIndex(twoAboveStationIDIdex);

		// Output String
		String output = "This index is average of " + avgStationIDFromMinusOne + " and " + avgStationIDFromPlusOne
				+ ", " + avgStationIDFromMinusTwo + " and " + avgStationIDFromPlusTwo + ", and so on.";

		return output;
	}

	// Getters
	// -----------------------------------------------------------------------

	/**
	 * Returns the station ID passed in the constructor
	 * 
	 * @return Returns the station ID passed in the constructor
	 */
	public String getStationID() {
		return this.stID;
	}

	/**
	 * Gets a String stID (given an index) from the local ArrayList<String>, which
	 * houses the list of stID's
	 * 
	 * @param index
	 * @return Returns String stID (given an index) from the local ArrayList<String>
	 */
	public String getStationIDFromIndex(int index) {
		return this.listOfStationIDs.get(index);
	}

	/**
	 * Returns ArrayList<String> that stores station ID names from "Mesonet.txt"
	 * 
	 * @return Returns ArrayList<String> that stores station ID names from
	 *         "Mesonet.txt"
	 */
	public ArrayList<String> getListOfStationIDs() {
		return this.listOfStationIDs;
	}
}
