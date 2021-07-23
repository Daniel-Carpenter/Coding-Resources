import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** This project was inspired by word jumbles. The program randomly chooses a 
 * word from a dictionary, scrambles the letters, and lets the user guess the 
 * unscrambled word. After every incorrect guess, part of the unscrambled word 
 * is shown. The number of points earned for a correct guess decreases with the 
 * number of guesses.
 * 
 * @author Deborah A. Trytten
 * @version 1.1
 * Updated to v1.1 by James Dizikes on Sept 30, 2019.
 */
public class Project_6 
{
	// Note: Any method that opens a file must be able to throw the file not 
	// found exception.
	
	public static String chooseRandomWord() throws FileNotFoundException {
		// Construct a Scanner and connect it to the text file that 
		// contains the words.
		Scanner dictionary = new Scanner(new File("dictionary.txt"));

		// The first line of the text file contains an integer that 
		// specifies the number of words in the file. Read this number and 
		// skip the following newline character.
		int numWords = dictionary.nextInt();
		dictionary.nextLine();
		
		// The remaining lines of the file each contain a single word. 
		// Choose a random number of lines to skip.
		int numSkip = (int) (Math.random() * numWords);

		// Skip the lines and read the randomly chosen word.
		for (int i = 0; i < numSkip; ++i)
		{
			dictionary.nextLine();
		}
		String word = dictionary.nextLine();
		
		// Close the file now that the word has been chosen.
		dictionary.close();
		return word;	
	}
	
	public static String lettersScrambled(String word) {
		// Construct StringBuilder objects used to scramble the word. The 
		// StringBuilder class is like String, but it has different methods 
		// like delete and append that are useful here.
		StringBuilder tempWord = new StringBuilder(word);
		StringBuilder scrambledTempWord = new StringBuilder();
		
		// Repeatedly choose a random letter to remove from tempWord.
		// Append these letters to scrambledTempWord to form the scrambled 
		// word.
		while (tempWord.length() > 0)
		{
			int letterIndex = (int) (Math.random() * tempWord.length());
			char letter = tempWord.charAt(letterIndex);
			tempWord.deleteCharAt(letterIndex);
			scrambledTempWord.append(letter);
		}
		// Create a regular String copy of the scrambled word.
		String scrambledWord = scrambledTempWord.toString();
	
		return scrambledWord;
	}
	
	public static int numAttempts(String word, String scrambledWord, Scanner keyboard) {
		// Let the user guess the word. The number of allowed guesses is 
		// one less than the number of letters.
		int numGuesses;
		for (numGuesses = 1; numGuesses <= word.length() - 1; ++numGuesses)
		{
			System.out.println("Scrambled word: " + scrambledWord);
			
			// Print a hint after the first guess.
			if (numGuesses > 1) {
				System.out.println("          Hint: " 
						+ word.substring(0, numGuesses - 1));
			}
			
			// Prompt the user and print the number of remaining guesses.
			System.out.println("What is your guess? (" 
					+ (word.length() - numGuesses) + " guesses left)");
			
			// Get the guess and exit the loop if it is correct.
			String guess = keyboard.nextLine();
			if (guess.equalsIgnoreCase(word)) {
				break;
			}
		}
		return numGuesses;
	}
	
	public static String winLose(int numGuesses, String word, int pointsEarned, int wordPoints) {
		// If the user earned 0 points, show them the correct word. 
		// Otherwise, tell them how many points they won.
		if (pointsEarned == 0) {
			String lose = ("Sorry, the scrambled word was \"" + word 
			+ "\".");
			return lose;
		}
		else {
			String win = ("Congratulations! You earned " 
			+ pointsEarned + " out of " + wordPoints 
			+ " possible points.");
			return win;
		}
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		// Construct a Scanner object to read guesses from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		// The game loop runs until this variable is no longer "yes".
		String continuePlaying = "yes";
		
		// Initialize variables to store the user's score and the total 
		// possible points from all the words guessed so far.
		int score = 0;
		int pointsPossible = 0;
		
		System.out.println("Welcome to Java Word Scramble!");
		System.out.println("------------------------------");
		
		// The game loop begins here.
		while (continuePlaying.equalsIgnoreCase("yes"))
		{
			// Print a newline character to separate the output from the 
			// previous game.
			System.out.println();
			
			String result = chooseRandomWord();
			String scrambledEggs = lettersScrambled(result);
			int numberGuesses = numAttempts(result, scrambledEggs, keyboard);
			
			
			// Calculate the number of points the word is worth and the number 
			// earned by the user.
			int wordPoints = result.length() - 1;
			int pointsEarned = result.length() - numberGuesses;
			
			String finalResult = winLose(numberGuesses, result, pointsEarned, wordPoints);
			System.out.println(finalResult);
			
			// Update and report the current score and total possible points.
			score += pointsEarned;
			pointsPossible += wordPoints;
			System.out.println("Score: " + score);
			System.out.println("Max possible points: " + pointsPossible);
		
			// Ask the player if they want to continue playing.
			System.out.println("Do you want to play again (yes/no)?");
			continuePlaying = keyboard.nextLine();
		}
		
		System.out.println("Thanks for playing!");
		
		keyboard.close();
	}
}