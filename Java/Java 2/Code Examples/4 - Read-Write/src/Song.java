import java.util.Arrays;
import java.lang.Integer;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	private static final String INFO_DELIMITER = "; ";
	private static final String TIME_DELIMITER = ":";
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	
	public Song(String info)
	{
		// Parse String by delimiter
			String[] outputInfo = info.split(INFO_DELIMITER);
		
		// Set object vars to split vars
			this.title		= outputInfo[0];
			this.artist		= outputInfo[1];
			String timeInfo = outputInfo[2];
		
		// Split time data on colon
			String[] stringTime = timeInfo.split(TIME_DELIMITER);
			
			int[] intTime = new int[stringTime.length];
			
			for (int i = 0; i < intTime.length; ++i)
			{
				intTime[i] = Integer.parseInt(stringTime[stringTime.length - i - 1]);
			}
			
			this.time = intTime;
	}
	
	public String toString()
	{
		String hours;
		String mins;
		String secs;
		String timeOut;
				
		final int SEC_INDEX  = 0;
		final int MIN_INDEX  = 1;
		final int HOUR_INDEX = 2;
		
		if (this.time.length == 3)
		{
			hours = Integer.toString(this.time[HOUR_INDEX]);
			
			// Convert format of minutes if less than 10
				if (this.time[MIN_INDEX] < 10)
				{
					// put 0 in front of mins if less than 10
					mins = String.format("%02d", this.time[MIN_INDEX]);
				}
				else
				{
					// leave format the same if greater than 10
					mins = Integer.toString(this.time[MIN_INDEX]);								
				}
			
			// Convert format of Seconds if less than 10
				if (this.time[SEC_INDEX] < 10)
				{
					// put 0 in front of secs if less than 10				
					secs = String.format("%02d", this.time[SEC_INDEX]);
				}
				else
				{
					// leave format the same if greater than 10
					secs = Integer.toString(this.time[SEC_INDEX]);								
				}
				
				timeOut = hours + ":" + mins + ":" + secs;
		}
		// When Song is less than an hour
			else if (this.time.length == 2)
			{
				mins = Integer.toString(this.time[MIN_INDEX]);
				
				if (this.time[SEC_INDEX] < 10)
				{
					// put 0 in front of secs if less than 10				
					secs = String.format("%02d", this.time[SEC_INDEX]);
				}
				else
				{
					// leave format the same if greater than 10
					secs = Integer.toString(this.time[SEC_INDEX]);								
				}
							
				timeOut = mins + ":" + secs;
		}
		else
		{
			if (this.time[SEC_INDEX] < 10)
			{
				// put 0 in front of secs if less than 10				
				secs = String.format("%02d", this.time[SEC_INDEX]);
			}
			else
			{
				// leave format the same if greater than 10
				secs = Integer.toString(this.time[SEC_INDEX]);								
			}			
			timeOut = secs;
		}
		
		String outputSongInfo = getTitle()	+ INFO_DELIMITER +
								getArtist() + INFO_DELIMITER + 
								timeOut;
		return outputSongInfo;
	}
}
