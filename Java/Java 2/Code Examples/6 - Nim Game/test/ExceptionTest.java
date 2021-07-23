import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void testGetMessage() {
		String moveInfo = "That move is not allowed!";
		Exception exception = new IllegalMoveException(moveInfo);
		assertEquals(moveInfo, exception.getMessage());
		
		moveInfo = "Pile 1 is empty.";
		exception = new IllegalMoveException(moveInfo);
		assertEquals(moveInfo, exception.getMessage());
		
		moveInfo = "Object number greater than pile size: 3 > 2";
		exception = new IllegalMoveException(moveInfo);
		assertEquals(moveInfo, exception.getMessage());
	}
}
