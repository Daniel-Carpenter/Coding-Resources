import java.util.Arrays;

public class Song 
{
	// Private Vars ----------------------------------------------------
	
		private String title;
		private String artist;
		private int[] time = new int[2];
		
		
	// Song Constructor ------------------------------------------------
		
		public Song(String title, 
					String artist, 
					int[] time)
		{
			// Create copy of Existing Array
				int[] copyTime = Arrays.copyOf(time, time.length);
				
			// Assign Parameters to Array
				this.title	= title;
				this.artist	= artist;
				this.time	= copyTime;
		}
		
		
	// Getters ---------------------------------------------------------
		
		public String getTitle() {
			return title;
		}
		public String getArtist() {
			return artist;
		}
		public int[] getTime() 
		{	
			// Create copy of Existing Array
				int[] copyTime = Arrays.copyOf(time, time.length);
			
			return copyTime;
		} 
}