import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HandTest {

	@Test
	void test() {
		Hand hand = new Hand(new Card[] {});
		assertEquals(0, hand.size());
		assertEquals("[]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.SIX, Suit.DIAMONDS));
		assertEquals(1, hand.size());
		assertEquals("[6D]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.KING, Suit.CLUBS));
		assertEquals(2, hand.size());
		assertEquals("[6D, KC]", hand.toString());
		assertFalse(hand.isSorted());
		
		hand.sort();
		assertEquals(2, hand.size());
		assertEquals("[KC, 6D]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.TEN, Suit.HEARTS));
		assertEquals(3, hand.size());
		assertEquals("[KC, 6D, 10H]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.sort();
		assertEquals(3, hand.size());
		assertEquals("[KC, 6D, 10H]", hand.toString());
		assertTrue(hand.isSorted());
		
		assertEquals("6D", hand.playCard(1).toString());
		assertEquals(2, hand.size());
		assertEquals("[KC, 10H]", hand.toString());
		assertTrue(hand.isSorted());
		
		hand.addCard(new Card(Rank.NINE, Suit.HEARTS));
		assertEquals(3, hand.size());
		assertEquals("[KC, 10H, 9H]", hand.toString());
//		hand.sort();
//		System.out.println(hand.toString());
		assertFalse(hand.isSorted());
		
		hand.sort();
		assertEquals(3, hand.size());
		assertEquals("[KC, 9H, 10H]", hand.toString());
		assertTrue(hand.isSorted());
		
		assertEquals("9H", hand.playCard(1).toString());
		assertEquals(2, hand.size());
		assertEquals("KC", hand.getCard(0).toString());
		assertEquals("10H", hand.getCard(1).toString());
		assertTrue(hand.isSorted());
		
		assertEquals("KC", hand.playCard(0).toString());
		assertEquals(1, hand.size());
		assertEquals("10H", hand.getCard(0).toString());
		assertTrue(hand.isSorted());
		
		assertEquals("10H", hand.playCard(0).toString());
		assertEquals(0, hand.size());
		assertTrue(hand.isSorted());
	}
}
