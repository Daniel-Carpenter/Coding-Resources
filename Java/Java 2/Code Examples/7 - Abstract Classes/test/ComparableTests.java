import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class ComparableTests {

	void shuffle(Shape[] s) {
		Random r = new Random();
		for (int i = 0; i < s.length; i++) {
			int j = r.nextInt(s.length);
			Shape t = s[i];
			s[i] = s[j];
			s[j] = t;
		}
	}

	@Test
	void comparableTest() {

		Shape[] shapes = {
				new Square(2),
				new Rectangle(2, 2), new Rectangle(1, 4), 
				new Circle(2), new Circle(1), 
				new RightTriangle(2, 2), new RightTriangle(1, 1)};
		
		Shape[] sorted = {shapes[4], shapes[3], shapes[1], shapes[2], 
				shapes[6], shapes[5], shapes[0]};
		
		Arrays.sort(shapes);
		assertArrayEquals(sorted, shapes);
		
		shuffle(shapes);
		assertFalse(Arrays.equals(sorted, shapes));
		
		Arrays.sort(shapes);
		assertArrayEquals(sorted, shapes);
	}
}
