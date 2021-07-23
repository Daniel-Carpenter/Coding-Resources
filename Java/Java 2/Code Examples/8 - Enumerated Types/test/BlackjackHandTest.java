import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlackjackHandTest {

	@Test
	void testCardValues() {
		assertEquals(2, BlackjackHand.CARD_VALUES.get(Rank.TWO));
		assertEquals(5, BlackjackHand.CARD_VALUES.get(Rank.FIVE));
		assertEquals(8, BlackjackHand.CARD_VALUES.get(Rank.EIGHT));
		assertEquals(10, BlackjackHand.CARD_VALUES.get(Rank.TEN));
		assertEquals(10, BlackjackHand.CARD_VALUES.get(Rank.QUEEN));
		assertEquals(11, BlackjackHand.CARD_VALUES.get(Rank.ACE));
	}
	
	@Test
	void testInheritance() {
		Card c1 = new Card(Rank.TWO, Suit.CLUBS);
		Card c2 = new Card(Rank.THREE, Suit.CLUBS);
		Hand hand = new BlackjackHand(c1, c2);
		assertTrue(hand instanceof Hand);
		assertTrue(hand instanceof BlackjackHand);
	}
	
	@Test
	void testPlayCard() {
		Card c1 = new Card(Rank.FOUR, Suit.DIAMONDS);
		Card c2 = new Card(Rank.FIVE, Suit.DIAMONDS);
		Hand hand = new BlackjackHand(c1, c2);
		assertNull(hand.playCard(1));
		assertNull(hand.playCard(0));
		assertEquals(2, hand.size());
	}

	@Test
	void testValue() {
		Card c1 = new Card(Rank.JACK, Suit.HEARTS);
		Card c2 = new Card(Rank.ACE, Suit.SPADES);
		BlackjackHand hand = new BlackjackHand(c1, c2);
		assertEquals(21, hand.getValue());
		hand.addCard(new Card(Rank.TWO, Suit.CLUBS));
		assertEquals(21, hand.getValue());
		
		c1 = new Card(Rank.KING, Suit.CLUBS);
		c2 = new Card(Rank.NINE, Suit.SPADES);
		hand = new BlackjackHand(c1, c2);
		assertEquals(19, hand.getValue());
		hand.addCard(new Card(Rank.THREE, Suit.DIAMONDS));
		assertEquals(22, hand.getValue());
		hand.addCard(new Card(Rank.TWO, Suit.SPADES));
		assertEquals(22, hand.getValue());
		
		c1 = new Card(Rank.THREE, Suit.HEARTS);
		c2 = new Card(Rank.ACE, Suit.CLUBS);
		hand = new BlackjackHand(c1, c2);
		assertEquals(14, hand.getValue());
		hand.addCard(new Card(Rank.ACE, Suit.SPADES));
		assertEquals(15, hand.getValue());
		hand.addCard(new Card(Rank.FIVE, Suit.DIAMONDS));
		assertEquals(20, hand.getValue());
		hand.addCard(new Card(Rank.SIX, Suit.DIAMONDS));
		assertEquals(16, hand.getValue());
		hand.addCard(new Card(Rank.ACE, Suit.HEARTS));
		assertEquals(17, hand.getValue());
		hand.addCard(new Card(Rank.TWO, Suit.CLUBS));
		assertEquals(19, hand.getValue());
		hand.addCard(new Card(Rank.ACE, Suit.DIAMONDS));
		assertEquals(20, hand.getValue());
		hand.addCard(new Card(Rank.EIGHT, Suit.SPADES));
		assertEquals(28, hand.getValue());
		hand.addCard(new Card(Rank.JACK, Suit.HEARTS));
		assertEquals(28, hand.getValue());
	}
}
