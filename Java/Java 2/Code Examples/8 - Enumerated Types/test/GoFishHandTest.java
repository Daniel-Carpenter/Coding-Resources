import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class GoFishHandTest {

	@Test
	void testInheritance() {
		Hand hand = new GoFishHand(new Card[] {});
		assertTrue(hand instanceof Hand);
		assertTrue(hand instanceof GoFishHand);
	}
	
	@Test
	void testGetRanks() {
		GoFishHand hand = new GoFishHand(new Card[] {});
		Set<Rank> set = hand.getRanks();
		assertTrue(set.isEmpty());
		
		hand.addCard(new Card(Rank.THREE, Suit.HEARTS));
		set = hand.getRanks();
		// Do you have any 2s?
		assertFalse(set.contains(Rank.TWO));  // Go fish!
		assertTrue(set.contains(Rank.THREE));
		assertEquals(1, set.size());
		
		hand.addCard(new Card(Rank.THREE, Suit.CLUBS));
		set = hand.getRanks();
		assertFalse(set.contains(Rank.TWO));
		assertTrue(set.contains(Rank.THREE));
		assertEquals(1, set.size());
		
		hand.addCard(new Card(Rank.TWO, Suit.SPADES));
		set = hand.getRanks();
		assertTrue(set.contains(Rank.TWO));
		assertTrue(set.contains(Rank.THREE));
		assertEquals(2, set.size());
		
		hand.addCard(new Card(Rank.JACK, Suit.HEARTS));
		set = hand.getRanks();
		assertTrue(set.contains(Rank.TWO));
		assertTrue(set.contains(Rank.THREE));
		assertTrue(set.contains(Rank.JACK));
		assertEquals(3, set.size());
	}
	
	@Test
	void testRankCounts() {
		Card[] cards = {
				new Card(Rank.FIVE, Suit.SPADES),
				new Card(Rank.FOUR, Suit.SPADES),
				new Card(Rank.ACE, Suit.DIAMONDS),
				new Card(Rank.FOUR, Suit.DIAMONDS)};
		GoFishHand hand = new GoFishHand(cards);
		
		Map<Rank, Integer> map = hand.getRankCounts();
		assertEquals(13, map.size());
		assertEquals(0, map.get(Rank.TWO));
		assertEquals(0, map.get(Rank.THREE));
		assertEquals(2, map.get(Rank.FOUR));
		assertEquals(1, map.get(Rank.FIVE));
		assertEquals(0, map.get(Rank.SIX));
		assertEquals(0, map.get(Rank.SEVEN));
		assertEquals(0, map.get(Rank.EIGHT));
		assertEquals(0, map.get(Rank.NINE));
		assertEquals(0, map.get(Rank.TEN));
		assertEquals(0, map.get(Rank.JACK));
		assertEquals(0, map.get(Rank.QUEEN));
		assertEquals(0, map.get(Rank.KING));
		assertEquals(1, map.get(Rank.ACE));
		
		hand.addCard(new Card(Rank.EIGHT, Suit.HEARTS));
		hand.addCard(new Card(Rank.FOUR, Suit.HEARTS));
		hand.addCard(new Card(Rank.EIGHT, Suit.SPADES));
		map = hand.getRankCounts();
		assertEquals(13, map.size());
		assertEquals(0, map.get(Rank.TWO));
		assertEquals(0, map.get(Rank.THREE));
		assertEquals(3, map.get(Rank.FOUR));
		assertEquals(1, map.get(Rank.FIVE));
		assertEquals(0, map.get(Rank.SIX));
		assertEquals(0, map.get(Rank.SEVEN));
		assertEquals(2, map.get(Rank.EIGHT));
		assertEquals(0, map.get(Rank.NINE));
		assertEquals(0, map.get(Rank.TEN));
		assertEquals(0, map.get(Rank.JACK));
		assertEquals(0, map.get(Rank.QUEEN));
		assertEquals(0, map.get(Rank.KING));
		assertEquals(1, map.get(Rank.ACE));
		
		hand.addCard(new Card(Rank.TWO, Suit.CLUBS));
		hand.addCard(new Card(Rank.THREE, Suit.CLUBS));
		hand.addCard(new Card(Rank.EIGHT, Suit.DIAMONDS));
		hand.addCard(new Card(Rank.EIGHT, Suit.CLUBS));
		hand.addCard(new Card(Rank.TEN, Suit.DIAMONDS));
		map = hand.getRankCounts();
		assertEquals(13, map.size());
		assertEquals(1, map.get(Rank.TWO));
		assertEquals(1, map.get(Rank.THREE));
		assertEquals(3, map.get(Rank.FOUR));
		assertEquals(1, map.get(Rank.FIVE));
		assertEquals(0, map.get(Rank.SIX));
		assertEquals(0, map.get(Rank.SEVEN));
		assertEquals(4, map.get(Rank.EIGHT));
		assertEquals(0, map.get(Rank.NINE));
		assertEquals(1, map.get(Rank.TEN));
		assertEquals(0, map.get(Rank.JACK));
		assertEquals(0, map.get(Rank.QUEEN));
		assertEquals(0, map.get(Rank.KING));
		assertEquals(1, map.get(Rank.ACE));
		
		hand.playCard(0);
		hand.playCard(0);
		hand.playCard(0);
		hand.playCard(0);
		map = hand.getRankCounts();
		assertEquals(13, map.size());
		assertEquals(1, map.get(Rank.TWO));
		assertEquals(1, map.get(Rank.THREE));
		assertEquals(1, map.get(Rank.FOUR));
		assertEquals(0, map.get(Rank.FIVE));
		assertEquals(0, map.get(Rank.SIX));
		assertEquals(0, map.get(Rank.SEVEN));
		assertEquals(4, map.get(Rank.EIGHT));
		assertEquals(0, map.get(Rank.NINE));
		assertEquals(1, map.get(Rank.TEN));
		assertEquals(0, map.get(Rank.JACK));
		assertEquals(0, map.get(Rank.QUEEN));
		assertEquals(0, map.get(Rank.KING));
		assertEquals(0, map.get(Rank.ACE));
	}
}
