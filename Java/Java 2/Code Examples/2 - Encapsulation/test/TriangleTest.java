import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	void testValidConstructorInput1() {
		double a = 3;
		double b = 4;
		double c = 5;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		a = 5;
		b = 3;
		c = 4;
		triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		a = 4;
		b = 5;
		c = 3;
		triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
	}
	
	@Test
	void testValidConstructorInput2() {
		double a = 1;
		double b = 2;
		double c = Math.sqrt(3);
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		a = Math.sqrt(3);
		b = 1;
		c = 2;
		triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		a = 2;
		b = Math.sqrt(3);
		c = 1;
		triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
	}

	@Test
	void testInvalidConstructorInput1() {
		Triangle triangle = new Triangle(0, 1, 2);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
		
		triangle = new Triangle(2, 0, 1);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
		
		triangle = new Triangle(1, 2, 0);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
	}

	@Test
	void testInvalidConstructorInput2() {
		Triangle triangle = new Triangle(1, 1, 3);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
		
		triangle = new Triangle(3, 1, 1);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
		
		triangle = new Triangle(1, 3, 1);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
	}
	
	@Test
	void testInvalidConstructorInput3() {
		Triangle triangle = new Triangle(1, 3, 2);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
		
		triangle = new Triangle(2, 1, 3);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
		
		triangle = new Triangle(3, 2, 1);
		assertEquals(1, triangle.getSideA());
		assertEquals(1, triangle.getSideB());
		assertEquals(1, triangle.getSideC());
	}
	
	@Test
	void testValidSetterInput1() {
		double a = 6;
		double b = 5;
		double c = 4;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		double newLength = 8;
		assertTrue(triangle.setSideA(newLength));
		assertEquals(newLength, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		assertTrue(triangle.setSideB(newLength));
		assertEquals(newLength, triangle.getSideA());
		assertEquals(newLength, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		assertTrue(triangle.setSideC(newLength));
		assertEquals(newLength, triangle.getSideA());
		assertEquals(newLength, triangle.getSideB());
		assertEquals(newLength, triangle.getSideC());
	}
	
	@Test
	void testValidSetterInput2() {
		Triangle triangle = new Triangle(5, 6, 7);
		assertEquals(5, triangle.getSideA());
		assertEquals(6, triangle.getSideB());
		assertEquals(7, triangle.getSideC());
		
		assertTrue(triangle.setSideA(12));
		assertEquals(12, triangle.getSideA());
		assertEquals(6, triangle.getSideB());
		assertEquals(7, triangle.getSideC());
		
		assertTrue(triangle.setSideB(18));
		assertEquals(12, triangle.getSideA());
		assertEquals(18, triangle.getSideB());
		assertEquals(7, triangle.getSideC());
		
		assertTrue(triangle.setSideC(29.99999));
		assertEquals(12, triangle.getSideA());
		assertEquals(18, triangle.getSideB());
		assertEquals(29.99999, triangle.getSideC());
	}
	
	@Test
	void testInvalidSetterInput1() {
		double a = 2;
		double b = 4;
		double c = 5;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		assertFalse(triangle.setSideA(-100));
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		assertFalse(triangle.setSideB(2));
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		assertFalse(triangle.setSideC(2));
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
	}
	
	@Test
	void testInvalidSetterInput2() {
		double a = 7;
		double b = 3;
		double c = 9;
		Triangle triangle = new Triangle(a, b, c);
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
				
		assertFalse(triangle.setSideA(b + c));
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
		
		assertFalse(triangle.setSideB(a + c));
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());

		assertFalse(triangle.setSideC(a + b));
		assertEquals(a, triangle.getSideA());
		assertEquals(b, triangle.getSideB());
		assertEquals(c, triangle.getSideC());
	}

	@Test
	void testToString() {
		Triangle triangle = new Triangle(1, 1, Math.sqrt(2));
		assertEquals("Triangle(1, 1, 1.414)", triangle.toString());
		
		triangle = new Triangle(4.0/2.0, 3.0/2.0, 4.0/3.0);
		assertEquals("Triangle(2, 1.5, 1.333)", triangle.toString());
	}
}
