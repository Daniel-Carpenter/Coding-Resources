
public class Rectangle extends Polygon
{
	private double width;
	private double height;
	

	public Rectangle(double width, double height) throws IllegalArgumentException 
	{
		super(new double[] {width, height});
		
		this.width  = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	@Override
	public String getType() {
		return "Rectangle";
	}
	
	@Override
	public double getPerimeter() {
		return 2 * width + 2 * height;
	}
	
	@Override
	public double getArea() {
		return width * height;
	}

}
