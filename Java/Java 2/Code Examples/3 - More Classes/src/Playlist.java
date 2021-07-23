import java.util.Arrays;

public class Playlist 
{
	// Private Vars ------------------------------------------
	
		private Song[] songs;
		private int numSongs;
		private static int MIN_CAPACITY = 2;
		
	// Playlist Constructor ----------------------------------
		
		public Playlist()
		{
			Song[] songs	= new Song[MIN_CAPACITY];
			this.songs		= songs;
		}
		
	// Getters -----------------------------------------------
		
		public int getCapacity()
		{
			return songs.length;
		}
		
		public int getNumSongs()
		{
			int numSongs = 0;
			
			// Iterate through songs[] to check for numSongs
				for (int i = 0; i < this.songs.length; ++i)
				{
					if (this.songs[i] != null)
					{
						numSongs += 1;
					}
				}
			
			return numSongs;
		}
		
		public Song getSong(int index)
		{
			// Check if out of songs element bounds
				if (index < 0 || index >= songs.length)
				{
					return null;
				}
			
			// if in bounds, return the song
				else
				{
					return songs[index];				
				}
		}

		public void addSong(int index, Song song)
		{
			// Check numSongs vs. capacity of array
				if (this.getCapacity() == this.getNumSongs())
				{
					this.songs	 = Arrays.copyOf(this.songs, 
												 this.getCapacity() * 2);
				}
			
			// Check if index out of bounds
				if (index >= 0 && index < this.songs.length)
				{		
					// Move indexes to the right
						for (int i = this.songs.length - 1; i > index; --i)
						{
							this.songs[i] = this.songs[i - 1];
						}
					
					// Put New song in correct element
						this.songs[index] = song;						
				}	
		}
		
		public void addSong(Song song)
		{
			addSong(this.getNumSongs(), song);
		}
		
		public Song removeSong(int index)
		{
			// Check if index is out of elements bounds
				if (index >= 0 && index < this.songs.length)
				{
					Song songRemoved = this.songs[index];
					
					if (index == this.songs.length - 1)
					{
						this.songs[index] = null;
					}
					
					else 
					{	
						// Move Songs to the left to fill in missing element
							for (int i = index; i < this.songs.length - 1; ++i)
							{	
								this.songs[i] = this.songs[i + 1];
							}
					}		
						
					// If numSongs <= 1/4 of Playlist capacity, halve capacity
						if (this.getNumSongs()		<= this.getCapacity() * 1/4 && 
							this.getCapacity() / 2	>= MIN_CAPACITY)
						{
							this.songs = Arrays.copyOf(this.songs, 
													   this.getCapacity() / 2);
						}
						
					// Return the removed song once done tidying playlist up
						return songRemoved;
				}
				
			// Return null if index is out of bounds
				else
				{
					return null;
				}
		}

		public Song removeSong()
		{
			return removeSong(this.getNumSongs() - 1);
		}
}


