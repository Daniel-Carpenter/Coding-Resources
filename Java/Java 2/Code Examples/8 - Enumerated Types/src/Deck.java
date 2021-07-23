import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author Daniel Carpenter
 */

public class Deck {

	private LinkedList<Card> cards;

	// Constructors ------------------------------------------------------
		/**
		 * @param cards LinkedList<Card> of suits and ranks
		 */
		public Deck() {
			this.cards = createNewDeck();
		}
	
		public Deck(Card[] cards) {
			this.cards = new LinkedList<Card>(Arrays.asList(cards));
		}
	
		@SuppressWarnings("unchecked")
		public Deck(Deck deck) {
			this.cards = (LinkedList<Card>) deck.getCards().clone();
		}
		
	// Methods -----------------------------------------------------------

		/**
		 * @return Returns new 52 card deck, sorted by suit then rank
		 */
		private LinkedList<Card> createNewDeck() {
	
			// Create card array for the newDeck
			LinkedList<Card> newDeck = new LinkedList<Card>();
	
			int i = 0;
	
			// Add cards to deck in sorted order of suit, then rank
			for (Suit suitVal : Suit.values()) {
				for (Rank rankVal : Rank.values()) {
					newDeck.add(new Card(rankVal, suitVal));
					++i;
				}
			}
			return newDeck;
		}

		/**
		 * @return	Removes top card from deck and returns to player
		 */
		public Card draw()
		{
			final int TOP_CARD_ON_DECK = 0;
			
			try 
			{
				if (cards.size() == 0)
				{
					throw new IndexOutOfBoundsException();
				}
				else
				{
					// Copy Card to give to player
					Card topCard = cards.get(0);
					
					// Remove Card
					cards.remove(TOP_CARD_ON_DECK);
					return topCard;				
				}
			}
			catch (IndexOutOfBoundsException OB)
			{
				return null;
			}
		}
		
		/**
		 * Shuffles deck
		 */
		public void shuffle()
		{
			Collections.shuffle(cards);
		}
		
		/**
		 * @return Returns size of cards
		 */
		public int size() {
			return cards.size();
		}
		
		/**
		 *	@return Returns cards to a String
		 */
		public String toString()
		{
			return cards.toString();
		}
		
		
	// Getters ------------------------------------------------------------
		
		/**
		 * @return Returns cards
		 */
		public LinkedList<Card> getCards() {
			return cards;
		}

}







