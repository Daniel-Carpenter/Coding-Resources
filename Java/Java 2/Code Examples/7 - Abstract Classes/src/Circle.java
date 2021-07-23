
public class Circle extends Shape
{
	private double radius;
	
	// Constructor -----------------------------------------------------------
		public Circle(double radius)
		{
			try
			{
				if (radius >= 0)
				{
					this.radius = radius;
				}
				else
				{
					// If negative throw exceptions
					throw new IllegalArgumentException();
				}
			}
			catch (IllegalArgumentException excpt)
			{
				throw excpt;
			}
		}
	
	// Getters ----------------------------------------------------------------
		
		public double getRadius() {
			return radius;
		}		
			
		@Override
		public String getType() {
			return "Circle";
		}
		
		@Override
		public double getPerimeter() {
			return 2 * Math.PI * radius;
		}
	
		@Override
		public double getArea() {
			return Math.PI * radius * radius;
		}

}
