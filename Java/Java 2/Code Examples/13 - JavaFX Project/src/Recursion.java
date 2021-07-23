import java.util.Map;

/**
 * Class to determine the nth term of the Fibonacci sequence
 * 
 * @author Daniel Carpenter
 * @version 4.19
 */
public class Recursion {
	
	/**
	 * Returns the nth term in the Fibonacci sequence.
	 * 
	 * @param n the term index
	 * @return the nth Fibonacci number
	 * @throws IllegalArgumentException if n is less than 0
	 */
	public static int fibonacci(int n) {
		
		// Edge Case for values less that 0
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		
		// Base Case for 1 and 0
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		
		// Recursive Case
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
