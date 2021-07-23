import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Reads in station ID data and performs useful calculations on the data
 * 
 * @author Daniel Carpenter
 * @version 3.15
 */
public class MesoEquivalent {
	/**
	 * Stores MesoAsciiCal object passed from Constructor
	 */
	private MesoAsciiCal mesoCal;
	/**
	 * Stores a list of String stID's that have equal average ASCII values from
	 * calAverage()
	 */
	private HashMap<String, Integer> equalStIDs = new HashMap<String, Integer>();
	/**
	 * ArrayList<String> of station ID's from Mesonet.txt file
	 */
	private ArrayList<String> listOfStationIDs = new ArrayList<String>();

	// File Read
	/**
	 * Name of file to read; contains Mesonet data of station ID's
	 */
	private String filename = "Mesonet.txt";
	/**
	 * int value to resemble the first row (or line) of the file.
	 */
	private int FIRST_ROW_OF_FILE = 1;
	/**
	 * int value to resemble the rows (or lines) of the file that contain data not
	 * pertaining to this Class' usage.
	 */
	private int NUM_NULL_ROWS_TO_IGNORE = 4; // number of rows that do not contain data
	/**
	 * int element value that resembles the first element (char) of a String
	 */
	private int FIRST_LETTER_IN_STID = 0;
	/**
	 * int element value that resembles the last element (char) of a String
	 */
	private int LAST_LETTER_IN_STID = 4;

	/**
	 * Constructs MesoEquivalent object and stores the parameter
	 * 
	 * @param stID A String Station ID object
	 * @throws IOException
	 */
	public MesoEquivalent(String stID) throws IOException {
		MesoAsciiCal mesoCal = new MesoAsciiCal(new MesoStation(stID));
		this.mesoCal = mesoCal;

		readFileStationIDs(filename);
	}

	/**
	 * Reads in file and fixes issues with data by trimming and parsing lines
	 * 
	 * @param filename Name of the file to read
	 * @throws IOException
	 */
	public void readFileStationIDs(String filename) throws IOException {
		// Create Reader
		Scanner scnr = new Scanner(new File(filename));

		// Instantiate
		int rowNum = FIRST_ROW_OF_FILE;

		// Read in file via loop
		while (scnr.hasNextLine()) {

			// Don't read in data describing what the data is
			if (rowNum < NUM_NULL_ROWS_TO_IGNORE) {
				scnr.nextLine();
			}

			// Read in Actual Data
			else {
				String line = scnr.nextLine().trim().substring(FIRST_LETTER_IN_STID, LAST_LETTER_IN_STID);
				this.listOfStationIDs.add(line);
			}

			// Increment to next Line
			++rowNum;
		}

		scnr.close();
	}

	/**
	 * Adds other stID's (than constructor's parameter) which match the local stID's
	 * average ASCII value
	 * 
	 * @return Returns HashMap<String, Integer> containing String stIDs and an index
	 *         for the Integer value
	 */
	public HashMap<String, Integer> calAsciiEqual() {
		int localAsciiAvg = getMesoCal().calAverage();

		// Put if same mesoAvg
		for (String stID : this.listOfStationIDs) {
			int stIDAsciiAvgFromFile = new MesoAsciiCal(new MesoStation(stID)).calAverage();

			if (stIDAsciiAvgFromFile == localAsciiAvg) {
				equalStIDs.put(stID, stIDAsciiAvgFromFile);
			}
		}

		return equalStIDs;
	}

	// Getters ---------------------------------------------------------------------

	/**
	 * @return Returns the MesoAsciiCal object passed from the constructor
	 */
	public MesoAsciiCal getMesoCal() {
		return mesoCal;
	}
}
