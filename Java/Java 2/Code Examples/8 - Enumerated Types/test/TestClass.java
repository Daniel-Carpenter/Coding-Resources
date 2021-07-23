import java.util.LinkedList;

public class TestClass 
{
	public static void main (String[] args)
	{	
		Card c1 = new Card(Rank.ACE,   Suit.DIAMONDS);
		Card c2 = new Card(Rank.THREE, Suit.CLUBS);
		Card c3 = new Card(Rank.JACK,  Suit.CLUBS);
		Card c4 = new Card(Rank.ACE,   Suit.SPADES);
		
		Card[] cards = {c1, c2, c3, c4};
		Hand hand = new Hand(cards);
		
		System.out.println("Unsorted ------------------");
		System.out.println(hand.toString());
		System.out.println(hand.isSorted());

		hand.sort();
		System.out.println("\nSorted --------------------");
		System.out.println(hand.toString());
		System.out.println(hand.isSorted());
		
		
	}
}
