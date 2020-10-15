// Dax Dyson
// Daniel Carpenter

import java.util.Scanner;

public class Project_5 {
	public static void main(String[] args) {
			
	// DECLARATIONS
		Scanner input = new Scanner(System.in);
		
		int SENTINAL = -1;
		int priorDial = 3;
		int inputDial = priorDial;
		int change = 0;
		
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		
		int posCount = 0; // Count of positive changes
		int negCount = 0;
		int noCount  = 0; // Count of no changes
		
		String outChange = null; // Used for positive, negative, etc. change
	
		
	// BEGIN SIMULATOR
		System.out.println("Response Dial Simulator");
		System.out.println("-----------------------");
		System.out.println("Initial setting: " + inputDial);
		System.out.println("Enter the next setting (1-5) or -1 to stop.");
		
		
	// LOOP
		while (inputDial != SENTINAL && inputDial >= 1 && inputDial <= 5)
			{
					inputDial = input.nextInt();
					change = (inputDial - priorDial);
					

				// DIAL CHANGES					
					if (inputDial != SENTINAL)
					{
						if (change < 0)
						{
							outChange = "Negative";
							negCount = negCount + 1;
						}
						else if (change == 0)
						{
							outChange = "No";
							noCount = noCount + 1;
						}
						else if (change > 0)
						{
							outChange = "Positive";
							posCount = posCount + 1;
						}
						
							System.out.println(outChange + " change: " + priorDial + " to " + inputDial);
							System.out.println("Current setting: " + inputDial);
							System.out.println("Enter the next setting (1-5) or -1 to stop.");
							priorDial = inputDial;
					}

							
							
						// UPDATE COUNTS
							if (inputDial == 1)
							{
							count1 = count1 + 1;
							}
							else if (inputDial == 2)
							{
							count2 = count2 + 1;
							}
							else if (inputDial == 3)
							{
							count3 = count3 + 1;
							}
							else if (inputDial == 4)
							{
							count4 = count4 + 1;
							}
							else if (inputDial == 5)
							{
							count5 = count5 + 1;
							}
							else
							{
							}
				}
				
		
				// RESPONSE SUMMARY
					System.out.println("Response Summary");
					System.out.println("----------------");
					
					System.out.println("1 was chosen " + count1 + " time(s).");
					System.out.println("2 was chosen " + count2 + " time(s).");
					System.out.println("3 was chosen " + count3 + " time(s).");
					System.out.println("4 was chosen " + count4 + " time(s).");
					System.out.println("5 was chosen " + count5 + " time(s).");
					System.out.println("");
					System.out.println("Positive changes: " + posCount);
					System.out.println("Negative changes: " + negCount);
					System.out.println("No changes: " 		+ noCount);

	}
}
