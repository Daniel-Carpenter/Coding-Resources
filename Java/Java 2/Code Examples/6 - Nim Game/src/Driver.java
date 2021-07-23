import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws InvalidInitPilesException {
		Scanner keyboard = new Scanner(System.in);
		Player player1 = new HumanPlayer("human", keyboard);
		Player player2 = new RandomPlayer("RandomBot");
		Nim game = new Nim(player1, player2);
		game.play();
		keyboard.close();
	}
}
