import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;


public class SortedList extends IntegerList 
{
	public SortedList()
	{
		super();
	}
	
	public SortedList(int _capacity)
	{
		super(_capacity);
	}
	
	public boolean add(int e)
	{		
		if (this.size() == 0)
		{
			super.add(e);
		}
		
		else
		{
			int position = this.size();
			
			for (int i = 0; i < this.size(); ++i)
			{
				
				if (e < this.get(i))
				{
					position = i;
					break;
				}
			}			
			
			this.insert(position, e);
		}
		return true;
	}
	
	
	public boolean remove(int e)
	{		

		int position = this.size();
		int count = 0;
		
		
		for (int i = 0; i < this.size(); ++i)
		{	
			if (e == this.get(i))
			{
				++count;
				position = i;
				break;
			}
		}			
		
		if (count == 0)
		{
			return false;
		}
		else
		{
			super.removeAt(position);			
		}

		return true;
	}
	
}
