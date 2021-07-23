/**
 * An enumerated type that represents the three pegs in a game of Tower of 
 * Hanoi.
 */
public enum Peg {
	LEFT, 
	MIDDLE, 
	RIGHT;
	
	/**
	 * Returns the peg that is not passed to the method.
	 * 
	 * @param p1 one of the pegs
	 * @param p2 a second peg
	 * @return the third peg
	 * @throws IllegalArgumentException if p1 and p2 are the same or null
	 */
	public static Peg getOtherPeg(Peg p1, Peg p2) {
		if (p1 == p2) {
			throw new IllegalArgumentException();
		}
		if (p1 != LEFT && p2 != LEFT) {
			return LEFT;
		}
		if (p1 != MIDDLE && p2 != MIDDLE) {
			return MIDDLE;
		}
		if (p1 != RIGHT && p2 != RIGHT) {
			return RIGHT;
		}
		throw new IllegalArgumentException();
	}
}
