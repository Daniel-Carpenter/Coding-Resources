
public abstract class Shape implements Comparable<Shape> 
{
	// Member Vars -----------------------------------------------------
		private int id;
		private static int nextID = 0;
	
	// Constructor -----------------------------------------------------
	
		public Shape()
		{
			// Assign unique value to id (stored from nextID)
			this.id = Shape.nextID;
			
			// Increment the nextID -ensures that every Shape object has a unique ID number
			++Shape.nextID;
		}
		
	// Methods ---------------------------------------------------------
		
		public int compareTo(Shape other)
		{
			int GREATER_THAN = 1;
			int EQUAL_TO	 = 0;
			int LESS_THAN	 = -1;
			

			int typeEval  = this.getType().compareTo(other.getType());
			
			// Do types equal?
				if (typeEval != EQUAL_TO)
				{
					// if no, then int.compareTo() output
					return typeEval;
				}
			
			// Compare Perimeter (if equal Types)
				else if (this.getPerimeter() != other.getPerimeter())
				{
					if (this.getPerimeter() > other.getPerimeter())
					{
						return GREATER_THAN;
					}
					else
					{
						return LESS_THAN;
					}
				}
				
			// Compare Area (if both type and perimeter equal)
				else if (this.getArea() != other.getArea())
				{
					if (this.getArea() > other.getArea())
					{
						return GREATER_THAN;
					}
					else
					{
						return LESS_THAN;
					}
				}
				
			// Else return equal
				else
				{
					return EQUAL_TO;
				}
		}
		
		@Override
		public String toString() {
			return getType()
					+ ", ID: " + id
					+ ", PERIMETER: " + String.format("%.1f", getPerimeter())
					+ ", AREA: " + String.format("%.1f", getArea());
		}
		
	// Abstract --------------------------------------------------------
		
		public abstract String getType();
		public abstract double getPerimeter();
		public abstract double getArea();
		
	// Getters ---------------------------------------------------------

		public int getID() {
			return id;
		}
}
