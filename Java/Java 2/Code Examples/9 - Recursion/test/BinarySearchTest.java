import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

	@Test
	void testBaseCases() {
		List<String> words = Arrays.asList(
				new String[] {"a", "b", "c", "d", "e"});
		List<Integer> indices = Arrays.asList(new Integer[] {-1});
		
		// Base case 1: target not found
		assertEquals(indices, Recursion.binarySearch(words, "", 0, -1));
		assertEquals(indices, Recursion.binarySearch(words, "", 1, 0));
		assertEquals(indices, Recursion.binarySearch(words, "", 2, 1));
		assertEquals(indices, Recursion.binarySearch(words, "", 3, 2));
		assertEquals(indices, Recursion.binarySearch(words, "", 4, 3));
		assertEquals(indices, Recursion.binarySearch(words, "", 5, 4));
		assertEquals(indices, Recursion.binarySearch(words, "", 7, -7));
		
		// Base case 2: target found
		indices = Arrays.asList(new Integer[] {0});
		assertEquals(indices, Recursion.binarySearch(words, "a", 0, 0));
		assertEquals(indices, Recursion.binarySearch(words, "a", 0, 1));
		indices = Arrays.asList(new Integer[] {1});
		assertEquals(indices, Recursion.binarySearch(words, "b", 1, 1));
		assertEquals(indices, Recursion.binarySearch(words, "b", 1, 2));
		assertEquals(indices, Recursion.binarySearch(words, "b", 0, 2));
		assertEquals(indices, Recursion.binarySearch(words, "b", 0, 3));
		indices = Arrays.asList(new Integer[] {2});
		assertEquals(indices, Recursion.binarySearch(words, "c", 2, 2));
		assertEquals(indices, Recursion.binarySearch(words, "c", 2, 3));
		assertEquals(indices, Recursion.binarySearch(words, "c", 1, 3));
		assertEquals(indices, Recursion.binarySearch(words, "c", 1, 4));
		assertEquals(indices, Recursion.binarySearch(words, "c", 0, 4));
		indices = Arrays.asList(new Integer[] {3});
		assertEquals(indices, Recursion.binarySearch(words, "d", 3, 3));
		assertEquals(indices, Recursion.binarySearch(words, "d", 3, 4));
		assertEquals(indices, Recursion.binarySearch(words, "d", 2, 4));
		indices = Arrays.asList(new Integer[] {4});
		assertEquals(indices, Recursion.binarySearch(words, "e", 4, 4));
	}

	@Test
	void testRecursiveCase() {
		List<String> words = Arrays.asList(new String[] {"b"});
		List<Integer> indices;
		
		indices = Arrays.asList(new Integer[] {0, -1});
		assertEquals(indices, Recursion.binarySearch(words, "a", 0, 0));
		indices = Arrays.asList(new Integer[] {0});
		assertEquals(indices, Recursion.binarySearch(words, "b", 0, 0));
		indices = Arrays.asList(new Integer[] {0, -1});
		assertEquals(indices, Recursion.binarySearch(words, "c", 0, 0));
		
		words = Arrays.asList(new String[] {"b", "d"});
		
		indices = Arrays.asList(new Integer[] {0, -1});
		assertEquals(indices, Recursion.binarySearch(words, "a", 0, 1));
		indices = Arrays.asList(new Integer[] {0});
		assertEquals(indices, Recursion.binarySearch(words, "b", 0, 1));
		indices = Arrays.asList(new Integer[] {0, 1, -1});
		assertEquals(indices, Recursion.binarySearch(words, "c", 0, 1));
		indices = Arrays.asList(new Integer[] {0, 1});
		assertEquals(indices, Recursion.binarySearch(words, "d", 0, 1));
		indices = Arrays.asList(new Integer[] {0, 1, -1});
		assertEquals(indices, Recursion.binarySearch(words, "e", 0, 1));
		
		words = Arrays.asList(new String[] {"b", "d", "f", "h", "j", "l", "n"});
		
		indices = Arrays.asList(new Integer[] {3, 1, 0, -1});
		assertEquals(indices, Recursion.binarySearch(words, "a", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 1, 0});
		assertEquals(indices, Recursion.binarySearch(words, "b", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 1, 0, -1});
		assertEquals(indices, Recursion.binarySearch(words, "c", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 1});
		assertEquals(indices, Recursion.binarySearch(words, "d", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 1, 2, -1});
		assertEquals(indices, Recursion.binarySearch(words, "e", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 1, 2});
		assertEquals(indices, Recursion.binarySearch(words, "f", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 1, 2, -1});
		assertEquals(indices, Recursion.binarySearch(words, "g", 0, 6));
		indices = Arrays.asList(new Integer[] {3});
		assertEquals(indices, Recursion.binarySearch(words, "h", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5, 4, -1});
		assertEquals(indices, Recursion.binarySearch(words, "i", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5, 4});
		assertEquals(indices, Recursion.binarySearch(words, "j", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5, 4, -1});
		assertEquals(indices, Recursion.binarySearch(words, "k", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5});
		assertEquals(indices, Recursion.binarySearch(words, "l", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5, 6, -1});
		assertEquals(indices, Recursion.binarySearch(words, "m", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5, 6});
		assertEquals(indices, Recursion.binarySearch(words, "n", 0, 6));
		indices = Arrays.asList(new Integer[] {3, 5, 6, -1});
		assertEquals(indices, Recursion.binarySearch(words, "o", 0, 6));
	}
}
