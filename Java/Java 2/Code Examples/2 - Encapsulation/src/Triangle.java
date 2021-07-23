import java.text.DecimalFormat;

// Daniel Carpenter

public class Triangle 
{
	// Vars -------------------------------------------------------
	
		// pirvate Vars
			private double sideA;
			private double sideB;
			private double sideC;
		
		// Constants
			final private double DEFAULT_SIDE_LENGTH = 1;
		
		// Format Var
			DecimalFormat FORMATER = new DecimalFormat("#.###");
	
	
	// Triangle Class Construction --------------------------------
		
		public Triangle(double sideA, double sideB, double sideC)
		{
			// Test if Triangle, construct sides
				if (isTriangle(sideA, sideB, sideC))
				{
					this.sideA = sideA;
					this.sideB = sideB;
					this.sideC = sideC;
				}
			
			// If not triangle, then set to default (1)
				else
				{
					this.sideA = DEFAULT_SIDE_LENGTH;
					this.sideB = DEFAULT_SIDE_LENGTH;
					this.sideC = DEFAULT_SIDE_LENGTH;				
				}
		}
		
		
	// Test if isTriangle -----------------------------------------
		private static boolean isTriangle(double sideA, 
										  double sideB, 
										  double sideC)
		{
			// Sides must be Positive
				if (sideA <= 0 ||
					sideB <= 0 ||
					sideC <= 0)
				{
					return false;
				}
				
			// Sum of two sides must be > third
				else if (sideA + sideB <= sideC ||
						 sideB + sideC <= sideA ||
						 sideC + sideA <= sideB)
				{
					return false;
				}
				
			// Else return true because it satisfies constraints
				else
				{
					return true;
				}
		}
		
		
	// Create toString Method for Triangle ------------------------
		public String toString()
		{
			String output = "Triangle(" + FORMATER.format(this.sideA) + ", " 
										+ FORMATER.format(this.sideB) + ", "
										+ FORMATER.format(this.sideC) + ")";
			return output;
		}
		
		
	// Getters ----------------------------------------------------
		
		public double getSideA() {
			return sideA;
		}
		
		public double getSideB() {
			return sideB;
		}
		
		public double getSideC() {
			return sideC;
		}
	
		
	// Setters ----------------------------------------------------
		
		public boolean setSideA(double sideA) 
		{			
			// Test lengths of sides - set side and return true
				if (isTriangle(sideA, sideB, sideC))
				{
					this.sideA = sideA;
					return true;
				}
			
			// Return false otherwise
				else
				{
					return false;
				}
		}
		
		public boolean setSideB(double sideB) 
		{
			// Test lengths of sides - set side and return true
				if (isTriangle(sideA, sideB, sideC))
				{
					this.sideB = sideB;
					return true;
				}
			
			// Return false otherwise
				else
				{
					return false;
				}
		}
		
		public boolean setSideC(double sideC) 
		{
			// Test lengths of sides - set side and return true
				if (isTriangle(sideA, sideB, sideC))
				{
					this.sideC = sideC;
					return true;
				}
		
			// Return false otherwise
				else
				{
					return false;
				}
		}
}