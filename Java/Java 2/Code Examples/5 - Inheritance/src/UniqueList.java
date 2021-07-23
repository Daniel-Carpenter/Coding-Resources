
public class UniqueList extends IntegerList 
{
	public UniqueList()
	{
		super();
	}
	
	public UniqueList(int _capacity)
	{
		super(_capacity);
	}
	
	public boolean add(int e)
	{
		// @Override
		if (this.contains(e))
		{
			return false;
		}
		else
		{
			return super.add(e);			
		}
	}
	
	public boolean remove()
	{
		if (this.size() == 0)
		{
			return false;
		}
		else
		{
			return super.removeAt(this.size() - 1);
		}
	}
	
}
