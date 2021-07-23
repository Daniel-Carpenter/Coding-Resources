import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

public class selfTest 
{
	private static final String TITLE_1 = "Am I the Same Girl?";
	private static final String ARTIST_1 = "Barbara Acklin";
	private static final int[] TIME_1 = {56, 2};
	private static final Song SONG_1 = new Song(TITLE_1, ARTIST_1, TIME_1);
	
	
	public static void main(String[] args)
	{
		Playlist playlist = new Playlist();
		System.out.println("capacity: " + playlist.getCapacity());
		System.out.println("numSongs: " + playlist.getNumSongs());
		
		// add song3
		playlist.addSong(0, SONG_1);
			System.out.println("new cap: " + playlist.getCapacity());
			System.out.println("new num: " + playlist.getNumSongs());
		
		
			
		int[] array = {10, 15, 20, 30, 50000};
		
		int newValue = 1000;
		int elementSpot = 0;
		
		for (int i = array.length - 1; i > 0; --i)
		{
			// Temp var for next element
				
			// Move elements 1 to the right
				array[i] = array[i - 1]; 
				
		}
				
		// insert element in blank spot
		array[elementSpot] = newValue;
		
		System.out.println("Array = " + array[0]);
		
		
		int index = 0;
		int[] songs = {1 , 2};
		int song = 100;
		int numSongs = 0;
		
		// Iterate through songs[] to check for numSongs
			for (int i = 0; i < songs.length; ++i)
			{
				if (songs[i] > 0 )
				{
					numSongs += 1;
				}
			}
		
		
		
			// Check if index out of bounds
				if (index >= 0 && index < songs.length)
				{
					// Check numSongs vs. capacity of array
						if (songs.length == numSongs)
						{
							songs	 = Arrays.copyOf(songs,
													 songs.length * 2);
						}
						
					// Move indexes to the right
						for (int i = songs.length - 1; i > index; --i)
						{
							songs[i] = songs[i - 1];
						}
					
					// Put New song in correct element
						songs[index] = song;
				}	
				System.out.println("numsongs = " + numSongs);
				System.out.println(songs.length);
				System.out.println(songs[0] + " " +  songs[1] + " " + songs[2]);
			
				
				index = 1;
				
		// Check if index is out of elements bounds
		if (index >= 0 && index < songs.length)
		{
			// Move Songs to the left to fill in missing element
				for (int i = index; i < songs.length - 1; ++i)
				{	
					songs[i] = songs[i + 1];
				}
		}			
		
		System.out.println(songs[0] + " " +  songs[1] + " " + songs[2]);
		
		// Iterate through songs[] to check for numSongs
		for (int i = 0; i < songs.length; ++i)
		{
			if (songs[i] > 0 )
			{
				numSongs += 1;
			}
		}
		
		System.out.println("current numSongs: " + numSongs);
		System.out.println("1/4 cap: " + songs.length * 1/4); 
		System.out.println("current capacity: " +  songs.length);
	}
}
