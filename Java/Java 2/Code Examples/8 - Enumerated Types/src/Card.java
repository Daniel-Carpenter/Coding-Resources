/**
 * @author Daniel Carpenter
 */

public class Card implements Comparable<Card> { 

	private Suit suit;
	private Rank rank;

	/**
	 * @param rank Stores rank of card
	 * @param suit Stores suit of card
	 */
	public Card(Rank rank, Suit suit) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * @param otherCard Card of other player
	 * @return Returns 1 if card > otherCard, 0 if equal, else -1
	 */
	public int compareTo(Card otherCard) {
		int suitComparison = suit.toString().compareTo(otherCard.suit.toString());
		
		int rankComparison 	= 0;
		int thisRank  		=      this.rank.switchRankToInt();
		int otherRank 		= otherCard.rank.switchRankToInt();
		
		final int LESS_THAN 	= -1;
		final int EQUAL_TO		=  0;
		final int GREATER_THAN	=  1;
		
		if (thisRank < otherRank)
		{
			rankComparison = LESS_THAN;
		}
		else if (thisRank == otherRank)
		{
			rankComparison = EQUAL_TO;
		}
		else
		{
			rankComparison = GREATER_THAN;
		}
		
		if (suitComparison != EQUAL_TO)
		{
			return suitComparison;
		}
		else
		{
			return rankComparison;
		}		
	}

	/**
	 * @return Returns rank and suit of card
	 */
	public String toString() {
		return getRank().toString() + getSuit().toString();
	}

	/**
	 * @return Returns Card suit first then rank
	 */
	public String toStringBySuit() {
		return getSuit().toString() + getRank().toString();
	}

	// Getters --------------------------------------------------------

	/**
	 * @return Returns suit of card
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * @return returns rank of card
	 */
	public Rank getRank() {
		return rank;
	}

}
