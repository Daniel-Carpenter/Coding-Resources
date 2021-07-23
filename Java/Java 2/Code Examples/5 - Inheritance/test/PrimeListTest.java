import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PrimeListTest {

	@Test
	void testAdd() {
		IntegerList list = new PrimeList();
		assertEquals(0, list.size());
		
		assertFalse(list.add(-1));
		assertEquals(0, list.size());
		
		assertFalse(list.add(0));
		assertEquals(0, list.size());
		
		assertTrue(list.add(1));
		assertEquals(0, list.size());
		
		assertTrue(list.add(2));
		assertEquals(1, list.size());
		assertEquals(2, list.get(0));
		
		assertTrue(list.add(3));
		assertEquals(2, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		
		assertTrue(list.add(4));
		assertEquals(2, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		
		assertTrue(list.add(8));
		assertEquals(4, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
		assertEquals(7, list.get(3));
		
		assertFalse(list.add(7));
		assertEquals(4, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
		assertEquals(7, list.get(3));
		
		list = new PrimeList(6);
		assertEquals(3, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
		
		assertFalse(list.add(1));
		assertEquals(3, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
		
		assertTrue(list.add(20));
		assertEquals(8, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
		assertEquals(7, list.get(3));
		assertEquals(11, list.get(4));
		assertEquals(13, list.get(5));
		assertEquals(17, list.get(6));
		assertEquals(19, list.get(7));
		
		assertFalse(list.add(20));
		assertEquals(8, list.size());
		assertEquals(2, list.get(0));
		assertEquals(3, list.get(1));
		assertEquals(5, list.get(2));
		assertEquals(7, list.get(3));
		assertEquals(11, list.get(4));
		assertEquals(13, list.get(5));
		assertEquals(17, list.get(6));
		assertEquals(19, list.get(7));
	}
	
	@Test
	void testGetComposites() {
		PrimeList list = new PrimeList();
		assertEquals("[]", list.getComposites().toString());
		
		list.add(1);
		assertEquals("[]", list.getComposites().toString());
		
		list.add(2);
		assertEquals("[]", list.getComposites().toString());
		
		list.add(3);
		assertEquals("[]", list.getComposites().toString());
		
		list.add(4);
		assertEquals("[4]", list.getComposites().toString());
		
		list.add(7);
		assertEquals("[4, 6]", list.getComposites().toString());
		
		list.add(5);
		assertEquals("[4, 6]", list.getComposites().toString());
		
		list.add(17);
		assertEquals("[4, 6, 8, 9, 10, 12, 14, 15, 16]", 
				list.getComposites().toString());
		
		list.add(17);
		assertEquals("[4, 6, 8, 9, 10, 12, 14, 15, 16]", 
				list.getComposites().toString());
		
		list.add(28);
		assertEquals("[4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, "
				+ "26, 27, 28]", list.getComposites().toString());
	}
}
