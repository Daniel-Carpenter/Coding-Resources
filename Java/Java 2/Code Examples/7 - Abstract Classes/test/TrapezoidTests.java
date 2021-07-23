import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrapezoidTests {

	public static final double EPSILON = 0.001;
	
	@Test
	void trapezoidTests() {
		// Invalid input tests
		Trapezoid t;
		try {
			t = new Trapezoid(new double[] { 2, 2, 1, 1 });
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			t = new Trapezoid(new double[] { 1, 2, 0, 1 });
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
		}

		try {
			t = new Trapezoid(new double[] { 1, 2, -1, 1 });
			fail("Expected IllegalArgumentException to be thrown");
		} catch (IllegalArgumentException e) {
		}

		double s1 = 7.5, s2 = 10.22, s3 = 11.97;
		double top = Math.min(s1, s2), bottom = Math.max(s1, s2);
		double expectedPerimeter = 41.66;
		double expectedArea = 105.3675;
		double expectedTrianglePerimeter = 25.2225;
		double expectedTriangleArea = 8.0869;
		double expectedRectanglePerimeter = 38.7850;
		double expectedRectangleArea = 89.1937;

		t = new Trapezoid(new double[] { top, bottom, s3, s3 });
		assertTrue(t instanceof Polygon);
		assertTrue(t instanceof Shape);
		assertEquals("Trapezoid", t.getType());		

		assertEquals(expectedPerimeter, t.getPerimeter(), EPSILON);
		assertEquals(expectedArea, t.getArea(), EPSILON);

		RightTriangle tTriangle = t.getSideTriangle();
		assertEquals(expectedTrianglePerimeter, tTriangle.getPerimeter(), EPSILON);
		assertEquals(expectedTriangleArea, tTriangle.getArea(), EPSILON);

		Rectangle tRectangle = t.getCenterRectangle();
		assertEquals(expectedRectanglePerimeter, tRectangle.getPerimeter(), EPSILON);
		assertEquals(expectedRectangleArea, tRectangle.getArea(), EPSILON);
	}
}
