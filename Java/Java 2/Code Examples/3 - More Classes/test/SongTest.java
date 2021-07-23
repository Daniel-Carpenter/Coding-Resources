import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongTest {

	@Test
	void testGetters() {
		String title = "The Sound of Muzak";
		String artist = "Porcupine Tree";
		int[] time = {59, 4};
		Song song = new Song(title, artist, time);
		assertEquals(title, song.getTitle());
		assertEquals(artist, song.getArtist());
		assertArrayEquals(time, song.getTime());
		
		title = "Her Majesty";
		artist = "The Beatles";
		time = new int[] {23};
		song = new Song(title, artist, time);
		assertEquals(title, song.getTitle());
		assertEquals(artist, song.getArtist());
		assertArrayEquals(time, song.getTime());
	}
	
	@Test
	void testImmutability() {
		String title = "Ten Years Gone";
		String artist = "Led Zeppelin";
		int seconds = 55;
		int minutes = 6;
		int[] time = {seconds, minutes};
		Song song = new Song(title, artist, time);
		
		time[0] = -1;
		time[1] = -1;
		assertEquals(seconds, song.getTime()[0]);
		assertEquals(minutes, song.getTime()[1]);
		
		int[] returnedTime = song.getTime();
		returnedTime[0] = -1;
		returnedTime[1] = -1;
		assertEquals(seconds, song.getTime()[0]);
		assertEquals(minutes, song.getTime()[1]);
	}
}
