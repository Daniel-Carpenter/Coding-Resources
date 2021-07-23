import java.util.ArrayList;

/**
 * Calculates the ASCII value of stID and compares and averages the ASCII value
 * of "NRMN"
 * 
 * @author Daniel Carpenter
 * @version 3.15
 */
public class MesoAsciiCal extends MesoAsciiAbstract {
	// Local and Constructor Vars
	/**
	 * MesoStation object from constructor parameter
	 */
	private MesoStation mesoStation;
	/**
	 * Fixed String containing "NRMN" station ID
	 */
	private String FIXED_ID = "NMRN";

	// Sum and Avg Calculations in Constructor
	/**
	 * First element (char) of a four letter station ID
	 */
	private final int FIRST_ID_CHARACTER = 0;
	/**
	 * Last element (char) of a four letter station ID
	 */
	private final int LAST_ID_CHARACTER = 4;

	// Ceiling, floor, and Avg calculations
	/**
	 * Length of an array that stores three values
	 */
	private int NUM_METRICS = 3; // ceil, floor, avg (count = 3)
	/**
	 * Index of an array that stores the value from a Math.ceil(x) function
	 */
	private int CEIL_IDX = 0;
	/**
	 * Index of an array that stores the value from a Math.floor(x) function
	 */
	private int FLOOR_IDX = 1;
	/**
	 * Index of an array that stores the value from an average function
	 */
	private int AVG_IDX = 2;
	/**
	 * Take the floor of a value if less than the AVG_THRESHOLD, else returns the
	 * ceiling of a given value.
	 */
	private double AVG_THRESHOLD = 0.25;

	/**
	 * Stores the mesoStation parameter locally
	 * 
	 * @param A mesoStation stores the stID of a given station
	 */
	public MesoAsciiCal(MesoStation mesoStation) {
		// Store mesoStation locally
		this.mesoStation = mesoStation;
	}

	/**
	 * Takes the average of the ASCII values for a four letter stID String
	 * 
	 * @param stID A given station ID
	 * @return Returns the average ASCII value for the Chars in the given String
	 *         stID
	 */
	public double avgOfAsciiValues(String stID) {
		int sumOfAsciiValues = 0;
		double avgOfAsciiValues = 0;
		ArrayList<Integer> stIDCharacters = new ArrayList<Integer>();

		// Get Character values of stID
		for (int LETTER = FIRST_ID_CHARACTER; LETTER < LAST_ID_CHARACTER; ++LETTER) {
			// add the ASCII value to local arraylist
			int ascii = stID.charAt(LETTER);
			stIDCharacters.add(ascii);

			// Summation of ASCII values
			sumOfAsciiValues += stIDCharacters.get(LETTER);
		}

		// Calculate Average of Ascii Values
		avgOfAsciiValues = (double) sumOfAsciiValues / LAST_ID_CHARACTER;

		return avgOfAsciiValues;
	}

	/**
	 * Performs calculations of Math.floor(x) or Math.ceil(x) given the
	 * AVG_THRESHOLD
	 * 
	 * @param stID A given four letter String stID
	 * @return Returns the floor of the average ASCII values if less than 0.25, else
	 *         returns the ceiling.
	 */
	public int getAvgOfStationID(String stID) {
		double avgOfAsciiValues = avgOfAsciiValues(stID);
		int[] avgAsciiMetrics = new int[NUM_METRICS];

		// Calculate Ceiling and Floor values - store in local arraylist
		avgAsciiMetrics[CEIL_IDX] = (int) Math.ceil(avgOfAsciiValues);
		avgAsciiMetrics[FLOOR_IDX] = (int) Math.floor(avgOfAsciiValues);

		// If less than the threshold, choose calculated floor value
		if (avgOfAsciiValues - avgAsciiMetrics[FLOOR_IDX] < AVG_THRESHOLD) {
			avgAsciiMetrics[AVG_IDX] = avgAsciiMetrics[FLOOR_IDX];
		}

		// otherwise take the ceil value
		else {
			avgAsciiMetrics[AVG_IDX] = avgAsciiMetrics[CEIL_IDX];
		}

		return avgAsciiMetrics[AVG_IDX];
	}

	/**
	 * Overrides calAverage() and takes the average of two values
	 * 
	 * @return Returns the average ASCII value between the local stID and a fixed
	 *         stID, "NRMN"
	 */
	@Override
	public int calAverage() {
		final int NUM_IDS = 2;
		int variableAvgOfStationID = getAvgOfStationID(getMesoStation().getStID());
		int fixedAvgOfStationID = getAvgOfStationID(FIXED_ID);

		return (variableAvgOfStationID + fixedAvgOfStationID) / NUM_IDS;
	}

	// Getters
	// -------------------------------------------------------------------------

	/**
	 * @return Returns the mesoStation provided in the constructor
	 */
	public MesoStation getMesoStation() {
		return this.mesoStation;
	}
}