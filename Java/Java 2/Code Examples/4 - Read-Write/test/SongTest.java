import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongTest {

	@Test
	void testStringConstructor() {
		String info = "It's a Boy; The Who; 38";
		Song song = new Song(info);
		assertEquals("It's a Boy", song.getTitle());
		assertEquals("The Who", song.getArtist());
		assertArrayEquals(new int[] {38}, song.getTime());
		
		info = "Secret World; Peter Gabriel; 7:03";
		song = new Song(info);
		assertEquals("Secret World", song.getTitle());
		assertEquals("Peter Gabriel", song.getArtist());
		assertArrayEquals(new int[] {3, 7}, song.getTime());
		
		info = "Symphony No. 9; Ludwig van Beethoven; 1:09:00";
		song = new Song(info);
		assertEquals("Symphony No. 9", song.getTitle());
		assertEquals("Ludwig van Beethoven", song.getArtist());
		assertArrayEquals(new int[] {0, 9, 1}, song.getTime());
	}
	
	@Test
	void testToString() {
		Song song = new Song("It's a Boy", "The Who", new int[] {38});
		String info = "It's a Boy; The Who; 38";
		assertEquals(info, song.toString());
		
		song = new Song("Secret World", "Peter Gabriel", new int[] {3, 7});
		info = "Secret World; Peter Gabriel; 7:03";
		assertEquals(info, song.toString());
		
		song = new Song("Symphony No. 9", "Ludwig van Beethoven", 
				new int[] {0, 9, 1});
		info = "Symphony No. 9; Ludwig van Beethoven; 1:09:00";
		assertEquals(info, song.toString());
	}
}
