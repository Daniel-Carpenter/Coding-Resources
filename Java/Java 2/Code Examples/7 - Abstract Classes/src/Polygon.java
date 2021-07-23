
public abstract class Polygon extends Shape
{
	public Polygon(double[] sideLengths) throws IllegalArgumentException
	{
		int numSides = sideLengths.length;
		
		try
		{
			for (int i = 0; i < numSides; ++i)
			{
				if (sideLengths[i] < 0)
				{
					// If negative throw exceptions
					throw new IllegalArgumentException();
				}
			}
		}
		catch (IllegalArgumentException excpt)
		{
			throw excpt;
		}
	}
}
