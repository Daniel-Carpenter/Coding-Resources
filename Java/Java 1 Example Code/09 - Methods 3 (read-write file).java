import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

// Daniel Carpenter
// Dax Dyson

public class Project_9 
{
	public static void main(String[] args) throws IOException
	{
		Scanner input = new Scanner(System.in);
		
		// COMMON DICTIONARY -------------------------------------------------------------------------------------------
		String[] commonDictionary = readFilePerfect("common-dictionary.txt");
		
		// PERSONAL DICTIONARY -----------------------------------------------------------------------------------------
		int personalDictionarySize = 100;
		String[] oversizeArray = new String[personalDictionarySize];		
		String[] personalDictionary = readFileOversize("personal-dictionary.txt", oversizeArray);
		
		
		// START SPELL CHECKER -----------------------------------------------------------------------------------------
		System.out.println("Spell Checker");
		System.out.println("-------------");
		
		String word = "";
		
		while (!(word.equals("quit")))
		{
			System.out.println("Enter a word or 'quit' to stop:");
			word = input.nextLine();
			
			boolean isCorrectlySpelled = spellCheck(word, commonDictionary, personalDictionary, personalDictionarySize); 
			
			if (word.equals("quit"))
			{
				
			}
			
			else if (isCorrectlySpelled)
			{
				System.out.println("The word is spelled correctly.");
			}
			else 
			{
				System.out.println("The word was not found in the dictionary."); 
				System.out.println("Would you like to add it to your personal dictionary (yes/no)?");
				
				String addToPersonal = input.nextLine();
				addToPersonal.toLowerCase();
				if (addToPersonal == "yes")
				{
					personalDictionary[personalDictionarySize] = word;
					Arrays.sort(personalDictionary);
					++personalDictionarySize;
				}	
			}
		}
		
		System.out.println("Goodbye!");
		
		// WRITE FILE -----------------------------------------------------------------------------------------
		writeFile("personal-dictionary.txt", personalDictionary);
		System.out.println(Arrays.toString(personalDictionary)); // DELETE LATER
	
	}

// ----------------------MAIN METHOD ABOVE----------------------
	
	// READ FILE ---------------------------------------------------
	
	public static String[] readFilePerfect(String fileName) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(fileName)); 
		int count = 0;
		while (file.hasNextLine())
		{
			++count;
			file.nextLine();
		}
		String[] dictionary = new String[count];
		
		file = new Scanner (new File(fileName));
	
		for (count = 0; count < dictionary.length; ++count) 
		{
			String word = file.nextLine();
			dictionary[count] = word;
			
		}
		file.close();
		return dictionary;
	}

	// READ OVERSIZE FILE ---------------------------------------
	public static String[] readFileOversize(String fileName, String[] array) throws FileNotFoundException, IOException
	{
		File file = new File(fileName); 
		file.createNewFile();
		Scanner input = new Scanner(file);
		
		int count = 0;
		while (input.hasNextLine())
		{
			String newWord = input.nextLine();
			array[count] = newWord;
			++count;
			input.nextLine();
		}
		input.close();
		return array;
	}
	

	// CHECK SPELLING --------------------------------------------
	public static boolean spellCheck(String word, String[] globalDictionary, String[] personalDictionary, int personalDictionarySize)
	{
		boolean wordEquals;
		boolean personalUsed = false;
		
		int x = Arrays.binarySearch(globalDictionary, 0, globalDictionary.length, word);		
		int y = -1;
		
		// Test to see if personal dictionary used yet - if not, then only search in common dictionary
		for ( int i = 0; i < personalDictionary.length; ++i)
		{
			if (personalDictionary[i] != null)
			{
				personalUsed = true;
			}
			else
			{
				personalUsed = false;
			}
		}
		if (personalUsed == true)
		{
			y = Arrays.binarySearch(globalDictionary, 0, globalDictionary.length, word);		
		}
		
		// Spell check in either dictionary
		if (x >= 0 || y >= 0)
		{
			wordEquals = true;
		}
		else
		{
			wordEquals = false;
		}
		
		return wordEquals;		
	}
	
	
	// WRITE FILE ------------------------------------------------
	public static void writeFile(String fileName, String[] array) throws FileNotFoundException
	{
		PrintWriter writer = new PrintWriter(new File(fileName));
		
		for (int i = 0; i < array.length; ++i)
		{
			writer.println(array[i]);
		}
		writer.close();
	}
}
