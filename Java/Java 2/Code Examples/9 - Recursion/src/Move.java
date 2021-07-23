/**
 * An enumerated type that represents the six possible moves in a game of Tower 
 * of Hanoi.
 */
public enum Move {
	LEFT_TO_MIDDLE(Peg.LEFT, Peg.MIDDLE),
	LEFT_TO_RIGHT(Peg.LEFT, Peg.RIGHT),
	MIDDLE_TO_LEFT(Peg.MIDDLE, Peg.LEFT),
	MIDDLE_TO_RIGHT(Peg.MIDDLE, Peg.RIGHT),
	RIGHT_TO_LEFT(Peg.RIGHT, Peg.LEFT),
	RIGHT_TO_MIDDLE(Peg.RIGHT, Peg.MIDDLE);
	
	public final Peg from;
	public final Peg to;
	
	private Move(Peg from, Peg to) {
		this.from = from;
		this.to = to;
	}
	
	/**
	 * Returns the move that transfers the top disk from the first given peg to 
	 * the second.
	 * 
	 * @param from the peg the disk starts on
	 * @param to the peg the disk is moved to
	 * @return the move
	 * @throws IllegalArgumentException if from and to are the same or null
	 */
	public static Move getMove(Peg from, Peg to) {
		if (from == Peg.LEFT) {
			if (to == Peg.MIDDLE) {
				return LEFT_TO_MIDDLE;
			}
			if (to == Peg.RIGHT) {
				return LEFT_TO_RIGHT;
			}
		} else if (from == Peg.MIDDLE) {
			if (to == Peg.LEFT) {
				return MIDDLE_TO_LEFT;
			}
			if (to == Peg.RIGHT) {
				return MIDDLE_TO_RIGHT;
			}
		} else if (from == Peg.RIGHT) {
			if (to == Peg.LEFT) {
				return RIGHT_TO_LEFT;
			}
			if (to == Peg.MIDDLE) {
				return RIGHT_TO_MIDDLE;
			}
		}
		throw new IllegalArgumentException();
	}
}
