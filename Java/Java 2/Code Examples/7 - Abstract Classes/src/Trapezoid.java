
public class Trapezoid extends Polygon
{	
	private double[] sideLengths;
	private int TOP_IDX 	= 0;
	private int BOTTOM_IDX	= 1;
	private int HYP_IDX_1 	= 2;
	
	private RightTriangle sides;
	private Rectangle center;
	
	private double height;
	private double base;
	private double hypotenuse;
	private double perimeter;
	
	private static final int squared = 2;

	// Constructor --------------------------------------------------------------------
	
		public Trapezoid(double[] sideLengths) throws IllegalArgumentException 
		{
			super(sideLengths);
			
			// Assign parameter locally
				this.sideLengths = sideLengths;
			
			// Properties of Trapezoids found here: https://mathworld.wolfram.com/IsoscelesTrapezoid.html
				this.base 		= 1.0/2.0 * (sideLengths[BOTTOM_IDX] - sideLengths[TOP_IDX]);
				this.hypotenuse = sideLengths[HYP_IDX_1];
				this.height		= Math.sqrt(Math.pow(this.getHypotenuse(), squared) - 1.0/4.0 * Math.pow((sideLengths[BOTTOM_IDX] - sideLengths[TOP_IDX]), squared));
			
			// Test if Valid Triangle and Rect, then store
				this.sides =  new RightTriangle(this.getBase(), this.getHeight());
				this.center = new Rectangle(sideLengths[TOP_IDX], this.getHeight());
			
			// Test if Valid Trapezoid
				this.sideLengths = validateTrap(sideLengths);
				
			// Add Perimeter sides
				this.perimeter  = this.sideLengths[TOP_IDX] 
								+ this.sideLengths[BOTTOM_IDX] 
								+ this.sideLengths[HYP_IDX_1] * 2;
		}
	
	// Methods ----------------------------------------------------------------------
		
		private static double[] validateTrap(double[] sideLengths)
		{
			try
			{
				
				int HYP_IDX_1 = 2;
				int HYP_IDX_2 = 3;
				
				// Hypotenuses must equal
					if(sideLengths[HYP_IDX_1] != sideLengths[HYP_IDX_2]) 
					{
						throw new IllegalArgumentException();
					}
			
				return sideLengths;				
			}
			catch (IllegalArgumentException excpt)
			{
				throw excpt;
			}
		}
	
	
	// Getters ----------------------------------------------------------------------
	
		public RightTriangle getSideTriangle() {
 			return sides;
		}

		public Rectangle getCenterRectangle() {
			return center;
		}
		
		@Override
		public double getPerimeter() {
			return perimeter;
		}
		
		@Override
		public double getArea() {
			return height / 2.0 * (sideLengths[TOP_IDX] + sideLengths[BOTTOM_IDX]);
		}

		@Override
		public String getType() {
			return "Trapezoid";
		}

		public double[] getSideLengths() {
			return sideLengths;
		}

		public double getHeight() {
			return height;
		}
		
		public double getBase() {
			return base;
		}
		
		public double getHypotenuse() {
			return hypotenuse;
		}
}
