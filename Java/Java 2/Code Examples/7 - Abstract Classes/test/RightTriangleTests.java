import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RightTriangleTests {

	public static final double EPSILON = 0.000001;

	@Test
	void rightTriangleTests() {
		// Construct a RightTriangle with a random base and height.
		double base = 10 * Math.random();
		double height = 10 * Math.random();
		RightTriangle triangle = new RightTriangle(base, height);

		assertTrue(triangle instanceof Triangle);
		assertTrue(triangle instanceof Polygon);
		assertTrue(triangle instanceof Shape);
		assertEquals("RightTriangle", triangle.getType());

		double hypotenuse = Math.sqrt(base * base + height * height);
		double perimeter = base + height + hypotenuse;
		double area = base * height / 2;
		assertEquals(base, triangle.getBase(), EPSILON);
		assertEquals(height, triangle.getHeight(), EPSILON);
		assertEquals(hypotenuse, triangle.getHypotenuse(), EPSILON);
		assertEquals(perimeter, triangle.getPerimeter(), EPSILON);
		assertEquals(area, triangle.getArea(), EPSILON);

		try {
			new RightTriangle(-1, 1);
			new RightTriangle(1, -1);
			fail("RightTriangle created with a negative base or height.");
		} catch (IllegalArgumentException e) {
		}
	}
}
