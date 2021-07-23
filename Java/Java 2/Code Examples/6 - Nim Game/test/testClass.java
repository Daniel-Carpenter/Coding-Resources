import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class testClass 
{
	public static void main (String[] args) throws InvalidInitPilesException
	{
		Scanner keyboard = new Scanner(System.in);
		HumanPlayer humanPlayer = new HumanPlayer("name", new Scanner("a\n451"));
		humanPlayer.getUserInput("prompt");
		System.out.println(keyboard.toString());
	}
}
