import java.util.Comparator;

public class ShapeIDComparator implements Comparator<Shape> // compare persons
{
	@Override
	public int compare(Shape s1, Shape s2) 
	{
		// Get IDs and convert to String to match method type
			String id1 = Integer.toString(s1.getID());
			String id2 = Integer.toString(s2.getID());
			
		// Compare names
			return id1.compareTo(id2);
	}
}
