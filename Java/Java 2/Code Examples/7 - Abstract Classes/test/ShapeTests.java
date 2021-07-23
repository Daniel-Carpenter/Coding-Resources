import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShapeTests {

	@Test
	public void shapeTests() {

		Mock m1 = new Mock("Foo", 1, 1);
		Mock m2 = new Mock("Bar", 1, 1);

		// Note: If the following two tests fail, run ShapeTests separately 
		// from the other unit tests. (JUnit can't reset the static field id.)
		assertEquals(0, m1.getID());
		assertEquals(1, m2.getID());

		assertTrue(m1.compareTo(m2) > 0);
		assertTrue(m2.compareTo(m1) < 0);

		m1 = new Mock("Foo", 1, 1);
		m2 = new Mock("Foo", -1, 1);
		assertTrue(m1.compareTo(m2) > 0);
		assertTrue(m2.compareTo(m1) < 0);

		m1 = new Mock("Foo", 1, 1);
		m2 = new Mock("Foo", 1, -1);
		assertTrue(m1.compareTo(m2) > 0);
		assertTrue(m2.compareTo(m1) < 0);

		m1 = new Mock("Foo", 1, 1);
		m2 = new Mock("Foo", 1, 1);
		assertTrue(m1.compareTo(m2) == 0);
		
		// Note: If the following two tests fail, run ShapeTests separately 
		// from the other unit tests. (JUnit can't reset the static field id.)
		assertEquals(6, m1.getID());
		assertEquals(7, m2.getID());
	}

	private class Mock extends Shape {

		private String type;
		private double perimeter;
		private double area;

		public Mock(String type, double perimeter, double area) {
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
