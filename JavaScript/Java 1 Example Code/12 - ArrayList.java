// Daniel Carpenter 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Project_12 
{
	public static void main(String[] args)
			throws FileNotFoundException, IOException 
	{

			final String FILENAME_COMMON = "common-dictionary.txt";
			final String FILENAME_PERSONAL = "personal-dictionary.txt";
			String prompt = "Enter a word or 'quit' to stop: ";
			
			// Read in Common and Personal Dictionary
				ArrayList<String> common = readFile(FILENAME_COMMON);
				ArrayList<String> personal = readFile(FILENAME_PERSONAL);
			
			// Construct a Scanner to read user input from the keyboard.
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println("Spell Checker");
			System.out.println("-------------");
			
			// Perform a priming read to get the first word.
			System.out.print(prompt);
			String word = keyboard.nextLine().toLowerCase();
			
			// Enter the user input loop.
			while (!word.equals("quit")) {
				
				// Check if the word is in either dictionary.
				if (checkSpelling(word, common, personal)) 
				{
					System.out.println("The word is spelled correctly.");
				} 
				
				// If word not Found:
				else 
				{
					System.out.println("The word was not found in the "
						+ "dictionary.");			
					System.out.println("Would you like to add it to your personal "
						+ "dictionary (yes/no)?");
					String response = keyboard.nextLine().toLowerCase();
					
					// Add Word to Personal Dictionary if Yes
					if (response.equals("yes")) 
					{
						personal.add(word);
						Collections.sort(personal);
					}
				}
								
				// Get the next word from the user.
				System.out.println();
				System.out.print(prompt);
				word = keyboard.nextLine().toLowerCase();
			}
			
			keyboard.close();
			writeFile(FILENAME_PERSONAL, personal);
			System.out.println("Goodbye!");
		}
		
		// READ FILE -----------------------------------------------
		public static ArrayList<String> readFile(String fileName) throws FileNotFoundException
		{
			Scanner input = new Scanner(new File(fileName));
			ArrayList<String> commonDictionary = new ArrayList<String>();
			
			while (input.hasNextLine())
			{
				commonDictionary.add(input.nextLine());
			}
			input.close();
			
			return commonDictionary;
		}

		public static boolean checkSpelling(String word, 
											ArrayList<String> common, 
											ArrayList<String> personal) 
		{	
			Collections.sort(personal);
			if (common.contains(word) || personal.contains(word)) 
			{
				return true;
			}
			
			return false;
		}
		
		public static void writeFile(String fileName, ArrayList<String> list)
				throws FileNotFoundException 
		{
			PrintWriter writer = new PrintWriter(fileName);

			for (int idx = 0; idx < list.size(); ++idx) 
			{
				writer.println(list.get(idx));
			}

			// Close the file; otherwise, the contents will be lost.
			writer.close();
		}
}