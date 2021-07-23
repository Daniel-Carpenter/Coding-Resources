
public class testClass 
{
	public static void main(String[] args)
	{
		final int SEC_INDEX  = 0;
		final int MIN_INDEX  = 1;
		final int HOUR_INDEX = 2;
		
		Playlist playlist = new Playlist();
		
		
		// Create Overflowing Array for time
			String info5 = "Close to the Edge; Yes; 23";
//			String info6 = "Supper's Ready; Genesis; 30:15";
//			String info7 = "Symphony No. 9; Ludwig van Beethoven; 1:09:00";
			
		// Add Songs
			playlist.addSong(new Song(info5));
//			playlist.addSong(new Song(info6));
//			playlist.addSong(new Song(info7));

		// Print 
			System.out.println(playlist.getTotalTime()[SEC_INDEX]);
			System.out.println(playlist.getTotalTime()[MIN_INDEX]);
			System.out.println(playlist.getTotalTime()[HOUR_INDEX]);
	}
}
