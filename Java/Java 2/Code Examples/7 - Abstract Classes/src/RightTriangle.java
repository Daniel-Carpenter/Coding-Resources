import java.util.InputMismatchException;

public class RightTriangle extends Triangle
{
	private double base;
	private double height;
	private double hypotenuse;
	private double area;
	private String type;
	
	public RightTriangle(double base, double height) throws InputMismatchException 
	{
		super(base, height, Math.sqrt(base * base + height * height));
		
		this.base = base;
		this.height = height;
		this.hypotenuse = calcHypotenuse(base, height);
		this.area = base * height / 2;
		this.type = "RightTriangle";
	}
	
	// Methods --------------------------------------------------------
	
		private static double calcHypotenuse(double base, double height)
		{
			double hypotenuse = Math.sqrt(base * base + height * height);
			return hypotenuse;
		}
	
	// Getters ---------------------------------------------------------
		
		public double getBase() {
			return base;
		}
	
		public double getHeight() {
			return height;
		}

		public double getHypotenuse() {
			return hypotenuse;
		}
		
		@Override
		public String getType() {
			return type;
		}
		
		@Override
		public double getArea() {
			return area;
		}
}
