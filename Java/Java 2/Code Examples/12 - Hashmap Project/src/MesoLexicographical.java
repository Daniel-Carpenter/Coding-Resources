import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Sorts a HashMap<String, Integer> by the key String
 * 
 * @author Daniel Carpenter
 * @version 3.15
 */
public class MesoLexicographical extends MesoSortedAbstract {
	/**
	 * Stores HashMap<String, Integer> passed in the constructor
	 */
	private HashMap<String, Integer> asciiVal;

	/**
	 * Constructs MesoLexicographical object and stores HashMap<String, Integer>
	 * 
	 * @param asciiVal is an unsorted HashMap<String, Integer>
	 */
	public MesoLexicographical(HashMap<String, Integer> asciiVal) {
		this.asciiVal = asciiVal;
		sortedMap(asciiVal);
	}

	/**
	 * Sorts the HashMap<String, Integer> passed from the constructor and prints to
	 * the console
	 * 
	 * @return Returns a sorted version of hashmap, as well prints it to the console
	 */
	@Override
	public HashMap<String, Integer> sortedMap(HashMap<String, Integer> unsorted) {
		Map<String, Integer> sorted = new TreeMap<String, Integer>();
		HashMap<String, Integer> outputSorted = new HashMap<String, Integer>();

		// Add unsorted to TreeMap (which sorts)
		sorted.putAll(unsorted);

		for (HashMap.Entry<String, Integer> stID : sorted.entrySet()) {
			// Print key
			System.out.println(stID.getKey());

			// Add key to output HashMap
			outputSorted.put(stID.getKey(), stID.getValue());
		}

		return outputSorted;
	}

	/**
	 * Returns the ASCII value passed in the constructor
	 * 
	 * @return Returns HashMap<String, Integer> asciiVal passed from constructor
	 */
	public HashMap<String, Integer> getAsciiVal() {
		return asciiVal;
	}

}