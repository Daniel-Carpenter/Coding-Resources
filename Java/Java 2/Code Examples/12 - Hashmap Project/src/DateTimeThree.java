import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

/**
 * Reads file of unformatted dates and parsed LocalDates, then performs useful
 * calculations and storage procedures.
 * 
 * @author Daniel Carpenter
 * @version 3.15
 */
public class DateTimeThree {
	/**
	 * HashMap<LocalDate, Integer> that stores dates from file read
	 */
	private HashMap<LocalDate, Integer> dates = new HashMap<LocalDate, Integer>();
	/**
	 * Constant that helps parse dates from file
	 */
	private String DATE_DILIMETER = "\\.";
	/**
	 * Name of the file to read in constructor
	 */
	private String filename = "Dates.txt";
	/**
	 * ArrayList<String> that stores the String output for leap years and
	 * differences in dates
	 */
	private ArrayList<String> compareToStr = new ArrayList<String>();
	/**
	 * Index of array for month
	 */
	private final int MONTH_IDX = 0;
	/**
	 * Index of array for day
	 */
	private final int DAY_IDX = 1;
	/**
	 * Index of array for year
	 */
	private final int YEAR_IDX = 2;

	/**
	 * Constructor for DateTimeThree Object. Reads in Dates.txt file
	 * 
	 * @throws IOException
	 */
	public DateTimeThree() throws IOException {
		// read in data.txt
		readFile(filename);
	}

	/**
	 * Reads in file and puts it in a HashMap
	 * 
	 * @param filename Name of the file reading in
	 * @throws IOException
	 */
	public void readFile(String filename) throws IOException {
		// Create reader
		Scanner scnr = new Scanner(new File(filename));

		// Keep track of iterations
		int iterCount = 1;

		// Read lines until meets last line of .txt file (null)
		while (scnr.hasNextLine()) {

			// Read line
			String line = scnr.nextLine();

			// Parse date parts from string line
			String[] datePartsStr = line.split(DATE_DILIMETER);

			// Put date parts into int array (from string)
			int[] datePartsInt = new int[datePartsStr.length];
			int i = 0;

			for (String part : datePartsStr) {
				datePartsInt[i] = Integer.parseInt(part);
				++i;
			}

			// Create date from parts
			LocalDate date = LocalDate.of(datePartsInt[YEAR_IDX], datePartsInt[MONTH_IDX], datePartsInt[DAY_IDX]);

			// add is leap year or not String to arraylist
			String leapYearStr = "";
			int year = datePartsInt[YEAR_IDX];

			if (date.isLeapYear()) {
				leapYearStr = " is ";
			} else {
				leapYearStr = " is not ";
			}

			int yearDiff = dateDifference(date).getYears();
			int monthDiff = dateDifference(date).getMonths();
			int dayDiff = dateDifference(date).getDays();

			compareToStr.add(year + leapYearStr + "a leap year, and Difference: " + yearDiff + " years, " + monthDiff
					+ " months, and " + dayDiff + " days.");

			// Add Date to HashMap dates
			dates.put(date, iterCount);

			// Increment Iterations
			++iterCount;
		}

		// Close Reader
		scnr.close();
	}

	/**
	 * Prints local dates HashMap<LocalDate, Integer> to console
	 */
	public void dateHashMap() {
		for (LocalDate date : getDates().keySet()) {
			String key = date.toString();
			String value = getDates().get(date).toString();

			System.out.println(key + ":" + value);
		}
	}

	/**
	 * Uses DateSortingUsingAlgorithm.java to sort by date
	 */
	public void dateHashMapSorted() {
		DateSortingUsingAlgorithm alg = new DateSortingUsingAlgorithm(this);
		alg.getSortedHashMap();
	}

	/**
	 * Getter that returns dates from local HashMap<LocalDate, Integer>
	 * 
	 * @return Returns dates from local HashMap<LocalDate, Integer>
	 */
	public HashMap<LocalDate, Integer> getDates() {
		return dates;
	}

	/**
	 * Prints each element of the ArrayList<String> that holds dateDifference()
	 * output to console
	 */
	public void compareYear() {
		for (String element : this.compareToStr) {
			System.out.println(element);
		}
	}

	/**
	 * Calculates the difference from two LocalDate objects
	 * 
	 * @param date LocalDate object
	 * @return Returns the the difference from two LocalDate objects via
	 *         LocalDateTime objects
	 */
	public Period dateDifference(LocalDate date) {
		LocalDateTime currDate = LocalDateTime.now();

		Period diff = date.until(currDate.toLocalDate());
		return diff;

	}
}
