import java.util.ArrayList;

/**
 * Calculates the ASCII value of a four-letter stationID and returns the floor
 * or ceiling depending on certain conditions
 * 
 * @author Daniel Carpenter
 * @version 2.21
 */
public class MesoInherit extends MesoAbstract {
	/**
	 * MesoStation object from constructor parameter
	 */
	private MesoStation mesoStation;
	/**
	 * Each Element stores a character from a four-character station ID
	 */
	private ArrayList<Integer> stIDCharacters = new ArrayList<Integer>();

	/**
	 * Sum of any number of station ID's ASCII values; used for average calculations
	 */
	private int sumOfAsciiValues;
	/**
	 * The average ASCII value of any number of station ID's
	 */
	private double avgOfAsciiValues;
	/**
	 * First element (char) of a four letter station ID
	 */
	private final int FIRST_ID_CHARACTER = 0;
	/**
	 * Last element (char) of a four letter station ID
	 */
	private final int LAST_ID_CHARACTER = 4;
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
	private double AVG_THRESHOLD = 0.75;
	/**
	 * int[] Array that stores the floor, ceiling, and average of a double ASCII
	 * value
	 */
	private int[] avgAsciiMetrics = new int[NUM_METRICS];

	/**
	 * Stores the mesoStation parameter locally. Calculates the avg. ASCII value of
	 * a String stID
	 * 
	 * @param A mesoStation stores the stID of a given station
	 */
	public MesoInherit(MesoStation mesoStation) {
		// Store mesoStation locally
		this.mesoStation = mesoStation;

		// Get Character values of stID
		for (int LETTER = FIRST_ID_CHARACTER; LETTER < LAST_ID_CHARACTER; ++LETTER) {
			// add the ASCII value to local arraylist
			int ascii = getMesoStation().getStID().charAt(LETTER);
			this.stIDCharacters.add(ascii);

			// Summation of ASCII values
			this.sumOfAsciiValues += this.stIDCharacters.get(LETTER);
		}

		// Calculate Average of Ascii Values
		this.avgOfAsciiValues = (double) this.sumOfAsciiValues / this.LAST_ID_CHARACTER;
	}

	/**
	 * Calculates the floor, ceiling, and average of a double stationID.
	 * 
	 * @return Returns the floor of the double stationID if < than the
	 *         AVG_THRESHOLD, else the ceiling
	 */
	@Override
	int[] calAverage() {
		// Calculate Ceiling and Floor values - store in local arraylist
		this.avgAsciiMetrics[CEIL_IDX] = (int) Math.ceil(this.getAvgOfAsciiValues());
		this.avgAsciiMetrics[FLOOR_IDX] = (int) Math.floor(this.getAvgOfAsciiValues());

		// If less than the threshold, choose calculated floor value
		if (this.getAvgOfAsciiValues() - getAvgAsciiMetrics()[FLOOR_IDX] < AVG_THRESHOLD) {
			this.avgAsciiMetrics[AVG_IDX] = getAvgAsciiMetrics()[FLOOR_IDX];
		}

		// otherwise take the ceil value
		else {
			this.avgAsciiMetrics[AVG_IDX] = getAvgAsciiMetrics()[CEIL_IDX];
		}

		return this.getAvgAsciiMetrics();
	}

	/**
	 * Returns the floor of the double stationID if < than the AVG_THRESHOLD, else
	 * the ceiling
	 * 
	 * @return Returns the ASCII value after calAverage() is executed
	 */
	@Override
	char letterAverage() {
		return (char) this.getAvgAsciiMetrics()[AVG_IDX];
	}

	// Getters
	// -------------------------------------------------------------------------
	/**
	 * Returns the mesoStation provided in the constructor
	 * 
	 * @return Returns the mesoStation provided in the constructor
	 */
	public MesoStation getMesoStation() {
		return this.mesoStation;
	}

	/**
	 * Returns ArrayList<String> of characters from a given stID
	 * 
	 * @return Returns ArrayList<String> of characters from a given stID
	 */
	public ArrayList<Integer> getStIDCharacters() {
		return this.stIDCharacters;
	}

	/**
	 * Returns the sum of a number of given stID's ASCII values
	 * 
	 * @return Returns the sum of a number of given stID's ASCII values
	 */
	public int getSumOfAsciiValues() {
		return this.sumOfAsciiValues;
	}

	/**
	 * Returns the average of a number of given stID's ASCII values
	 * 
	 * @return Returns the average of a number of given stID's ASCII values
	 */
	public double getAvgOfAsciiValues() {
		return this.avgOfAsciiValues;
	}

	/**
	 * Returns the int[] Array that holds the floor, ceiling, and average of a
	 * double ASCII value
	 * 
	 * @return Returns the int[] Array that holds the floor, ceiling, and average of
	 *         a double ASCII value
	 */
	public int[] getAvgAsciiMetrics() {
		return this.avgAsciiMetrics;
	}
}