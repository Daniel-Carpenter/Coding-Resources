import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NimTest {

	@Test
	void testTakeTurn() throws InvalidInitPilesException {
		int[][] moves = {{2, 3}, {0, 3}};
		MockPlayer p1 = new MockPlayer("Player 1", moves);
		MockPlayer p2 = new MockPlayer("Player 2", null);
		Nim game = new Nim(p1, p2, new int[] {3, 5, 4});
		
		game.takeTurn();
		assertArrayEquals(new int[] {3, 5, 1}, game.getPileSizes());
		assertNull(p1.getIllegalMoveInfo());
		assertNull(p1.getOpponentName());
		assertNull(p1.getOpponentMove());
		assertNull(p2.getIllegalMoveInfo());
		assertEquals("Player 1", p2.getOpponentName());
		assertArrayEquals(new int[] {2, 3}, p2.getOpponentMove());
		
		game.takeTurn();
		assertArrayEquals(new int[] {0, 5, 1}, game.getPileSizes());
		assertNull(p1.getIllegalMoveInfo());
		assertNull(p1.getOpponentName());
		assertNull(p1.getOpponentMove());
		assertNull(p2.getIllegalMoveInfo());
		assertEquals("Player 1", p2.getOpponentName());
		assertArrayEquals(new int[] {0, 3}, p2.getOpponentMove());
		
		moves = new int[][] {{1, 0}, {0, 1}};
		p1 = new MockPlayer("Player 1", moves);
		p2 = new MockPlayer("Player 2", null);
		game = new Nim(p1, p2, new int[] {2, 1});
		
		game.takeTurn();
		assertArrayEquals(new int[] {1, 1}, game.getPileSizes());
		String moveInfo = "Nonpositive object number: 0";
		assertEquals(moveInfo, p1.getIllegalMoveInfo());
		assertNull(p1.getOpponentName());
		assertNull(p1.getOpponentMove());
		assertNull(p2.getIllegalMoveInfo());
		assertEquals("Player 1", p2.getOpponentName());
		assertArrayEquals(new int[] {0, 1}, p2.getOpponentMove());
	}
}
