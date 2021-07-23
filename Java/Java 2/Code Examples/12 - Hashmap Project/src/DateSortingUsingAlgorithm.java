import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Algorithm for sorting LocalDate objects in descending or ascending order
 * 
 * @author Daniel Carpenter
 * @version 3.15
 */
public class DateSortingUsingAlgorithm {
	/**
	 * Stores DateTimeThree dates field from constructor
	 */
	private DateTimeThree dates;
	/**
	 * Filename of dates file
	 */
	private final String datesFile = "SortingDates.txt";
	/**
	 * Storage of parsed datesFile
	 */
	private HashMap<LocalDate, Integer> fileData;
	/**
	 * Constant for formatting dates in "yyyy-MM-dd" format.
	 */
	private DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	/**
	 * String space
	 */
	private String SPACE = " ";
	/**
	 * String blank
	 */
	private String BLANK = "";

	/**
	 * Constructor of DateTimeThree object
	 * 
	 * @param dates - used for DateTimeThree
	 */
	public DateSortingUsingAlgorithm(DateTimeThree dates) {
		this.dates = dates;
	}

	/**
	 * Reads in data from the file represented in String filename
	 * 
	 * @throws FileNotFoundException Because reads in dates file
	 */
	public DateSortingUsingAlgorithm() throws FileNotFoundException {
		this.fileData = readFile(datesFile);
	}

	/**
	 * Sorts dates based on output described in project description
	 */
	public void getSortedHashMap() {
		Map<LocalDate, Integer> treeMap = new TreeMap<LocalDate, Integer>(dates.getDates());

		for (LocalDate date : treeMap.keySet()) {
			System.out.println(date + ":" + dates.getDates().get(date));
		}
	}

	/**
	 * Reads datesFile and returns HashMap<LocalDate, Integer>
	 * 
	 * @param filename of the .txt file reading in
	 * @return Returns a HashMap<LocalDate, Integer> with LocalDates parsed from a
	 *         .txt file
	 * @throws FileNotFoundException
	 */
	public HashMap<LocalDate, Integer> readFile(String filename) throws FileNotFoundException {
		HashMap<LocalDate, Integer> data = new HashMap<LocalDate, Integer>();

		Scanner scnr = new Scanner(new File(filename));
		int i = 1;
		while (scnr.hasNextLine()) {
			String line = scnr.nextLine().trim().replaceAll(SPACE, BLANK);
			data.put(LocalDate.parse(line, DATE_FORMAT), i);
			++i;
		}

		return (data);
	}

	/**
	 * Prints sorted HashMap<LocalDate, Integer> to console in ascending order.
	 * 
	 * This method is faster than descending model because it increments, from
	 * element 0 to length. Since it is ASC, it does not have to go back and
	 * rearrange the array.
	 */
	public void dateHashMapSorted() {
		Object[] objArr = this.getFileData().keySet().toArray();
		LocalDate[] arr = new LocalDate[objArr.length];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = LocalDate.parse(objArr[i].toString(), DATE_FORMAT);
		}

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].isAfter(arr[j + 1])) {
					// swap arr[j+1] and arr[j]
					LocalDate temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (LocalDate date : arr) {
			System.out.println(date);
		}
	}

	/**
	 * Prints sorted HashMap<LocalDate, Integer> to console in descending order
	 */
	public void dateHashMapSortedDescending() {
		Object[] objArr = this.getFileData().keySet().toArray();
		LocalDate[] arr = new LocalDate[objArr.length];

		for (int i = 0; i < arr.length; ++i) {
			arr[i] = LocalDate.parse(objArr[i].toString(), DATE_FORMAT);
		}

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j].isBefore(arr[j + 1])) {
					// swap arr[j+1] and arr[j]
					LocalDate temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (LocalDate date : arr) {
			System.out.println(date);
		}
	}

	/**
	 * Getter for the file data parsed
	 * 
	 * @return Returns HashMap<LocalDate, Integer> with unsorted data from file
	 */
	public HashMap<LocalDate, Integer> getFileData() {
		return fileData;
	}
}
