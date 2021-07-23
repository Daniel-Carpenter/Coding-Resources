import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void testGetters() {
		Card card = new Card(Rank.TWO, Suit.CLUBS);
		assertEquals(Rank.TWO, card.getRank());
		assertEquals(Suit.CLUBS, card.getSuit());
		
		card = new Card(Rank.QUEEN, Suit.SPADES);
		assertEquals(Rank.QUEEN, card.getRank());
		assertEquals(Suit.SPADES, card.getSuit());
		
		card = new Card(Rank.NINE, Suit.HEARTS);
		assertEquals(Rank.NINE, card.getRank());
		assertEquals(Suit.HEARTS, card.getSuit());
		
		card = new Card(Rank.ACE, Suit.CLUBS);
		assertEquals(Rank.ACE, card.getRank());
		assertEquals(Suit.CLUBS, card.getSuit());
	}
	
	@Test
	void testToString() {
		Card card = new Card(Rank.KING, Suit.HEARTS);
		assertEquals("KH", card.toString());
		
		card = new Card(Rank.TEN, Suit.DIAMONDS);
		assertEquals("10D", card.toString());
		
		card = new Card(Rank.FOUR, Suit.SPADES);
		assertEquals("4S", card.toString());
		
		card = new Card(Rank.JACK, Suit.CLUBS);
		assertEquals("JC", card.toString());
		
		card = new Card(Rank.THREE, Suit.HEARTS);
		assertEquals("3H", card.toString());
	}

	@Test
	void testCompareTo() {
		Card c1 = new Card(Rank.FIVE, Suit.DIAMONDS);
		Card c2 = new Card(Rank.FIVE, Suit.SPADES);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
		
		c1 = new Card(Rank.FIVE, Suit.DIAMONDS);
		c2 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
		
		c1 = new Card(Rank.FIVE, Suit.DIAMONDS);
		c2 = new Card(Rank.EIGHT, Suit.SPADES);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
				
		c1 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		c2 = new Card(Rank.FIVE, Suit.SPADES);
		assertTrue(c1.compareTo(c2) < 0);
		assertTrue(c2.compareTo(c1) > 0);
		
		c1 = new Card(Rank.FIVE, Suit.SPADES);
		c2 = new Card(Rank.EIGHT, Suit.DIAMONDS);
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c2.compareTo(c1) < 0);
		
		c1 = new Card(Rank.EIGHT, Suit.SPADES);
		c2 = new Card(Rank.FIVE, Suit.DIAMONDS);
		assertTrue(c1.compareTo(c2) > 0);
		assertTrue(c2.compareTo(c1) < 0);
	}
}
