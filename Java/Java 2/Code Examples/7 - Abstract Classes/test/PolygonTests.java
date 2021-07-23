import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolygonTests {

	@Test
	void polygonTests() {
		Mock m1 = new Mock("Foo", 1, 1);
		assertTrue(m1 instanceof Shape);

		Mock m2 = new Mock("Bar", 1, 1);
		assertTrue(m1.compareTo(m2) > 0);
		assertTrue(m2.compareTo(m1) < 0);

		try {
			new Mock("Foo", 1, -1);
			fail("The Polygon constructor should throw IllegalArgumentException"
					+ " if any side length is negative.");
		} catch (IllegalArgumentException e) {
		}
	}

	private class Mock extends Polygon {

		private String type;
		private double perimeter;
		private double area;

		public Mock(String type, double perimeter, double area) {
			super(new double[] { perimeter, area });
			this.type = type;
			this.perimeter = perimeter;
			this.area = area;
		}

		@Override // Override getType()
		public String getType() {
			return type;
		}

		@Override // Override getPerimeter()
		public double getPerimeter() {
			return perimeter;
		}

		@Override // Override getArea()
		public double getArea() {
			return area;
		}
	}
}
