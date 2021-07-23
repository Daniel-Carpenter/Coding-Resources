import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HoldemHandTest {

	@Test
	void testInheritance() {
		Card c1 = new Card(Rank.TEN, Suit.CLUBS);
		Card c2 = new Card(Rank.TEN, Suit.CLUBS);
		Hand hand = new HoldemHand(c1, c2);
		assertTrue(hand instanceof Hand);
		assertTrue(hand instanceof HoldemHand);
	}

	@Test
	void testMutators() {
		Card c1 = new Card(Rank.FIVE, Suit.HEARTS);
		Card c2 = new Card(Rank.KING, Suit.SPADES);
		HoldemHand hand = new HoldemHand(c1, c2);
		
		hand.addCard(new Card(Rank.FIVE, Suit.CLUBS));
		assertEquals(2, hand.size());
		assertEquals("[5H, KS]", hand.toString());
		
		assertNull(hand.playCard(0));
		assertEquals(2, hand.size());
		assertEquals("[5H, KS]", hand.toString());
	}
	
	@Test
	void testHasFlush() {
		Card c1 = new Card(Rank.TEN, Suit.HEARTS);
		Card c2 = new Card(Rank.JACK, Suit.SPADES);
		HoldemHand hand = new HoldemHand(c1, c2);
		
		Card[] community = {
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.KING, Suit.SPADES)};
		assertFalse(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.KING, Suit.SPADES),
				new Card(Rank.ACE, Suit.HEARTS)};
		assertFalse(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.KING, Suit.SPADES),
				new Card(Rank.ACE, Suit.HEARTS),
				new Card(Rank.SEVEN, Suit.HEARTS)};
		assertTrue(hand.hasFlush(community));
		
		c1 = new Card(Rank.TEN, Suit.HEARTS);
		c2 = new Card(Rank.JACK, Suit.HEARTS);
		hand = new HoldemHand(c1, c2);
		
		community = new Card[] {
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.KING, Suit.HEARTS)};
		assertTrue(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.KING, Suit.HEARTS),
				new Card(Rank.TWO, Suit.SPADES)};
		assertTrue(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.FOUR, Suit.HEARTS),
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.KING, Suit.HEARTS),
				new Card(Rank.TWO, Suit.SPADES),
				new Card(Rank.THREE, Suit.HEARTS)};
		assertTrue(hand.hasFlush(community));
		
		c1 = new Card(Rank.TEN, Suit.DIAMONDS);
		c2 = new Card(Rank.JACK, Suit.DIAMONDS);
		hand = new HoldemHand(c1, c2);
		
		community = new Card[] {
				new Card(Rank.NINE, Suit.CLUBS),
				new Card(Rank.EIGHT, Suit.CLUBS),
				new Card(Rank.JACK, Suit.CLUBS)};
		assertFalse(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.NINE, Suit.CLUBS),
				new Card(Rank.EIGHT, Suit.CLUBS),
				new Card(Rank.JACK, Suit.CLUBS),
				new Card(Rank.FIVE, Suit.CLUBS)};
		assertFalse(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.NINE, Suit.CLUBS),
				new Card(Rank.EIGHT, Suit.CLUBS),
				new Card(Rank.JACK, Suit.CLUBS),
				new Card(Rank.FIVE, Suit.CLUBS),
				new Card(Rank.ACE, Suit.DIAMONDS)};
		assertFalse(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.NINE, Suit.CLUBS),
				new Card(Rank.EIGHT, Suit.CLUBS),
				new Card(Rank.JACK, Suit.CLUBS),
				new Card(Rank.FIVE, Suit.CLUBS),
				new Card(Rank.ACE, Suit.CLUBS)};
		assertTrue(hand.hasFlush(community));
		
		community = new Card[] {
				new Card(Rank.NINE, Suit.HEARTS),
				new Card(Rank.EIGHT, Suit.HEARTS),
				new Card(Rank.JACK, Suit.HEARTS),
				new Card(Rank.FIVE, Suit.HEARTS),
				new Card(Rank.ACE, Suit.HEARTS)};
		assertTrue(hand.hasFlush(community));
	}
}
