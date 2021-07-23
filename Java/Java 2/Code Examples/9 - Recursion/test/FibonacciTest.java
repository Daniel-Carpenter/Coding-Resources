import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class FibonacciTest {

	@Test
	void testFibonacci() {
		assertThrows(IllegalArgumentException.class, 
				() -> Recursion.fibonacci(-1));
		assertThrows(IllegalArgumentException.class, 
				() -> Recursion.fibonacci(-2));
		
		assertEquals(0, Recursion.fibonacci(0));
		assertEquals(1, Recursion.fibonacci(1));
		assertEquals(1, Recursion.fibonacci(2));
		assertEquals(2, Recursion.fibonacci(3));
		assertEquals(3, Recursion.fibonacci(4));
		assertEquals(5, Recursion.fibonacci(5));
		assertEquals(8, Recursion.fibonacci(6));
		assertEquals(13, Recursion.fibonacci(7));
		assertEquals(21, Recursion.fibonacci(8));
		assertEquals(34, Recursion.fibonacci(9));
	}

	@Test
	void testMemoizedFibonacci() {
		int idx = 30;
		int fib = 832040;
		Map<Integer, Integer> cache = new HashMap<>();
		
		Instant start = Instant.now();
		assertEquals(fib, Recursion.fibonacci(idx));
		Instant stop = Instant.now();
		int nonMemoizeTime = Duration.between(start, stop).getNano();
		
		start = Instant.now();
		assertEquals(fib, Recursion.fibonacci(idx, cache));
		stop = Instant.now();
		int memoizeTime = Duration.between(start, stop).getNano();
		
		assertTrue(memoizeTime < nonMemoizeTime / 10);
		assertEquals(idx + 1, cache.size());
		for (int n = 0; n <= idx; ++n) {
			assertTrue(cache.containsKey(n));
		}
		
		idx = 35;
		fib = 9227465;
		cache.clear();

		start = Instant.now();
		assertEquals(fib, Recursion.fibonacci(idx));
		stop = Instant.now();
		nonMemoizeTime = Duration.between(start, stop).getNano();
		
		start = Instant.now();
		assertEquals(fib, Recursion.fibonacci(idx, cache));
		stop = Instant.now();
		memoizeTime = Duration.between(start, stop).getNano();
		
		assertTrue(memoizeTime < nonMemoizeTime / 10);
		assertEquals(idx + 1, cache.size());
		for (int n = 0; n <= idx; ++n) {
			assertTrue(cache.containsKey(n));
		}
	}
}
