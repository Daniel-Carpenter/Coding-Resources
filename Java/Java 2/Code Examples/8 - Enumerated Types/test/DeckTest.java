import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeckTest {

	@Test
	void testNoArgumentConstructor() {
		Deck deck = new Deck();
		
		Card card = deck.draw();
		assertEquals("2C", card.toString());
		card = deck.draw();
		assertEquals("3C", card.toString());
		card = deck.draw();
		assertEquals("4C", card.toString());
		
		for (int count = 0; count < 9; ++count) {
			deck.draw();
		}
		card = deck.draw();
		assertEquals("AC", card.toString());
		card = deck.draw();
		assertEquals("2D", card.toString());
		card = deck.draw();
		assertEquals("3D", card.toString());
		card = deck.draw();
		assertEquals("4D", card.toString());
		
		for (int count = 0; count < 20; ++count) {
			deck.draw();
		}
		card = deck.draw();
		assertEquals("QH", card.toString());
		card = deck.draw();
		assertEquals("KH", card.toString());
		card = deck.draw();
		assertEquals("AH", card.toString());
		card = deck.draw();
		assertEquals("2S", card.toString());
		
		for (int count = 0; count < 10; ++count) {
			deck.draw();
		}
		card = deck.draw();
		assertEquals("KS", card.toString());
		card = deck.draw();
		assertEquals("AS", card.toString());
		card = deck.draw();
		assertNull(card);
		card = deck.draw();
		assertNull(card);
	}

	@Test
	void testShuffle() {
		Card[] cards = {
				new Card(Rank.FIVE, Suit.SPADES), 
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.THREE, Suit.SPADES),
				new Card(Rank.KING, Suit.CLUBS),
				new Card(Rank.ACE, Suit.DIAMONDS)};
		Deck deck = new Deck(cards);
		
		assertEquals("[5S, 4H, 3S, KC, AD]", deck.toString());
		deck.shuffle();
		assertEquals(cards.length, deck.size());
		assertNotEquals("[5S, 4H, 3S, KC, AD]", deck.toString());
	}
	
	@Test
	void testCopyConstructor() {
		Card[] cards = {
				new Card(Rank.SEVEN, Suit.CLUBS), 
				new Card(Rank.TWO, Suit.HEARTS),
				new Card(Rank.QUEEN, Suit.CLUBS),
				new Card(Rank.NINE, Suit.SPADES),
				new Card(Rank.QUEEN, Suit.DIAMONDS)};
		Deck d1 = new Deck(cards);
		Deck d2 = new Deck(d1);
		
		assertEquals("[7C, 2H, QC, 9S, QD]", d1.toString());
		assertEquals("[7C, 2H, QC, 9S, QD]", d2.toString());
		for (int idx = 0; idx < cards.length; ++idx) {
			cards[idx] = null;
		}
		assertEquals("[7C, 2H, QC, 9S, QD]", d1.toString());
		assertEquals("[7C, 2H, QC, 9S, QD]", d2.toString());
		
		assertEquals("7C", d2.draw().toString());
		assertEquals("[7C, 2H, QC, 9S, QD]", d1.toString());
		assertEquals("[2H, QC, 9S, QD]", d2.toString());
		assertEquals(5, d1.size());
		assertEquals(4, d2.size());
		
		assertEquals("2H", d2.draw().toString());
		assertEquals("QC", d2.draw().toString());
		assertEquals("[7C, 2H, QC, 9S, QD]", d1.toString());
		assertEquals("[9S, QD]", d2.toString());
		assertEquals(5, d1.size());
		assertEquals(2, d2.size());
		
		assertEquals("9S", d2.draw().toString());
		assertEquals("QD", d2.draw().toString());
		assertNull(d2.draw());
		assertEquals("[7C, 2H, QC, 9S, QD]", d1.toString());
		assertEquals("[]", d2.toString());
		assertEquals(5, d1.size());
		assertEquals(0, d2.size());
	}
}
