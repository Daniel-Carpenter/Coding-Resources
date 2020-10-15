import java.util.Scanner;

public class Project_3 {
	public static void main(String[] args) 
	{
// Group Members
	// Dax Dyson
	// Daniel Carpenter
			
	Scanner keyboard = new Scanner(System.in);
		
// USER INPUT	
		
		System.out.println("Enter the name of the yarn specified by your pattern.");
			String yarnType1 = keyboard.nextLine(); // Chunky Alpaca
		
		System.out.println("Enter the number of balls of Chunky Alpaca that are required.");
			int numBalls1 = keyboard.nextInt(); // -2
			if (numBalls1 <= 0)
			{
				System.out.println("The number of balls must be positive. Please re-enter.");
				numBalls1 = keyboard.nextInt(); // 2 , don't need to put "int in front of numBalls
			}
		
		System.out.println("Enter the number of yards per ball of " + yarnType1 +".");
			int yardPerBall1 = keyboard.nextInt(); // 50
			if (yardPerBall1 <= 0)
			{
				System.out.println("The number of yards per ball must be positive. Please re-enter.");
				yardPerBall1 = keyboard.nextInt();
			}
			
		System.out.println("Enter the name of the substitute yarn.");
			keyboard.nextLine();
			String yarnType2 = keyboard.nextLine();
		
		System.out.println("Enter the number of yards per ball of " + yarnType2 + "."); // Big and Fluffy
			int yardPerBall2 = keyboard.nextInt(); // 0
			if (yardPerBall2 <= 0)
			{
				System.out.println("The number of yards must be positive. Please re-enter.");
				yardPerBall2 = keyboard.nextInt();
			}
// CALCULATION
			
		// Determine Substitute Ball Amount
			int totalYdsReq = numBalls1 * yardPerBall1;
		
			double numBalls2 = (double) totalYdsReq / yardPerBall2;
		
		// Output Amount
			System.out.println("You should purchase " + ((int) Math.ceil(numBalls2)) + " balls of " + yarnType2 + " instead of " + numBalls1 + " balls of " + yarnType1 + ".");
		
	}
}
