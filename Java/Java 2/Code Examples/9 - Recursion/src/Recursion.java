import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Recursion {

	private static final Integer NOT_FOUND = -1;

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
	
	/**
	 * Returns the nth term in the Fibonacci sequence using a map to memoize 
	 * the method. If the term is stored in the map, its value is returned. 
	 * Otherwise, the term is calculated and added to the map before returning 
	 * it.
	 * 
	 * @param n the term index
	 * @param cache the map used to memoize the method
	 * @return the nth Fibonacci number
	 * @throws IllegalArgumentException if n is less than 0
	 */
	public static int fibonacci(int n, Map<Integer, Integer> cache) {
		
		// Edge Case for values less that 0
			if (n < 0) {
				throw new IllegalArgumentException();
			}
		
		// Base Case for 1 and 0
			if (n == 0) {
				cache.put(0, 0);
				return cache.get(n);
			}
			if (n == 1) {
				cache.put(1, 1);
				return cache.get(n);
			}
		
		// Recursive Case
			// If it contains it already, then access the current cache
			if (cache.containsKey(n)) {
				return cache.get(n);
			}
			// calculate the fib number
			int result = fibonacci(n - 1, cache) + fibonacci(n - 2, cache);
			cache.put(n, result);
			return result;
	}
	
	/**
	 * Searches a sorted list of strings using binary search. Returns a list of 
	 * the indices of the strings checked during the search in the order they 
	 * are checked. If the target string is not found, the last element of the 
	 * returned list is -1. Otherwise, the last element is the index of the 
	 * target.
	 * 
	 * @param words the list to be searched
	 * @param target the string to be searched for
	 * @param fromIdx the index of the first string in the range of strings to 
	 *        be searched (inclusive)
	 * @param toIdx the index of the last string in the range of strings to be 
	 *        searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         The last element is -1 if the target is not found.
	 */
	public static List<Integer> binarySearch(
											List<String> words, 
											String target, 
											int fromIdx, 
											int toIdx) 
	{
		// Base Case
		int midIdx = (fromIdx + toIdx) / 2;

		if (fromIdx > toIdx)
		{
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(NOT_FOUND);
			return list;
		}
		if (words.get(midIdx).equals(target)) 
		{
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(midIdx);
			return list;
		} 
		
		// Recursive Case
		else if (words.get(midIdx).compareTo(target) > 0) 
		{
			int newToIdx = midIdx - 1;
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(midIdx);
			list.addAll(binarySearch(words, target, fromIdx, newToIdx));
			return list;
		}
		else 
		{
			int newFromIdx = midIdx + 1;
			LinkedList<Integer> list = new LinkedList<Integer>();
			list.add(midIdx);
			list.addAll(binarySearch(words, target, newFromIdx, toIdx));
			return list;
			
		}
		
		
	}
	
	/**
	 * Returns a list of moves that solve the Tower of Hanoi puzzle. The method 
	 * assumes that the disks are initially on the given start peg and that the 
	 * puzzle is solved by moving them to the given end peg.
	 * 
	 * @param numDisks the number of disks in the puzzle
	 * @param start the start peg
	 * @param end the end peg
	 * @return a list of legal moves that transfers the disks from the start 
	 *         peg to the end peg
	 * @throws IllegalArgumentException if numDisks is less than or equal to 0
	 */
	public static List<Move> solveTower(int numDisks, Peg start, Peg end) {
		
		LinkedList<Move> moves = new LinkedList<Move>();
		
		// Edge Case -----------------------------------------------------------
		
			// Disks must be greater than 0
			if (numDisks <= 0) {
				throw new IllegalArgumentException();
			}
			
			// if start equals end, then finished
			if (start == end) {
				return moves;
			}
			
		// Base Case -----------------------------------------------------------
			
			// Single solution if only one disk
			if (numDisks == 1) {
				
				// If only 1 disk, then move from start to end
				moves.add(Move.getMove(start, end));
				return moves;
			}
			
		// Recursive Case ------------------------------------------------------

			// store moves and move to the non-start/mid peg; then add to list
			moves = (LinkedList<Move>) solveTower(numDisks - 1, start, Peg.getOtherPeg(start, end));
			moves.add(Move.getMove(start, end));
	
			// add last move to the list
			moves.addAll(solveTower(numDisks - 1, Peg.getOtherPeg(start, end), end));

		return moves;
	}
	
	/**
	 * Returns a sorted list of all the unique sums that can be calculated from 
	 * subsets of the integers in a given list.
	 * 
	 * @param numbers the list of integers
	 * @return the sorted list of unique sums
	 */
	public static List<Integer> subsetSums(List<Integer> numbers) {
		
		// Base Case
		if (numbers.isEmpty())  {
			return (List<Integer>) Arrays.asList(new Integer[] {0});
		}
		
		// Recursive Case
		
		return null;
	}
}
