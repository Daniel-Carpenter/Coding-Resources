import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RectangleTests {

	public static final double EPSILON = 0.000001;

	@Test
	void rectangleTests() {
		// Construct a Rectangle with a random width and height.
		double width = 10 * Math.random();
		double height = 10 * Math.random();
		Rectangle rectangle = new Rectangle(width, height);

		assertTrue(rectangle instanceof Polygon);
		assertTrue(rectangle instanceof Shape);
		assertEquals("Rectangle", rectangle.getType());

		assertEquals(width, rectangle.getWidth(), EPSILON);
		assertEquals(height, rectangle.getHeight(), EPSILON);

		double perimeter = 2 * width + 2 * height;
		double area = width * height;
		assertEquals(perimeter, rectangle.getPerimeter(), EPSILON);
		assertEquals(area, rectangle.getArea(), EPSILON);

		try {
			new Rectangle(-1, 1);
			new Rectangle(1, -1);
			fail("Rectangle created with a negative width or height.");
		} catch (IllegalArgumentException e) {
		}

		// Construct a Square with a random side length.
		double side = 10 * Math.random();
		Square square = new Square(side);

		assertTrue(square instanceof Rectangle);
		assertTrue(square instanceof Polygon);
		assertTrue(square instanceof Shape);
		assertEquals("Square", square.getType());
		
		perimeter = 4 * side;
		area = side * side;
		assertEquals(side, square.getSide(), EPSILON);
		assertEquals(perimeter, square.getPerimeter(), EPSILON);
		assertEquals(area, square.getArea(), EPSILON);

		try {
			new Square(-1);
			fail("Square created with a negative side length.");
		} catch (IllegalArgumentException e) {
		}
	}

}
