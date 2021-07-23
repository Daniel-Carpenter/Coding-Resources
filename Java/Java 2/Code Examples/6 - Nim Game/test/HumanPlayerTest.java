import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class HumanPlayerTest {

	@Test
	void testGetUserInput() throws IOException {
		// Temporarily redirect standard out.
		PrintStream console = System.out;
		ByteArrayOutputStream stdout = new ByteArrayOutputStream();
		System.setOut(new PrintStream(stdout));
		
		Scanner input = new Scanner("1");
		HumanPlayer player = new HumanPlayer("name", input);
		assertEquals(1, player.getUserInput("Enter an integer: "));
		stdout.flush();
		assertEquals("Enter an integer: ", stdout.toString());
		stdout.reset();
		
		input = new Scanner("a\n451");
		player = new HumanPlayer("name", input);
		assertEquals(451, player.getUserInput("prompt"));
		stdout.flush();
		assertEquals("promptprompt", stdout.toString());
		stdout.reset();
		
		input = new Scanner("  123abc \n   cba321\n -38  ");
		player = new HumanPlayer("name", input);
		assertEquals(-38, player.getUserInput("Hi! "));
		stdout.flush();
		assertEquals("Hi! Hi! Hi! ", stdout.toString());
		stdout.reset();
		
		// Revert standard out to the console.
		System.setOut(console);
	}

}
