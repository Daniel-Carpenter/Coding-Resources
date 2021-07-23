import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDComparatorTests {

	@Test
	void idComparatorTests() {
		Square s1 = new Square(1);
		Square s2 = new Square(2);
		Rectangle r = new Rectangle(1, 2);
		ShapeIDComparator comparator = new ShapeIDComparator();

		assertTrue(comparator.compare(s1, s1) == 0);
		assertTrue(comparator.compare(s2, s2) == 0);
		assertTrue(comparator.compare(r, r) == 0);

		assertTrue(comparator.compare(s1, s2) < 0);
		assertTrue(comparator.compare(s2, s1) > 0);

		assertTrue(comparator.compare(s1, r) < 0);
		assertTrue(comparator.compare(r, s1) > 0);

		assertTrue(comparator.compare(s2, r) < 0);
		assertTrue(comparator.compare(r, s2) > 0);
	}
}
