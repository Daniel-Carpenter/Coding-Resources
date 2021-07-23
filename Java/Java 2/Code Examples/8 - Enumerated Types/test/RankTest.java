import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankTest {

	@Test
	void testToString() {
		assertEquals("2", Rank.TWO.toString());
		assertEquals("3", Rank.THREE.toString());
		assertEquals("4", Rank.FOUR.toString());
		assertEquals("5", Rank.FIVE.toString());
		assertEquals("6", Rank.SIX.toString());
		assertEquals("7", Rank.SEVEN.toString());
		assertEquals("8", Rank.EIGHT.toString());
		assertEquals("9", Rank.NINE.toString());
		assertEquals("10", Rank.TEN.toString());
		assertEquals("J", Rank.JACK.toString());
		assertEquals("Q", Rank.QUEEN.toString());
		assertEquals("K", Rank.KING.toString());
		assertEquals("A", Rank.ACE.toString());
	}
	
	@Test
	void testCompareTo() {
		assertTrue(Rank.TWO.compareTo(Rank.THREE) < 0);
		assertTrue(Rank.THREE.compareTo(Rank.TWO) > 0);
		assertTrue(Rank.TWO.compareTo(Rank.TWO) == 0);
		assertTrue(Rank.THREE.compareTo(Rank.THREE) == 0);
		
		assertTrue(Rank.TEN.compareTo(Rank.JACK) < 0);
		assertTrue(Rank.JACK.compareTo(Rank.TEN) > 0);
		assertTrue(Rank.TEN.compareTo(Rank.TEN) == 0);
		assertTrue(Rank.JACK.compareTo(Rank.JACK) == 0);
		
		assertTrue(Rank.SEVEN.compareTo(Rank.QUEEN) < 0);
		assertTrue(Rank.QUEEN.compareTo(Rank.SEVEN) > 0);
		assertTrue(Rank.SEVEN.compareTo(Rank.SEVEN) == 0);
		assertTrue(Rank.QUEEN.compareTo(Rank.QUEEN) == 0);
		
		assertTrue(Rank.TWO.compareTo(Rank.ACE) < 0);
		assertTrue(Rank.ACE.compareTo(Rank.TWO) > 0);
		assertTrue(Rank.ACE.compareTo(Rank.ACE) == 0);
	}
}
