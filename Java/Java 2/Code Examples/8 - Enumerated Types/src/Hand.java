/**
 * @author Daniel Carpenter
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Hand {
	private ArrayList<Card> cards;

	public Hand(Card[] cards) {
		this.cards = new ArrayList<Card>(Arrays.asList(cards));
	}

	public Integer size() {
		return getCards().size();
	}

	public Card getCard(int i) {
		return getCards().get(i);
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

	public Object playCard(int i) {
		
		try 
		{
			if (cards.size() == 0)
			{
				throw new IndexOutOfBoundsException();
			}
			else
			{
				// Copy Card to give to player
				Card topCard = cards.get(i);
				
				// Remove Card
				cards.remove(i);
				return topCard;				
			}
		}
		catch (IndexOutOfBoundsException OB)
		{
			return null;
		}
	}

	public boolean isSorted() {
		int ONE_CARD = 1;
		
		if (getCards().size() <= ONE_CARD)
		{
			return true;
		}
		else
		{
			// Create empty array to store cards
				Card[] cards = new Card[this.getCards().size()];
				
			// Store Cards
				for (int i = 0; i < cards.length; ++i)
				{
					cards[i] = this.getCard(i);
				}
				
			// Create Hand from cards and Sort Hand
				Hand hand = new Hand(cards);
				hand.sort();
						
			int i = 0;
			
			// Check if all indices match the perfectly sorted array vs. the currently stored array
			for (Card sortedElement : hand.getCards())
			{
				// Get Sorted and current rank of element i
					Suit suitSortedOrder = sortedElement.getSuit();
					Suit suitCurrOrder	 = getCards().get(i).getSuit();
				
				// Return false since array does not match
					if (!suitSortedOrder.equals(suitCurrOrder))
						return false;
				
				// Get Sorted and current rank of element i
					Rank rankSortedOrder = sortedElement.getRank();
					Rank rankCurrOrder	 = getCards().get(i).getRank();
				
				// Return false since array does not match
					if (!rankSortedOrder.equals(rankCurrOrder))
						return false;
				
				++i;				
			}
			
			return true;			
		}
	}

	public void sort() {
		Collections.sort(getCards());
	}


	public String toString() {
		return getCards().toString();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}
