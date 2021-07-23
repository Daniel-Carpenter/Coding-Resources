import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CircleTests {

	public static final double EPSILON = 0.000001;
	
	@Test
	void circleTests() {
		// Construct a Circle with a random radius.
		double radius = 10 * Math.random();
		Circle circle = new Circle(radius);
		
		assertTrue(circle instanceof Shape);
		assertEquals("Circle", circle.getType());
		
		double perimeter = 2 * Math.PI * radius;
		double area = Math.PI * radius * radius;
		assertEquals(radius, circle.getRadius(), EPSILON);
		assertEquals(perimeter, circle.getPerimeter(), EPSILON);
		assertEquals(area, circle.getArea(), EPSILON);

		try {
			new Circle(-1);
			fail("Circle created with a negative radius.");
		} catch (IllegalArgumentException e) {
		}
	}
}
