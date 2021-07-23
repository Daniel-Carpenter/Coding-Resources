
public class ExampleBegOfLab 
{
	public static void main (String[] args)
	{
		for (ExampleEnum symbol : ExampleEnum.values())
		{
			System.out.println(symbol);
		}
		
		String[] arr1 = {"hi", "ho"};
		
		for (String element : arr1)
		{
			System.out.println(element);
		}
	}
}
