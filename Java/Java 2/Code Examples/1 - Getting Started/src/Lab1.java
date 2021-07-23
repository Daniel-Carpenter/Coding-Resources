import java.util.ArrayList;
import java.util.Collections;


public class Lab1 
{
//	public static void main (String[] args)
//	{
//		int num1 		= 10;
//		int num2 		= 0;
//		int num3		= 2;
//		double doubNum 	= 12.33;
//		String word = "emphasized!";
//		int[] array = {num1, num2, num3};
//		
//		System.out.println("Sum = " + sum(num1, num2));
//		System.out.println("Cast = " + castToInt(doubNum));
//		System.out.println("Emph = " + emphasize(word));
//		System.out.println("is " + num1 + " odd? " + isOdd(num1));
//		System.out.println("is " + num2 + " odd? " + isOdd(num2));
//		System.out.println("Max = " + findMax(num1, num2, num3));
//		System.out.println("Array Sum = " + sum(array));
//		System.out.println("Array Sum Odd = " + sumOdd(array));
//		System.out.println("Max in Array = " + findMax(array));
//	}
	
	// -----------------------------------------------------------------
	
	
	public static int sum (int num1, int num2) // if called by other class, then static
	{
		// Aggregate 2 numbers
		int output = num1 + num2;
		
		return output;
	}
	
	public static int castToInt(double num)
	{
		// Cast double to int
		int output = (int) num;
		return output;
	}
	
	public static String emphasize(String word)
	{
		// Add '***' around String
		String output = "***" + word + "***";
		
		return output;
	}
	
	public static boolean isOdd(int num)
	{
		// Test if num is odd
		boolean output;
		
		if (num % 2 == 0)
		{
			output = false;
		}
		else
		{
			output = true;
		}
		
		return output;
	}
	
	public static int findMax(int num1, int num2, int num3)
	{
		// Create Array List
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		
		// Add Nums to Array
		intArr.add(num1);
		intArr.add(num2);
		intArr.add(num3);
		
		// Sort Array
		Collections.sort(intArr);
		
		int output = intArr.get(2);
		return output;
	}
	
	public static int sum(int[] array)
	{
		// initialize output
		int output = 0;
		
		// Add nums in array
		for (int i = 0; i < array.length; ++i)
		{
			output += array[i];
		}
		return output;
	}
	
	public static int sumOdd(int[] array)
	{
		// initialize output
		int output = 0;
		
		// Add nums in array
		for (int i = 0; i < array.length; ++i)
		{
			if (array[i] % 2 != 0)
			{
				output += array[i];				
			}
			else
			{
				output += 0;
			}
		}
		return output;
	}
	
	public static int findMax(int[] array)
	{
		// inititalize output
		int output = array[0];
		
		for (int i = 1; i < array.length; ++i)
		{
			// Get max value in array
			if (array[i] > output)
			{
				// if next element > than current, choose next element
				output = array[i];
			}			
		}
		
		return output;
	}
	
}





