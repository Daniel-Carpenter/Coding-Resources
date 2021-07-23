import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class SubsetSumsTest {

	@Test
	void testBaseCase() {
		List<Integer> numbers = Arrays.asList(new Integer[] {});
		List<Integer> sums = Arrays.asList(new Integer[] {0});
		assertEquals(sums, Recursion.subsetSums(numbers));
	}
	
	@Test
	void testRecursiveCase() {
		List<Integer> numbers = Arrays.asList(new Integer[] {0});
		List<Integer> sums = Arrays.asList(new Integer[] {0});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {1});
		sums = Arrays.asList(new Integer[] {0, 1});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {1, 1});
		sums = Arrays.asList(new Integer[] {0, 1, 2});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {1, 2});
		sums = Arrays.asList(new Integer[] {0, 1, 2, 3});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {2, 1});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {42, 451});
		sums = Arrays.asList(new Integer[] {0, 42, 451, 493});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {451, 42});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {0, 451, 0, 42, 0});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {-1, -1, 1, 1});
		sums = Arrays.asList(new Integer[] {-2, -1, 0, 1, 2});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {1, 1, -1, -1});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {-1, 1, -1, 1});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {1, 2, 3});
		sums = Arrays.asList(new Integer[] {0, 1, 2, 3, 4, 5, 6});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {2, 1, 3});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {3, 1, 2});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {3, 5, 7});
		sums = Arrays.asList(new Integer[] {0, 3, 5, 7, 8, 10, 12, 15});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {5, 7, 3});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {7, 5, 3});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {1, 3, 3, 7});
		sums = Arrays.asList(
				new Integer[] {0, 1, 3, 4, 6, 7, 8, 10, 11, 13, 14});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {3, 7, 1, 3});
		assertEquals(sums, Recursion.subsetSums(numbers));
		
		numbers = Arrays.asList(new Integer[] {3, 5, 7, 11});
		sums = Arrays.asList(new Integer[] {0, 3, 5, 7, 8, 10, 11, 12, 14, 15, 
				16, 18, 19, 21, 23, 26});
		assertEquals(sums, Recursion.subsetSums(numbers));
		numbers = Arrays.asList(new Integer[] {5, 3, 11, 7});
		assertEquals(sums, Recursion.subsetSums(numbers));
	}
}
