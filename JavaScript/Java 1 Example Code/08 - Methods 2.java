import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Project_8
{
	public static void main(String[] args) throws FileNotFoundException
	{
		String mostWatched = findMostFrequent((readFile("movie-data.txt")));
		
		
		System.out.println("Most popular movie: "+ mostWatched);
	}

	public static String[] readFile(String filename) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(filename)); 
		int count = 0;
		while (file.hasNextLine()){
			++count;
			file.nextLine();
		}
		String[] movieTitles = new String[count];
		
		file = new Scanner (new File(filename));
	
		for (count = 0; count < movieTitles.length; ++count) {
			String movie = file.nextLine();
			movieTitles[count] = movie;
			
		}
		return movieTitles;
	
	}

	public static void lowercase(String[] array)
	{
		
		for (int i = 0; i < array.length; ++i ) {
			array[i] = array[i].toLowerCase();
		}

	}

	public static String findMostFrequent(String[] array)
	{
	lowercase(array);
	Arrays.sort(array);
	int count = 0;
	int max = 0;
	String mostFrequent = " ";

	int i = 1;
	 for (i =1; i < array.length; ++i)
	   if ((array[i-1]).equals(array[i])) {
	   ++count;
	     if (count > max) {
	     max = count; 
	     mostFrequent = array[i];
	     }
	}
	else if (!(array[i-1].equals(array[i]))) {
	     count = 1;
	}
	return mostFrequent;

	}
}