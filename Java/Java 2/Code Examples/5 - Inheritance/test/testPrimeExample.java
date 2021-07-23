
public class testPrimeExample 
{
	static boolean isPrime(int num) 
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
	      
    public static void main(String[] args)  
    { 
    	int n = 21;
    	
    	System.out.println(isPrime(n)) ;            
    } 
} 
	      
