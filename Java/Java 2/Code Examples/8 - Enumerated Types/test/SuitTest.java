import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SuitTest {

	@Test
	void testToString() {
		assertEquals("C", Suit.CLUBS.toString());
		assertEquals("D", Suit.DIAMONDS.toString());
		assertEquals("H", Suit.HEARTS.toString());
		assertEquals("S", Suit.SPADES.toString());
	}

	@Test
	void testCompareTo() {
		assertTrue(Suit.CLUBS.compareTo(Suit.DIAMONDS) < 0);
		assertTrue(Suit.DIAMONDS.compareTo(Suit.HEARTS) < 0);
		assertTrue(Suit.HEARTS.compareTo(Suit.SPADES) < 0);
		
		assertTrue(Suit.SPADES.compareTo(Suit.HEARTS) > 0);
		assertTrue(Suit.HEARTS.compareTo(Suit.DIAMONDS) > 0);
		assertTrue(Suit.DIAMONDS.compareTo(Suit.CLUBS) > 0);
		
		assertTrue(Suit.CLUBS.compareTo(Suit.CLUBS) == 0);
		assertTrue(Suit.DIAMONDS.compareTo(Suit.DIAMONDS) == 0);
		assertTrue(Suit.HEARTS.compareTo(Suit.HEARTS) == 0);
		assertTrue(Suit.SPADES.compareTo(Suit.SPADES) == 0);
	}
}
