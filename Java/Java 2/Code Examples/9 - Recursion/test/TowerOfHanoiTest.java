import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.Test;

class TowerOfHanoiTest {

	@Test
	void testConstructor() {
		assertThrows(IllegalArgumentException.class, 
				() -> new TowerOfHanoi(0, null));
		assertThrows(IllegalArgumentException.class, 
				() -> new TowerOfHanoi(-1, null));

		TowerOfHanoi game = new TowerOfHanoi(1, Peg.LEFT);
		List<Integer> disks = Arrays.asList(new Integer[] {1});
		assertEquals(disks, game.getDisks(Peg.LEFT));
		disks = Arrays.asList(new Integer[] {});
		assertEquals(disks, game.getDisks(Peg.MIDDLE));
		assertEquals(disks, game.getDisks(Peg.RIGHT));
		
		game = new TowerOfHanoi(4, Peg.MIDDLE);
		disks = Arrays.asList(new Integer[] {1, 2, 3, 4});
		assertEquals(disks, game.getDisks(Peg.MIDDLE));
		disks = Arrays.asList(new Integer[] {});
		assertEquals(disks, game.getDisks(Peg.LEFT));
		assertEquals(disks, game.getDisks(Peg.RIGHT));
		
		game = new TowerOfHanoi(7, Peg.RIGHT);
		disks = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7});
		assertEquals(disks, game.getDisks(Peg.RIGHT));
		disks = Arrays.asList(new Integer[] {});
		assertEquals(disks, game.getDisks(Peg.LEFT));
		assertEquals(disks, game.getDisks(Peg.MIDDLE));
	}

	@Test
	void testGetDisks() {
		TowerOfHanoi game = new TowerOfHanoi(1, Peg.LEFT);
		assertTrue(game.getDisks(Peg.LEFT) instanceof Deque);
		assertTrue(game.getDisks(Peg.MIDDLE) instanceof Deque);
		assertTrue(game.getDisks(Peg.RIGHT) instanceof Deque);
		
		// Check encapsulation
		Deque<Integer> leftDisks = game.getDisks(Peg.LEFT);
		Deque<Integer> middleDisks = game.getDisks(Peg.MIDDLE);
		Deque<Integer> rightDisks = game.getDisks(Peg.RIGHT);
		leftDisks.push(-1);
		middleDisks.push(0);
		rightDisks.push(1);
		
		List<Integer> disks = Arrays.asList(new Integer[] {1});
		assertEquals(disks, game.getDisks(Peg.LEFT));
		disks = Arrays.asList(new Integer[] {});
		assertEquals(disks, game.getDisks(Peg.MIDDLE));
		assertEquals(disks, game.getDisks(Peg.RIGHT));
	}
	
	@Test
	void testMoveDisk() throws IllegalMoveException {
		TowerOfHanoi game = new TowerOfHanoi(3, Peg.LEFT);
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.MIDDLE_TO_LEFT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.MIDDLE_TO_RIGHT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.RIGHT_TO_LEFT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.RIGHT_TO_MIDDLE));
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		List<Integer> leftDisks = Arrays.asList(new Integer[] {2, 3});
		List<Integer> middleDisks = Arrays.asList(new Integer[] {});
		List<Integer> rightDisks = Arrays.asList(new Integer[] {1});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
		
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.LEFT_TO_RIGHT));
		
		game.moveDisk(Move.LEFT_TO_MIDDLE);
		leftDisks = Arrays.asList(new Integer[] {3});
		middleDisks = Arrays.asList(new Integer[] {2});
		rightDisks = Arrays.asList(new Integer[] {1});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
		
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.LEFT_TO_MIDDLE));
		
		game.moveDisk(Move.RIGHT_TO_MIDDLE);
		leftDisks = Arrays.asList(new Integer[] {3});
		middleDisks = Arrays.asList(new Integer[] {1, 2});
		rightDisks = Arrays.asList(new Integer[] {});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		leftDisks = Arrays.asList(new Integer[] {});
		middleDisks = Arrays.asList(new Integer[] {1, 2});
		rightDisks = Arrays.asList(new Integer[] {3});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
		
		game.moveDisk(Move.MIDDLE_TO_LEFT);
		leftDisks = Arrays.asList(new Integer[] {1});
		middleDisks = Arrays.asList(new Integer[] {2});
		rightDisks = Arrays.asList(new Integer[] {3});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
		
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.MIDDLE_TO_LEFT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.RIGHT_TO_LEFT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.RIGHT_TO_MIDDLE));
		
		game.moveDisk(Move.MIDDLE_TO_RIGHT);
		leftDisks = Arrays.asList(new Integer[] {1});
		middleDisks = Arrays.asList(new Integer[] {});
		rightDisks = Arrays.asList(new Integer[] {2, 3});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		leftDisks = Arrays.asList(new Integer[] {});
		middleDisks = Arrays.asList(new Integer[] {});
		rightDisks = Arrays.asList(new Integer[] {1, 2, 3});
		assertEquals(leftDisks, game.getDisks(Peg.LEFT));
		assertEquals(middleDisks, game.getDisks(Peg.MIDDLE));
		assertEquals(rightDisks, game.getDisks(Peg.RIGHT));
	}
	
	@Test
	void testToString() throws IllegalMoveException {
		TowerOfHanoi game = new TowerOfHanoi(3, Peg.LEFT);
		String string = "  LEFT: [3, 2, 1]\nMIDDLE: []\n RIGHT: []";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		string = "  LEFT: [3, 2]\nMIDDLE: []\n RIGHT: [1]";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.LEFT_TO_MIDDLE);
		string = "  LEFT: [3]\nMIDDLE: [2]\n RIGHT: [1]";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.RIGHT_TO_MIDDLE);
		string = "  LEFT: [3]\nMIDDLE: [2, 1]\n RIGHT: []";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		string = "  LEFT: []\nMIDDLE: [2, 1]\n RIGHT: [3]";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.MIDDLE_TO_LEFT);
		string = "  LEFT: [1]\nMIDDLE: [2]\n RIGHT: [3]";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.MIDDLE_TO_RIGHT);
		string = "  LEFT: [1]\nMIDDLE: []\n RIGHT: [3, 2]";
		assertEquals(string, game.toString());
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		string = "  LEFT: []\nMIDDLE: []\n RIGHT: [3, 2, 1]";
		assertEquals(string, game.toString());
	}
}
