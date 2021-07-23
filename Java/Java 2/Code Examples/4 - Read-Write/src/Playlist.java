import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Playlist 
{
	private ArrayList<Song> songs;
	
	// Make indexes for elements of songs
	private final int SEC_INDEX  = 0;
	private final int MIN_INDEX  = 1;
	private final int HOUR_INDEX = 2;
	
	public Playlist() {
		songs = new ArrayList<Song>();
	}
	
	public int getNumSongs() {
		return songs.size();
	}
	
	public Song getSong(int index) 
	{
		if (index < 0 || index >= getNumSongs()) 
		{
			return null;
		}
		return songs.get(index);
	}

	public void addSong(Song song) {
		addSong(getNumSongs(), song);
	}

	public void addSong(int index, Song song) 
	{
		if (index < 0 || index > getNumSongs()) 
		{
			return;
		}
		songs.add(index, song);
	}
	
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	
	public Song removeSong(int index) 
	{
		if (index < 0 || index >= getNumSongs()) 
		{
			return null;
		}
		return songs.remove(index);
	}
	
	
// New Code ======================================================
	
	public void addSongs(String filename) throws IOException
	{
		// Create reader
			BufferedReader reader = new BufferedReader(new FileReader(filename));
		
		// Read first line of .txt file
			String line = reader.readLine();
		
		// Read lines until meets last line of .txt file (null)
			while (line != null)
			{
				addSong(new Song(line));
				line = reader.readLine();
			}
			
		reader.close();
	}
	
	public Playlist(String filename) throws IOException
	{
		songs = new ArrayList<Song>();
		addSongs(filename);
	}
		
	public String toString()
	{
		
		String output = "";
		
		if (this.getNumSongs() > 0)
		{
			StringBuilder sb = new StringBuilder(this.getSong(0).toString());		
			
			for (int i = 1; i < this.getNumSongs(); ++i)
			{
				sb.append("\n" + this.getSong(i).toString());
			}
			output = sb.toString();		
		}
		
		return output;
	}
	
	public void saveSongs(String filename) throws IOException
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
		writer.write(this.toString());
		writer.close();
	}

	public Song getLongestSong()
	{
		// If playlist is empty return null
			if (this.getNumSongs() == 0)
			{
				return null;
			}
			
		// return longest song
			else
			{
				int second	= 0;
				int minute	= 0;
				int hour	= 0;
				int totalTime = 0;

				Song longSong = null;
				
				for (int i = 0; i < this.getNumSongs(); ++i)
				{
					if (this.getSong(i).getTime().length == 3)
					{
						int temp = totalTime;
						second	= this.getSong(i).getTime()[0];
						minute	= this.getSong(i).getTime()[1] * 100;
						hour 	= this.getSong(i).getTime()[2] * 10000;
						
						totalTime = second + minute + hour;
						
						if (temp > totalTime)
						{
							totalTime = temp;
						}
						else
						{
							longSong = this.getSong(i);
						}
					}
					
					// Less than an Hour
					else if (this.getSong(i).getTime().length == 2)
					{
						int temp = totalTime;
						second	= this.getSong(i).getTime()[0];
						minute	= this.getSong(i).getTime()[1] * 100;
						
						totalTime = second + minute;
						
						if (temp > totalTime)
						{
							totalTime = temp;
						}
						else
						{
							longSong = this.getSong(i);
						}
					}
					
					// Less than a Minute
					else
					{
						int temp = totalTime;
						second	= this.getSong(i).getTime()[0];
						
						totalTime = second;
						
						if (temp > totalTime)
						{
							totalTime = temp;
						}
						else
						{
							longSong = this.getSong(i);
						}
					}
				}
				return longSong;
			}
	}

	public int[] calcTimeArray(int[] originalArray)
	{			
		// Make elements in 60 min form -------------------------------------------------
		
			// Make Array of Length 3
				int[] overFlowingArray = Arrays.copyOf(originalArray, 3);	
			
			// Calculate Time in 60 mm/ss format
				int newSec 	= overFlowingArray[SEC_INDEX]	% 60;
				int newMin 	= overFlowingArray[MIN_INDEX]	% 60 + (overFlowingArray[SEC_INDEX] - newSec) / 60;
				int newHour = overFlowingArray[HOUR_INDEX] + (int) Math.ceil(((double) overFlowingArray[MIN_INDEX] - (double) newMin) / 60);
			
			// Set new time
				overFlowingArray[SEC_INDEX]	= newSec; 	// Seconds															
				overFlowingArray[MIN_INDEX]	= newMin;	// Minutes 
				overFlowingArray[HOUR_INDEX] = newHour; // Hours															

			
				
		// Perfect Sized Array Output -----------------------------------------------------------------	
			
			// Initialize Array
				int[] timeOut = new int[3];
				
			// Create perfect array for num time elements > 0
				
				if (overFlowingArray[HOUR_INDEX] > 0)
				{
					timeOut = Arrays.copyOf(overFlowingArray, 3);
				}
				
				else if (overFlowingArray[MIN_INDEX] > 0)
				{
					timeOut = Arrays.copyOf(overFlowingArray, 2);
				}
				
				else
				{
					timeOut = Arrays.copyOf(overFlowingArray, 1);					
				}
				
		return timeOut;
	}
 	
	public int[] getTotalTime()
	{
		// If playlist is empty return null
			if (this.getNumSongs() == 0)
			{
				int[] time = {0};
				return time;
			}
			
		// return longest song
			else
			{
				
				// Loop through to add total time vars -----------------------------------------------------

					// Create base array to hold sec, min, hours
						int[] time = new int[3];
				
					// initialize song index to first element
						int SONG_INDEX = 0;
					
					for (SONG_INDEX = 0; SONG_INDEX < this.getNumSongs(); ++SONG_INDEX)
					{
						// Greater than or equal to an hour
							if (this.getSong(SONG_INDEX).getTime().length == 3)
							{
								time[SEC_INDEX]		+= this.getSong(SONG_INDEX).getTime()[SEC_INDEX];
								time[MIN_INDEX]		+= this.getSong(SONG_INDEX).getTime()[MIN_INDEX];
								time[HOUR_INDEX] 	+= this.getSong(SONG_INDEX).getTime()[HOUR_INDEX];
							}
							
						// Less than an Hour
							else if (this.getSong(SONG_INDEX).getTime().length == 2)
							{
								time[SEC_INDEX]		+= this.getSong(SONG_INDEX).getTime()[SEC_INDEX];
								time[MIN_INDEX]		+= this.getSong(SONG_INDEX).getTime()[MIN_INDEX];
							}
						
						// Less than a Minute
							else if (this.getSong(SONG_INDEX).getTime().length == 1)
							{
								time[SEC_INDEX]		+= this.getSong(SONG_INDEX).getTime()[SEC_INDEX];
							}
					}
								
					// Call calcTimeArray() to calculate the array in ss/mm/h format	
						int[] timeOut = this.calcTimeArray(time);
					
				return timeOut;
				
			}
	}

	public String getFavoriteArtist()
	{
		// If empty return null
			if (this.getNumSongs() == 0)
			{
				return null;
			}
			
			else
			{
				
				ArrayList<String> fullArtists = new ArrayList<String>();
				ArrayList<String> distinctArtists = new ArrayList<String>();
				
				// Make array of artists (not uniquw)
					for (int songNum = 0; songNum < songs.size(); ++songNum)
					{
						fullArtists.add(this.getSong(songNum).getArtist());
					}
				
					distinctArtists = (ArrayList<String>) fullArtists.stream().distinct().collect(Collectors.toList());
					
				// Count of Artists
					ArrayList<Integer> artistCounts = new ArrayList<Integer>();
					
				// Make Frequency Table
					for (int artistNum = 0; artistNum < distinctArtists.size(); ++artistNum)
					{
						int count = 0;
						
						for (int fullArtElem = 0; fullArtElem < fullArtists.size(); ++fullArtElem)
						{
							
							if (distinctArtists.get(artistNum).equals(fullArtists.get(fullArtElem)))
							{									
								count += 1;
							}
						}
						
						artistCounts.add(artistNum, count);
					}	
					
				// Get Max element
					int maxElement	= 0;
					
					for (int i = 0; i < artistCounts.size(); ++i)
					{
						
						// See if temp is bigger than the max element
						if (artistCounts.get(i) > artistCounts.get(maxElement))
						{
							maxElement = i;		
						}
					}
					
				
				return distinctArtists.get(maxElement); // CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE CHANGE
			}
	}
}





