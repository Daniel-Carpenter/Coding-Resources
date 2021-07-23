import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Takes in the numeric values of a month and year and creates a LocalDate
 * object, and then formats the date as a weekday, like "Friday"
 * 
 * @author Daniel Carpenter
 * @version 2.21
 */
public class DateTimeInherit extends DateTimeAbstract {
	/**
	 * Formatter constant that holds the format of "EEEE", or weekday name
	 */
	private DateTimeFormatter WKDAY_FORMAT = DateTimeFormatter.ofPattern("EEEE");

	/**
	 * Constant to add to the date occurring on the end of a month to calculate the
	 * first of the month endOfMonth - 1 month + 1 day = begOfMonth, so 1 below
	 */
	private int ADD_1_TO_LAST_EOMONTH = 1; // 1 day

	/**
	 * Calculates the first day of a given month within a specific year and formats
	 * as a weekday, e.g. "Friday"
	 * 
	 * @param monthOfYear int value representing the numeric month number of a date,
	 *                    e.g. 1 = January
	 * @param theYear     int value representing the numeric year number of a date,
	 *                    e.g. 2020
	 */
	public void daysOfAnyMonth(int monthOfYear, int theYear) {
		// Month prior to Inputted Month (for begOfMonth Calc)
		int lastMonthOfYear = monthOfYear - 1;

		// END OF MONTH
		// ------------------------------------------------------------------------

		// Beginning of the Month from month and year for FIRST day (name of weekday) of
		// month/year
		LocalDate begOfMonth = YearMonth.of(theYear, lastMonthOfYear).atEndOfMonth().plusDays(ADD_1_TO_LAST_EOMONTH);

		// Format as Weekday Name to Uppercase
		String firstDayOfMonth = WKDAY_FORMAT.format(begOfMonth).toUpperCase();

		// END OF MONTH--------------------------------------------------------

		// End of the Month from month and year for FIRST day (name of weekday) of
		// month/year
		LocalDate endOfMonth = YearMonth.of(theYear, monthOfYear).atEndOfMonth();

		// Format as Weekday Name to Uppercase
		String lastDayOfMonth = WKDAY_FORMAT.format(endOfMonth).toUpperCase();

		// Print output of first and last day from input in WEEKDAY ("EEEE") format
		// ------------
		System.out.println("In the year " + theYear + ", for the " + monthOfYear + "th month: " + "the first day is "
				+ firstDayOfMonth + " and the last day is " + lastDayOfMonth);
	}
}