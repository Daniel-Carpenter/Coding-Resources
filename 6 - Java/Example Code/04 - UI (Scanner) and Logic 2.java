import java.util.Scanner;

public class Project_4 {
	public static void main(String[] args) {
	
	Scanner Input = new Scanner (System.in);

// DECLARATIONS
	int countYes = 0;
	String q1;
	String q2;
	String q3;
	String stYes = "yes";
	String stY = "y";
	
	
// QUESTIONS
	System.out.println("I feel tired most of the time.");
		q1 = Input.nextLine();
		if (q1.equalsIgnoreCase(stYes) || q1.equalsIgnoreCase(stY))
		{
			countYes = countYes + 1;
		}

	System.out.println("I try to get away from people as soon as I can.");
		q2 = Input.nextLine();
		if (q2.equalsIgnoreCase(stYes) || q2.equalsIgnoreCase(stY))
		{
			countYes = countYes + 1;
		}
		
	System.out.println("I feel trapped.");
		q3 = Input.nextLine();
	
		if (q3.equalsIgnoreCase(stYes) || q3.equalsIgnoreCase(stY))
		{
			countYes = countYes + 1;
		}
	
		if (countYes == 0)
		{
		System.out.println("You may be more exhausted than stressed out.");
		}
		
		if (countYes == 1)
		{
		System.out.println("You may be beginning to stress out.");
		}
		
		if (countYes == 2)
		{
		System.out.println("You are possibly stressed out.");
		}
		
		if (countYes == 3)
		{
		System.out.println("You are probably stressed out.");
		}
	}
}
