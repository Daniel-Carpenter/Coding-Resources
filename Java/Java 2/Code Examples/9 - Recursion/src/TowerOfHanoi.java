import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Daniel Carpenter
 * 
 * A class that represents a game of Tower of Hanoi.
 */
public class TowerOfHanoi {

	HashMap<Peg, Deque<Integer>> towers = new HashMap<Peg, Deque<Integer>>();

	public TowerOfHanoi(int numDisks, Peg start) {

		// Must have more than 0 disks to play ToH
		if (numDisks <= 0) {
			throw new IllegalArgumentException();
		}

		// Construct Towers
		towers.put(Peg.LEFT,   new LinkedList<Integer>());
		towers.put(Peg.MIDDLE, new LinkedList<Integer>());
		towers.put(Peg.RIGHT,  new LinkedList<Integer>());

		int smallestDisk = 1;
		int largestDisk = numDisks;

		// Put disks on start tower
		for (Integer i = largestDisk; i >= smallestDisk; --i) {
			towers.get(start).push(i);
		}
	}

	public Deque<Integer> getDisks(Peg peg) {
		// return copy of disks on given peg
		return new LinkedList<Integer>(towers.get(peg));
	}

	public void moveDisk(Move move) throws IllegalMoveException {

		// Must have disks on a tower to move
		if (getDisks(move.from).isEmpty()) {
			throw new IllegalMoveException();
		}

		int topOfFrom = this.getDisks(move.from).getFirst();
		int topOfTo = topOfFrom + 1; // + 1 because it only matters that it is larger

		// If the tower isn't empty, store the top disk value in topOfTo
		if (!this.getDisks(move.to).isEmpty()) {
			topOfTo = this.getDisks(move.to).getFirst();
		}

		// Moving the from disk must be smaller than the to disk
		if (topOfFrom > topOfTo) {
			throw new IllegalMoveException();
		}

		// get top disk on "from" peg and add to the "to" peg
		this.towers.get(move.to).push(topOfFrom);
		;

		// Remove top disk on "from" peg
		this.towers.get(move.from).removeFirst();
	}

	public String toString() {
		String strOut   = "  LEFT: " + reverseToString(getDisks(Peg.LEFT))		+ "\n"
						+ "MIDDLE: " + reverseToString(getDisks(Peg.MIDDLE))	+ "\n"
						+ " RIGHT: " + reverseToString(getDisks(Peg.RIGHT));
		
		return strOut;
	}
	
	/**
	 * Returns a string representation of a Deque of integers in the reverse 
	 * order of its toString method.
	 * 
	 * @param deque a Deque of integers
	 * @return a string representation of the Deque
	 */
	private static String reverseToString(Deque<Integer> deque) {
		if (deque.isEmpty()) {
			return "[]";
		}
		Iterator<Integer> iterator = deque.descendingIterator();
		StringBuilder sb = new StringBuilder("[" + iterator.next());
		while (iterator.hasNext()) {
			sb.append(", ");
			sb.append(iterator.next());
		}
		sb.append("]");
		return sb.toString();
	}
}
