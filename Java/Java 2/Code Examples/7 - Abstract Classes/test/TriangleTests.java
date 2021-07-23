import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTests {

	public static final double EPSILON = 0.000001;
	
	@Test
	void triangleTests() {
		double sideA = 3;
		double sideB = 3;
		double sideC = 5;
		Mock m1 = new Mock(sideA, sideB, sideC, "Foo", 1);
		
		assertTrue(m1 instanceof Polygon);
		assertTrue(m1 instanceof Shape);

		Mock m2 = new Mock(1, 1, 1.5, "Foo", 1);
		assertTrue(m1.compareTo(m2) > 0);
		assertTrue(m2.compareTo(m1) < 0);

		assertEquals(sideA, m1.getSideA(), EPSILON);
		assertEquals(sideB, m1.getSideB(), EPSILON);
		assertEquals(sideC, m1.getSideC(), EPSILON);

		double perimeter = sideA + sideB + sideC;
		assertEquals(perimeter, m1.getPerimeter(), EPSILON);

		try {
			new Mock(3, 1, 1, "Foo", 1);
			new Mock(1, 3, 1, "Foo", 1);
			new Mock(1, 1, 3, "Foo", 1);
			fail("The Triangle constructor should check that the sides satisfy the triangle inequality.");
		} catch (IllegalArgumentException e) {
		}
	}

	private class Mock extends Triangle {

		private String type;
		private double area;

		public Mock(double sideA, double sideB, double sideC, String type, double area) {
			super(sideA, sideB, sideC);
			this.type = type;
			this.area = area;
		}

		@Override // Override getType()
		public String getType() {
			return type;
		}

		@Override // Override getArea()
		public double getArea() {
			return area;
		}
	}
}
