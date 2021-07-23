
public class PrimeList extends IntegerList 
{
	final private int FIRST_PRIME = 2;
	private int stopVal			  = 0;
	
	
	// Constructors ============================================
		public PrimeList()
		{
			super();
		}
		
		public PrimeList(int _stopVal)
		{
			this.stopVal = _stopVal;
			
			for (int i = FIRST_PRIME; i <= this.stopVal; ++i)
			{
				if (isPrime(i))
				{
					super.removeAt(i); // change from add to replace
					super.add(i);
				}
			}
		}

	// Calcs ===================================================
		public boolean add(int e)
		{
			int lastStopVal = this.stopVal;
			
			if (e > this.stopVal)
			{
				// Set New stopVal
					this.stopVal = e;
					
				// Add e if prime
					for (int i = lastStopVal + 1; i <= this.stopVal; ++i)
					{
						if (isPrime(i) && i >= FIRST_PRIME)
						{
							super.add(i);
						}
					}
					return true;
					
			}
			else
			{
				// Do not update stopVal
					return false;
			}
		}
		
		public boolean isPrime(int num) 
		{ 
			boolean isPrime = false;
			
			if (num == 1 || num == 2)
			{
				isPrime = true;
			}
			else if (num % 2 == 0)
			{
				isPrime = false;
			}
			else 
			{
				for (int i = num - 1; i >= Math.sqrt(num); --i)
				{
					if (num % i == 0)
					{
						isPrime = false;
						break;
					}
					else
					{
						isPrime = true;
					}
				}			
			}
			
			return isPrime; 
		}

		
		public IntegerList getComposites()
		{
			// Create output List
				IntegerList compList = new IntegerList();
				
			// Add composites to new list
				for (int i = FIRST_PRIME; i <= this.stopVal; ++i)
				{
					if (!isPrime(i))
					{
						compList.add(i);
					}
				}
			
			return compList;
		}
	
}
