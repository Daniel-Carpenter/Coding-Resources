/**
 * @author Daniel Carpenter
 */


public enum Rank 
{
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	TEN("10"),
	JACK("J"),
	QUEEN("Q"),
	KING("K"),
	ACE("A");
	
	private String symbol;

	/**
	 * @param symbol String representation of symbol
	 */
	private Rank(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @param toString Returns the stored symbol value
	 */
	public String toString() {
		return symbol;
	}
	
	public int switchRankToInt()
	{
		switch (symbol)
		{
			case "J":
				return Integer.parseInt("11");
			case "Q":
				return Integer.parseInt("12");
			case "K":
				return Integer.parseInt("13");
			case "A":
				return Integer.parseInt("14");
		}
		return Integer.parseInt(symbol);
	}
}
