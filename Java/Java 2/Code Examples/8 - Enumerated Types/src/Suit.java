/**
 * @author Daniel Carpenter
 */

public enum Suit
{
	CLUBS("C"), 
	DIAMONDS("D"), 
	HEARTS("H"), 
	SPADES("S");

	private String symbol;

	/**
	 * @param symbol String representation of symbol
	 */
	private Suit(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @param toString Returns the stored symbol value
	 */
	public String toString() {
		return symbol;
	}
}
