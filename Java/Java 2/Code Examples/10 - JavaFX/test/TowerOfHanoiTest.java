import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Move;
import model.Peg;
import model.TowerOfHanoi;
import model.exceptions.IllegalMoveException;

class TowerOfHanoiTest {

	@Test
	void testConstructor() {
		assertThrows(IllegalArgumentException.class, 
				() -> new TowerOfHanoi(0, null));
		assertThrows(IllegalArgumentException.class, 
				() -> new TowerOfHanoi(-1, null));

		TowerOfHanoi game;
		List<Integer> leftDisks;
		List<Integer> middleDisks;
		List<Integer> rightDisks;
		
		game = new TowerOfHanoi(1, Peg.LEFT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(1), leftDisks);
		assertEquals(Arrays.asList(), middleDisks);
		assertEquals(Arrays.asList(), rightDisks);
		
		game = new TowerOfHanoi(4, Peg.MIDDLE);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(), leftDisks);
		assertEquals(Arrays.asList(1, 2, 3, 4), middleDisks);
		assertEquals(Arrays.asList(), rightDisks);
		
		game = new TowerOfHanoi(7, Peg.RIGHT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(), leftDisks);
		assertEquals(Arrays.asList(), middleDisks);
		assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7), rightDisks);
	}

	@Test
	void testGetDisks() {
		TowerOfHanoi game = new TowerOfHanoi(1, Peg.LEFT);
		assertTrue(game.getDisks(Peg.LEFT) instanceof Deque);
		assertTrue(game.getDisks(Peg.MIDDLE) instanceof Deque);
		assertTrue(game.getDisks(Peg.RIGHT) instanceof Deque);
		
		// Check encapsulation
		Deque<Integer> leftStack = game.getDisks(Peg.LEFT);
		Deque<Integer> middleStack = game.getDisks(Peg.MIDDLE);
		Deque<Integer> rightStack = game.getDisks(Peg.RIGHT);
		leftStack.push(2334);
		leftStack.push(101);
		middleStack.push(-12345);
		rightStack.push(01134);
		
		List<Integer> leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		List<Integer> middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		List<Integer> rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(1), leftDisks);
		assertEquals(Arrays.asList(), middleDisks);
		assertEquals(Arrays.asList(), rightDisks);
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
		
		List<Integer> leftDisks;
		List<Integer> middleDisks;
		List<Integer> rightDisks;
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(2, 3), leftDisks);
		assertEquals(Arrays.asList(), middleDisks);
		assertEquals(Arrays.asList(1), rightDisks);
		
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.LEFT_TO_RIGHT));
		
		game.moveDisk(Move.LEFT_TO_MIDDLE);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(3), leftDisks);
		assertEquals(Arrays.asList(2), middleDisks);
		assertEquals(Arrays.asList(1), rightDisks);
		
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.LEFT_TO_MIDDLE));
		
		game.moveDisk(Move.RIGHT_TO_MIDDLE);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(3), leftDisks);
		assertEquals(Arrays.asList(1, 2), middleDisks);
		assertEquals(Arrays.asList(), rightDisks);
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(), leftDisks);
		assertEquals(Arrays.asList(1, 2), middleDisks);
		assertEquals(Arrays.asList(3), rightDisks);
		
		game.moveDisk(Move.MIDDLE_TO_LEFT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(1), leftDisks);
		assertEquals(Arrays.asList(2), middleDisks);
		assertEquals(Arrays.asList(3), rightDisks);
		
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.MIDDLE_TO_LEFT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.RIGHT_TO_LEFT));
		assertThrows(IllegalMoveException.class, 
				() -> game.moveDisk(Move.RIGHT_TO_MIDDLE));
		
		game.moveDisk(Move.MIDDLE_TO_RIGHT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(1), leftDisks);
		assertEquals(Arrays.asList(), middleDisks);
		assertEquals(Arrays.asList(2, 3), rightDisks);
		
		game.moveDisk(Move.LEFT_TO_RIGHT);
		leftDisks = new ArrayList<>(game.getDisks(Peg.LEFT));
		middleDisks = new ArrayList<>(game.getDisks(Peg.MIDDLE));
		rightDisks = new ArrayList<>(game.getDisks(Peg.RIGHT));
		assertEquals(Arrays.asList(), leftDisks);
		assertEquals(Arrays.asList(), middleDisks);
		assertEquals(Arrays.asList(1, 2, 3), rightDisks);
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
