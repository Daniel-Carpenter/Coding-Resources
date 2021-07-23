import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Lab1Test {

	@Test
	void testSum() {
		assertEquals(Lab1.sum(2, 2), 4);
		assertEquals(Lab1.sum(3, 5), 8);
		assertEquals(Lab1.sum(7, -10), -3);
	}

	@Test
	void testCastToInt() {
		assertEquals(Lab1.castToInt(1.2345), 1);
		assertEquals(Lab1.castToInt(2.9999), 2);
		assertEquals(Lab1.castToInt(-6.789), -6);
		assertEquals(Lab1.castToInt(0.0001), 0);
	}

	@Test
	void testEmphasize() {
		assertEquals(Lab1.emphasize("wow"), "***wow***");
		assertEquals(Lab1.emphasize("amazing"), "***amazing***");
		assertEquals(Lab1.emphasize("I heart Java!"), "***I heart Java!***");
	}

	@Test
	void testIsOdd() {
		assertTrue(Lab1.isOdd(1));
		assertFalse(Lab1.isOdd(2));
		assertTrue(Lab1.isOdd(5));
		assertFalse(Lab1.isOdd(10));
		assertTrue(Lab1.isOdd(-1));
	}
	
	@Test
	void testFindMax() {
		assertEquals(Lab1.findMax(1, 2, 3), 3);
		assertEquals(Lab1.findMax(3, 1, 2), 3);
		assertEquals(Lab1.findMax(2, 3, 1), 3);
		assertEquals(Lab1.findMax(-7, 42, 18), 42);
	}
	
	@Test
	void testSumArray() {
		int[] array = {1};
		assertEquals(Lab1.sum(array), 1);
		
		array = new int[] {1, 2};
		assertEquals(Lab1.sum(array), 3);
		
		array = new int[] {1, 2, 3};
		assertEquals(Lab1.sum(array), 6);
		
		array = new int[] {};
		assertEquals(Lab1.sum(array), 0);
	}

	@Test
	void testSumOdd() {
		int[] array = {1};
		assertEquals(Lab1.sumOdd(array), 1);

		array = new int[] {1, 2};
		assertEquals(Lab1.sumOdd(array), 1);

		array = new int[] {1, 2, 3};
		assertEquals(Lab1.sumOdd(array), 4);

		array = new int[] {};
		assertEquals(Lab1.sumOdd(array), 0);
	}
	
	@Test
	void testFindMaxArray() {
		int[] array = {1, 2, 3};
		assertEquals(Lab1.findMax(array), 3);
		
		array = new int[] {3, 2, 1};
		assertEquals(Lab1.findMax(array), 3);
		
		array = new int[] {7};
		assertEquals(Lab1.findMax(array), 7);
		
		array = new int[] {2, -1, 5, 1, 9, 2, 4};
		assertEquals(Lab1.findMax(array), 9);
	}
}
