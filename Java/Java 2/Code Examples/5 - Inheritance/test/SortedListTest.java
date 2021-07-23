import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SortedListTest {

	@Test
	void testAdd() {
		IntegerList list = new SortedList();
		assertEquals(0, list.size());
		
		assertTrue(list.add(7));
		assertEquals(1, list.size());
		assertEquals(7, list.get(0));
		
		assertTrue(list.add(4));
		assertEquals(2, list.size());
		assertEquals(4, list.get(0));
		assertEquals(7, list.get(1));
		
		assertTrue(list.add(9));
		assertEquals(3, list.size());
		assertEquals(4, list.get(0));
		assertEquals(7, list.get(1));
		assertEquals(9, list.get(2));
		
		assertTrue(list.add(5));
		assertEquals(4, list.size());
		assertEquals(4, list.get(0));
		assertEquals(5, list.get(1));
		assertEquals(7, list.get(2));
		assertEquals(9, list.get(3));
		
		assertTrue(list.add(8));
		assertEquals(5, list.size());
		assertEquals(4, list.get(0));
		assertEquals(5, list.get(1));
		assertEquals(7, list.get(2));
		assertEquals(8, list.get(3));
		assertEquals(9, list.get(4));
		
		assertTrue(list.add(6));
		assertEquals(6, list.size());
		assertEquals(4, list.get(0));
		assertEquals(5, list.get(1));
		assertEquals(6, list.get(2));
		assertEquals(7, list.get(3));
		assertEquals(8, list.get(4));
		assertEquals(9, list.get(5));
		
		assertTrue(list.add(7));
		assertEquals(7, list.size());
		assertEquals(4, list.get(0));
		assertEquals(5, list.get(1));
		assertEquals(6, list.get(2));
		assertEquals(7, list.get(3));
		assertEquals(7, list.get(4));
		assertEquals(8, list.get(5));
		assertEquals(9, list.get(6));
	}
	
	@Test
	void testRemove() {
		SortedList list = new SortedList();
		list.add(-7);
		list.add(-4);
		list.add(-9);
		list.add(-5);
		list.add(-8);
		list.add(-6);
		list.add(-7);
		
		assertTrue(list.remove(-4));
		assertEquals(6, list.size());
		assertEquals(-9, list.get(0));
		assertEquals(-8, list.get(1));
		assertEquals(-7, list.get(2));
		assertEquals(-7, list.get(3));
		assertEquals(-6, list.get(4));
		assertEquals(-5, list.get(5));
		
		assertTrue(list.remove(-9));
		assertEquals(5, list.size());
		assertEquals(-8, list.get(0));
		assertEquals(-7, list.get(1));
		assertEquals(-7, list.get(2));
		assertEquals(-6, list.get(3));
		assertEquals(-5, list.get(4));
		
		assertTrue(list.remove(-6));
		assertEquals(4, list.size());
		assertEquals(-8, list.get(0));
		assertEquals(-7, list.get(1));
		assertEquals(-7, list.get(2));
		assertEquals(-5, list.get(3));
		
		assertTrue(list.remove(-7));
		assertEquals(3, list.size());
		assertEquals(-8, list.get(0));
		assertEquals(-7, list.get(1));
		assertEquals(-5, list.get(2));
		
		assertTrue(list.remove(-7));
		assertEquals(2, list.size());
		assertEquals(-8, list.get(0));
		assertEquals(-5, list.get(1));
		
		assertFalse(list.remove(-7));
		assertEquals(2, list.size());
		assertEquals(-8, list.get(0));
		assertEquals(-5, list.get(1));
		
		assertTrue(list.remove(-5));
		assertEquals(1, list.size());
		assertEquals(-8, list.get(0));
		
		assertTrue(list.remove(-8));
		assertEquals(0, list.size());
		
		assertFalse(list.remove(42));
		assertEquals(0, list.size());
	}
}
