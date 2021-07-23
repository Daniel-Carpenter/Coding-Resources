import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PilesTest {

	@Test
	void testConstructor() throws InvalidInitPilesException {
		int[] initSizes = {1};
		Piles piles = new Piles(initSizes);
		assertArrayEquals(initSizes, piles.getSizes());
		
		initSizes = new int[] {1, 2};
		piles = new Piles(initSizes);
		assertArrayEquals(initSizes, piles.getSizes());
		
		initSizes = new int[] {3, 4, 5};
		piles = new Piles(initSizes);
		assertArrayEquals(initSizes, piles.getSizes());
		
		initSizes = new int[] {1, 3, 5, 7};
		piles = new Piles(initSizes);
		assertArrayEquals(initSizes, piles.getSizes());
		
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(null));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {-1}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {0}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {1, 0}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {1, -2}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {0, 4, 5}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {3, 0, 5}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {3, 4, 0}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {1, -3, 5, 7}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {1, 3, -5, 7}));
		assertThrows(InvalidInitPilesException.class, 
				() -> new Piles(new int[] {-1, 3, 5, -7}));
	}
	
	@Test
	void testEncapsulation() throws InvalidInitPilesException {
		int size = 5;
		int[] initSizes = {size};
		Piles piles = new Piles(initSizes);
		
		initSizes[0] = -1234567;
		assertEquals(size, piles.getSizes()[0]);
		
		int[] returnedSizes = piles.getSizes();
		returnedSizes[0] = -1234567;
		assertEquals(size, piles.getSizes()[0]);
	}

	@Test
	void testLegalMoves() throws InvalidInitPilesException, 
	IllegalMoveException {
		Piles piles = new Piles(new int[] {3, 4, 5});
		assertArrayEquals(new int[] {3, 4, 5}, piles.getSizes());
		
		piles.removeObjects(new int[] {0, 1});
		assertArrayEquals(new int[] {2, 4, 5}, piles.getSizes());
		piles.removeObjects(new int[] {2, 5});
		assertArrayEquals(new int[] {2, 4, 0}, piles.getSizes());
		piles.removeObjects(new int[] {1, 3});
		assertArrayEquals(new int[] {2, 1, 0}, piles.getSizes());
		piles.removeObjects(new int[] {0, 2});
		assertArrayEquals(new int[] {0, 1, 0}, piles.getSizes());
		piles.removeObjects(new int[] {1, 1});
		assertArrayEquals(new int[] {0, 0, 0}, piles.getSizes());
		
		piles = new Piles(new int[] {7, 3, 5, 1});
		assertArrayEquals(new int[] {7, 3, 5, 1}, piles.getSizes());
		
		piles.removeObjects(new int[] {2, 3});
		assertArrayEquals(new int[] {7, 3, 2, 1}, piles.getSizes());
		piles.removeObjects(new int[] {0, 7});
		assertArrayEquals(new int[] {0, 3, 2, 1}, piles.getSizes());
		piles.removeObjects(new int[] {2, 2});
		assertArrayEquals(new int[] {0, 3, 0, 1}, piles.getSizes());
		piles.removeObjects(new int[] {3, 1});
		assertArrayEquals(new int[] {0, 3, 0, 0}, piles.getSizes());
		piles.removeObjects(new int[] {1, 3});
		assertArrayEquals(new int[] {0, 0, 0, 0}, piles.getSizes());
	}
	
	@Test
	void testIllegalMoves() throws InvalidInitPilesException, 
	IllegalMoveException {
		Piles piles1 = new Piles(new int[] {3, 4, 5});
		
		IllegalMoveException exception;
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(null));
		assertEquals("null move", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {}));
		assertEquals("Invalid length: 0", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {2, 3, 1}));
		assertEquals("Invalid length: 3", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {1, 3, 2, 5, 4}));
		assertEquals("Invalid length: 5", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {-1, 2}));
		assertEquals("Pile index out of range: -1", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {3, 5}));
		assertEquals("Pile index out of range: 3", exception.getMessage());
		
		piles1.removeObjects(new int[] {2, 5});
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {2, 1}));
		assertEquals("Pile 2 is empty.", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {1, -1}));
		assertEquals("Nonpositive object number: -1", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles1.removeObjects(new int[] {1, 5}));
		assertEquals("Object number greater than pile size: 5 > 4", 
				exception.getMessage());
		
		Piles piles2 = new Piles(new int[] {4, 6, 2, 8});
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {4, 1}));
		assertEquals("Pile index out of range: 4", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {10, 1}));
		assertEquals("Pile index out of range: 10", exception.getMessage());
		
		piles2.removeObjects(new int[] {1, 6});
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {1, 2}));
		assertEquals("Pile 1 is empty.", exception.getMessage());
		
		piles2.removeObjects(new int[] {0, 4});
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {0, 3}));
		assertEquals("Pile 0 is empty.", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {3, -7}));
		assertEquals("Nonpositive object number: -7", exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {2, 4}));
		assertEquals("Object number greater than pile size: 4 > 2", 
				exception.getMessage());
		
		exception = assertThrows(IllegalMoveException.class, 
				() -> piles2.removeObjects(new int[] {3, 9}));
		assertEquals("Object number greater than pile size: 9 > 8", 
				exception.getMessage());
	}

	@Test
	void testIsEmpty() throws InvalidInitPilesException, IllegalMoveException {
		Piles piles = new Piles(new int[] {1, 2});
		assertFalse(piles.isEmpty());
		
		piles.removeObjects(new int[] {1, 1});
		assertFalse(piles.isEmpty());
		piles.removeObjects(new int[] {1, 1});
		assertFalse(piles.isEmpty());
		piles.removeObjects(new int[] {0, 1});
		assertTrue(piles.isEmpty());
		
		piles = new Piles(new int[] {1, 3, 5, 7});
		assertFalse(piles.isEmpty());
		
		piles.removeObjects(new int[] {0, 1});
		assertFalse(piles.isEmpty());
		piles.removeObjects(new int[] {1, 3});
		assertFalse(piles.isEmpty());
		piles.removeObjects(new int[] {3, 7});
		assertFalse(piles.isEmpty());
		piles.removeObjects(new int[] {2, 5});
		assertTrue(piles.isEmpty());
	}
}
