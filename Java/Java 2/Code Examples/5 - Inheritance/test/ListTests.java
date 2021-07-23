import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ListTests {

	@Test
	void testInheritance() {
		IntegerList list = new SortedList();
		assertTrue(list instanceof SortedList);
		assertTrue(list instanceof IntegerList);
		
		list = new SortedList(10);
		assertTrue(list instanceof SortedList);
		assertTrue(list instanceof IntegerList);
		
		list = new UniqueList();
		assertTrue(list instanceof UniqueList);
		assertTrue(list instanceof IntegerList);
		
		list = new UniqueList(10);
		assertTrue(list instanceof UniqueList);
		assertTrue(list instanceof IntegerList);
		
		list = new PrimeList();
		assertTrue(list instanceof PrimeList);
		assertTrue(list instanceof IntegerList);
		
		list = new PrimeList(10);
		assertTrue(list instanceof PrimeList);
		assertTrue(list instanceof IntegerList);
	}
	
	@Test
	void testToString() {
		IntegerList sorted = new SortedList();
		IntegerList unique = new UniqueList();
		IntegerList prime = new PrimeList();
		
		assertEquals("[]", sorted.toString());
		assertEquals("[]", unique.toString());
		assertEquals("[]", prime.toString());
		
		sorted.add(5);
		unique.add(5);
		prime.add(5);
		assertEquals("[5]", sorted.toString());
		assertEquals("[5]", unique.toString());
		assertEquals("[2, 3, 5]", prime.toString());
		
		sorted.add(3);
		unique.add(3);
		prime.add(3);
		assertEquals("[3, 5]", sorted.toString());
		assertEquals("[5, 3]", unique.toString());
		assertEquals("[2, 3, 5]", prime.toString());
		
		sorted.add(4);
		unique.add(4);
		prime.add(4);
		assertEquals("[3, 4, 5]", sorted.toString());
		assertEquals("[5, 3, 4]", unique.toString());
		assertEquals("[2, 3, 5]", prime.toString());
		
		sorted.add(9);
		unique.add(9);
		prime.add(9);
		assertEquals("[3, 4, 5, 9]", sorted.toString());
		assertEquals("[5, 3, 4, 9]", unique.toString());
		assertEquals("[2, 3, 5, 7]", prime.toString());
		
		sorted.add(13);
		unique.add(13);
		prime.add(13);
		assertEquals("[3, 4, 5, 9, 13]", sorted.toString());
		assertEquals("[5, 3, 4, 9, 13]", unique.toString());
		assertEquals("[2, 3, 5, 7, 11, 13]", prime.toString());
	}
	
	@Test
	void testContains() {
		IntegerList sorted = new SortedList();
		IntegerList unique = new UniqueList();
		IntegerList prime = new PrimeList();
		
		assertFalse(sorted.contains(5));
		assertFalse(unique.contains(5));
		assertFalse(prime.contains(5));
		
		sorted.add(5);
		unique.add(5);
		prime.add(5);
		assertTrue(sorted.contains(5));
		assertTrue(unique.contains(5));
		assertTrue(prime.contains(5));
		
		assertFalse(sorted.contains(2));
		assertFalse(unique.contains(2));
		assertTrue(prime.contains(2));
		
		assertFalse(sorted.contains(3));
		assertFalse(unique.contains(3));
		assertTrue(prime.contains(3));
		
		sorted.add(8);
		unique.add(8);
		prime.add(8);
		assertTrue(sorted.contains(8));
		assertTrue(unique.contains(8));
		assertFalse(prime.contains(8));
		
		assertFalse(sorted.contains(7));
		assertFalse(unique.contains(7));
		assertTrue(prime.contains(7));
		
		sorted.add(11);
		unique.add(11);
		prime.add(11);
		assertTrue(sorted.contains(11));
		assertTrue(unique.contains(11));
		assertTrue(prime.contains(11));
	}
	
	@Test
	void testEquals() {
		IntegerList sorted = new SortedList();
		IntegerList unique = new UniqueList();
		IntegerList prime = new PrimeList();
		
		assertTrue(sorted.equals(unique));
		assertTrue(unique.equals(sorted));
		assertTrue(unique.equals(prime));
		assertTrue(prime.equals(unique));
		assertTrue(prime.equals(sorted));
		assertTrue(sorted.equals(prime));
		
		sorted.add(3);
		unique.add(3);
		prime.add(3);
		assertTrue(sorted.equals(unique));
		assertTrue(unique.equals(sorted));
		assertFalse(unique.equals(prime));
		assertFalse(prime.equals(unique));
		assertFalse(prime.equals(sorted));
		assertFalse(sorted.equals(prime));
		
		sorted.add(2);
		unique.add(2);
		assertFalse(sorted.equals(unique));
		assertFalse(unique.equals(sorted));
		assertFalse(unique.equals(prime));
		assertFalse(prime.equals(unique));
		assertTrue(prime.equals(sorted));
		assertTrue(sorted.equals(prime));
		
		((UniqueList) unique).remove();
		((UniqueList) unique).remove();
		assertFalse(sorted.equals(unique));
		assertFalse(unique.equals(sorted));
		assertFalse(unique.equals(prime));
		assertFalse(prime.equals(unique));
		assertTrue(prime.equals(sorted));
		assertTrue(sorted.equals(prime));
		
		unique.add(2);
		unique.add(3);
		assertTrue(sorted.equals(unique));
		assertTrue(unique.equals(sorted));
		assertTrue(unique.equals(prime));
		assertTrue(prime.equals(unique));
		assertTrue(prime.equals(sorted));
		assertTrue(sorted.equals(prime));
		
		assertTrue(sorted.equals(sorted));
		assertTrue(unique.equals(unique));
		assertTrue(prime.equals(prime));
	}
}
