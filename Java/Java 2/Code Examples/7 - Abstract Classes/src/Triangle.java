import java.util.InputMismatchException;

public abstract class Triangle extends Polygon
{	
	// Member Vars -----------------------------------------------------
		private double sideA;
		private double sideB;
		private double sideC;
		
		private int SIDE_A_IDX = 0;
		private int SIDE_B_IDX = 1;
		private int SIDE_C_IDX = 2;
		
	// Constructor -----------------------------------------------------
		public Triangle(double sideA, double sideB, double sideC) throws InputMismatchException
		{
			// Check for negative ints
				super(new double[] {sideA, sideB, sideC});
			
			// Check lengths
				double[] succesfulTriangle = checkLengths(sideA, sideB, sideC);
			
			// Set Lengths
				this.sideA = succesfulTriangle[SIDE_A_IDX];
				this.sideB = succesfulTriangle[SIDE_B_IDX];
				this.sideC = succesfulTriangle[SIDE_C_IDX];
		}
		
	// Methods ---------------------------------------------------------
		private static double[] checkLengths(double sideA, double sideB, double sideC) throws InputMismatchException
		{
			try
			{			
				// Triangle Equality
					if (!(sideA > 0 && sideB > 0 && sideC > 0) || !(sideA + sideB > sideC && 
																	sideA + sideC > sideB && 
																	sideB + sideC > sideA))
					{
						// Throw exception if fails
						throw new IllegalArgumentException();				
					}
	
				// IF Passes Equality return original double[]
					return new double[] {sideA, sideB, sideC};			
			}
			catch (IllegalArgumentException excpt)
			{
				throw excpt;
			}
		}

	
	// Getters ---------------------------------------------------------
	
		@Override
		public double getPerimeter() {
			return sideA + sideB + sideC;
		}
		
		public double getSideA() {
			return sideA;
		}
		
		public double getSideB() {
			return sideB;
		}
		
		public double getSideC() {
			return sideC;
		}
}
