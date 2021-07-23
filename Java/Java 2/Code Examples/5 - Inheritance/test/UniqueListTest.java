import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class UniqueListTest {

	@Test
	void testAdd() {
		IntegerList list = new UniqueList();
		assertEquals(0, list.size());
		
		assertTrue(list.add(7));
		assertEquals(1, list.size());
		assertEquals(7, list.get(0));
		
		assertTrue(list.add(4));
		assertEquals(2, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		
		assertTrue(list.add(9));
		assertEquals(3, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(9, list.get(2));
		
		assertFalse(list.add(7));
		assertEquals(3, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(9, list.get(2));
		
		assertFalse(list.add(4));
		assertEquals(3, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(9, list.get(2));
		
		assertTrue(list.add(5));
		assertEquals(4, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(9, list.get(2));
		assertEquals(5, list.get(3));
		
		assertFalse(list.add(9));
		assertEquals(4, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(9, list.get(2));
		assertEquals(5, list.get(3));
		
		assertFalse(list.add(5));
		assertEquals(4, list.size());
		assertEquals(7, list.get(0));
		assertEquals(4, list.get(1));
		assertEquals(9, list.get(2));
		assertEquals(5, list.get(3));
	}

	@Test
	void testRemove() {
		UniqueList list = new UniqueList();
		list.add(-7);
		list.add(-4);
		list.add(-9);
		list.add(-5);
		
		assertTrue(list.remove());
		assertEquals(3, list.size());
		assertEquals(-7, list.get(0));
		assertEquals(-4, list.get(1));
		assertEquals(-9, list.get(2));
		
		assertTrue(list.remove());
		assertEquals(2, list.size());
		assertEquals(-7, list.get(0));
		assertEquals(-4, list.get(1));
		
		assertTrue(list.remove());
		assertEquals(1, list.size());
		assertEquals(-7, list.get(0));
		
		assertTrue(list.remove());
		assertEquals(0, list.size());
		
		assertFalse(list.remove());
		assertEquals(0, list.size());
				
		list.add(-8);
		list.add(-6);
		list.add(-7);
		assertTrue(list.remove());
		assertEquals(2, list.size());
		assertEquals(-8, list.get(0));
		assertEquals(-6, list.get(1));
		
		assertTrue(list.remove());
		assertEquals(1, list.size());
		assertEquals(-8, list.get(0));
		
		assertTrue(list.remove());
		assertEquals(0, list.size());
		
		assertFalse(list.remove());
		assertEquals(0, list.size());
	}
}
