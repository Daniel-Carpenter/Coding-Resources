import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlaylistTest {
	
	private static final String TITLE_1 = "Am I the Same Girl?";
	private static final String ARTIST_1 = "Barbara Acklin";
	private static final int[] TIME_1 = {56, 2};
	private static final Song SONG_1 = new Song(TITLE_1, ARTIST_1, TIME_1);
	
	private static final String TITLE_2 = "Kissing My Love";
	private static final String ARTIST_2 = "Bill Withers";
	private static final int[] TIME_2 = {49, 3};
	private static final Song SONG_2 = new Song(TITLE_2, ARTIST_2, TIME_2);
	
	private static final String TITLE_3 = "Feelin' Alright?";
	private static final String ARTIST_3 = "Joe Cocker";
	private static final int[] TIME_3 = {10, 4};
	private static final Song SONG_3 = new Song(TITLE_3, ARTIST_3, TIME_3);
	
	private static final String TITLE_4 = "Lean on Me";
	private static final String ARTIST_4 = "Bill Withers";
	private static final int[] TIME_4 = {17, 4};
	private static final Song SONG_4 = new Song(TITLE_4, ARTIST_4, TIME_4);
	
	private static final String TITLE_5 = "Little Wing";
	private static final String ARTIST_5 = "Stevie Ray Vaughan";
	private static final int[] TIME_5 = {49, 6};
	private static final Song SONG_5 = new Song(TITLE_5, ARTIST_5, TIME_5);
	
	@Test
	void testConstructor() {
		Playlist playlist = new Playlist();
		assertEquals(2, playlist.getCapacity());
		assertEquals(0, playlist.getNumSongs());
	}
	
	@Test
	void testInvalidGetSongIndex() {
		Playlist playlist = new Playlist();
		assertNull(playlist.getSong(-1));
		assertNull(playlist.getSong(0));
		assertNull(playlist.getSong(1));
	}
	
	@Test
	void testAdd1() {
		Playlist playlist = new Playlist();
		
		playlist.addSong(SONG_1);
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		playlist.addSong(SONG_2);
		assertEquals(2, playlist.getCapacity());
		assertEquals(2, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertNull(playlist.getSong(2));
	}
	
	@Test
	void testAdd2() {
		Playlist playlist = new Playlist();
		playlist.addSong(SONG_1);
		playlist.addSong(SONG_2);
		
		playlist.addSong(SONG_3);
		assertEquals(4, playlist.getCapacity());
		assertEquals(3, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertNull(playlist.getSong(3));
		
		playlist.addSong(SONG_4);
		assertEquals(4, playlist.getCapacity());
		assertEquals(4, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertTrue(sameSong(SONG_4, playlist.getSong(3)));
		assertNull(playlist.getSong(4));
		
		playlist.addSong(SONG_5);
		assertEquals(8, playlist.getCapacity());
		assertEquals(5, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertTrue(sameSong(SONG_4, playlist.getSong(3)));
		assertTrue(sameSong(SONG_5, playlist.getSong(4)));
		assertNull(playlist.getSong(5));
	}
	
	@Test
	void testAdd3() {
		Playlist playlist = new Playlist();
		
		playlist.addSong(0, SONG_1);
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		playlist.addSong(2, SONG_2);
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		playlist.addSong(-1, SONG_2);
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		playlist.addSong(0, SONG_2);
		assertEquals(2, playlist.getCapacity());
		assertEquals(2, playlist.getNumSongs());
		assertTrue(sameSong(SONG_2, playlist.getSong(0)));
		assertTrue(sameSong(SONG_1, playlist.getSong(1)));
		assertNull(playlist.getSong(2));
		
		playlist.addSong(1, SONG_3);
		assertEquals(4, playlist.getCapacity());
		assertEquals(3, playlist.getNumSongs());
		assertTrue(sameSong(SONG_2, playlist.getSong(0)));
		assertTrue(sameSong(SONG_3, playlist.getSong(1)));
		assertTrue(sameSong(SONG_1, playlist.getSong(2)));
		assertNull(playlist.getSong(3));
		
		playlist.addSong(3, SONG_4);
		assertEquals(4, playlist.getCapacity());
		assertEquals(4, playlist.getNumSongs());
		assertTrue(sameSong(SONG_2, playlist.getSong(0)));
		assertTrue(sameSong(SONG_3, playlist.getSong(1)));
		assertTrue(sameSong(SONG_1, playlist.getSong(2)));
		assertTrue(sameSong(SONG_4, playlist.getSong(3)));
		assertNull(playlist.getSong(4));
		
		playlist.addSong(2, SONG_5);
		assertEquals(8, playlist.getCapacity());
		assertEquals(5, playlist.getNumSongs());
		assertTrue(sameSong(SONG_2, playlist.getSong(0)));
		assertTrue(sameSong(SONG_3, playlist.getSong(1)));
		assertTrue(sameSong(SONG_5, playlist.getSong(2)));
		assertTrue(sameSong(SONG_1, playlist.getSong(3)));
		assertTrue(sameSong(SONG_4, playlist.getSong(4)));
		assertNull(playlist.getSong(5));
	}
	
	@Test
	void testRemove1() {
		Playlist playlist = new Playlist();
		playlist.addSong(SONG_1);
		playlist.addSong(SONG_2);
		
		Song removed = playlist.removeSong();
		assertTrue(sameSong(SONG_2, removed));
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		removed = playlist.removeSong();
		assertTrue(sameSong(SONG_1, removed));
		assertEquals(2, playlist.getCapacity());
		assertEquals(0, playlist.getNumSongs());
		assertNull(playlist.getSong(0));
		
		removed = playlist.removeSong();
		assertNull(removed);
		assertEquals(2, playlist.getCapacity());
		assertEquals(0, playlist.getNumSongs());
		assertNull(playlist.getSong(0));
	}
	
	@Test
	void testRemove2() {
		Playlist playlist = new Playlist();
		playlist.addSong(SONG_1);
		playlist.addSong(SONG_2);
		playlist.addSong(SONG_3);
		playlist.addSong(SONG_4);
		playlist.addSong(SONG_5);
		
		Song removed = playlist.removeSong();
		assertTrue(sameSong(SONG_5, removed));
		assertEquals(8, playlist.getCapacity());
		assertEquals(4, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertTrue(sameSong(SONG_4, playlist.getSong(3)));
		assertNull(playlist.getSong(4));
		
		removed = playlist.removeSong();
		assertTrue(sameSong(SONG_4, removed));
		assertEquals(8, playlist.getCapacity());
		assertEquals(3, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertNull(playlist.getSong(3));
		
		removed = playlist.removeSong();
		assertTrue(sameSong(SONG_3, removed));
		assertEquals(4, playlist.getCapacity());
		assertEquals(2, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertNull(playlist.getSong(2));
		
		removed = playlist.removeSong();
		assertTrue(sameSong(SONG_2, removed));
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		removed = playlist.removeSong();
		assertTrue(sameSong(SONG_1, removed));
		assertEquals(2, playlist.getCapacity());
		assertEquals(0, playlist.getNumSongs());
		assertNull(playlist.getSong(0));
	}
	
	@Test
	void testRemove3() {
		Playlist playlist = new Playlist();
		playlist.addSong(SONG_1);
		playlist.addSong(SONG_2);
		playlist.addSong(SONG_3);
		playlist.addSong(SONG_4);
		playlist.addSong(SONG_5);
		
		Song removed = playlist.removeSong(4);
		assertTrue(sameSong(SONG_5, removed));
		assertEquals(8, playlist.getCapacity());
		assertEquals(4, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertTrue(sameSong(SONG_4, playlist.getSong(3)));
		assertNull(playlist.getSong(4));
		
		removed = playlist.removeSong(4);
		assertNull(removed);
		assertEquals(8, playlist.getCapacity());
		assertEquals(4, playlist.getNumSongs());
		assertTrue(sameSong(SONG_1, playlist.getSong(0)));
		assertTrue(sameSong(SONG_2, playlist.getSong(1)));
		assertTrue(sameSong(SONG_3, playlist.getSong(2)));
		assertTrue(sameSong(SONG_4, playlist.getSong(3)));
		assertNull(playlist.getSong(4));
		
		removed = playlist.removeSong(0);
		assertTrue(sameSong(SONG_1, removed));
		assertEquals(8, playlist.getCapacity());
		assertEquals(3, playlist.getNumSongs());
		assertTrue(sameSong(SONG_2, playlist.getSong(0)));
		assertTrue(sameSong(SONG_3, playlist.getSong(1)));
		assertTrue(sameSong(SONG_4, playlist.getSong(2)));
		assertNull(playlist.getSong(3));
		
		removed = playlist.removeSong(1);
		assertTrue(sameSong(SONG_3, removed));
		assertEquals(4, playlist.getCapacity());
		assertEquals(2, playlist.getNumSongs());
		assertTrue(sameSong(SONG_2, playlist.getSong(0)));
		assertTrue(sameSong(SONG_4, playlist.getSong(1)));
		assertNull(playlist.getSong(2));
		
		removed = playlist.removeSong(0);
		assertTrue(sameSong(SONG_2, removed));
		assertEquals(2, playlist.getCapacity());
		assertEquals(1, playlist.getNumSongs());
		assertTrue(sameSong(SONG_4, playlist.getSong(0)));
		assertNull(playlist.getSong(1));
		
		removed = playlist.removeSong(0);
		assertTrue(sameSong(SONG_4, removed));
		assertEquals(2, playlist.getCapacity());
		assertEquals(0, playlist.getNumSongs());
		assertNull(playlist.getSong(0));
		
		removed = playlist.removeSong(-1);
		assertNull(removed);
		assertEquals(2, playlist.getCapacity());
		assertEquals(0, playlist.getNumSongs());
		assertNull(playlist.getSong(0));
	}

	// Define a helper method that checks if two Songs are the same.
	private static boolean sameSong(Song song1, Song song2) {
		
		// Check that the titles are the same.
		String title1 = song1.getTitle();
		String title2 = song2.getTitle();
		if (!title1.equals(title2)) {
			return false;
		}
		
		// Check that the artists are the same.
		String artist1 = song1.getArtist();
		String artist2 = song2.getArtist();
		if (!artist1.equals(artist2)) {
			return false;
		}
		
		// Check that the times are the same (both length and elements).
		int[] time1 = song1.getTime();	
		int[] time2 = song2.getTime();
		if (time1.length != time2.length) {
			return false;
		}
		for (int idx = 0; idx < time1.length; ++idx) {
			if (time1[idx] != time2[idx]) {
				return false;
			}
		}
		
		// All the fields are the same, so song1 and song2 are the same Song.
		return true;
	}
}
