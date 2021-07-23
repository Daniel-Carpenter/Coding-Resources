import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Test;

class ComparatorTests {

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
	void comparatorTest() {

		Shape[] shapes = {
				new Circle(1), new Circle(2), 
				new Rectangle(2, 2), new Rectangle(1, 4),
				new RightTriangle(1, 1), new RightTriangle(2, 2), 
				new Square(2)};

		Shape[] copy = Arrays.copyOf(shapes, shapes.length);
		shuffle(copy);
		assertFalse(Arrays.equals(shapes, copy));

		ShapeIDComparator comparator = new ShapeIDComparator();
		Arrays.sort(copy, comparator);
		assertArrayEquals(shapes, copy);
	}
}
