public class Project_2 {
	public static void main(String[] args)
	{
// Group Members
	// Dax Dyson
	// Daniel Carpenter
	
// Book Names		
	double Catch22_JosHeller = 12.90;
	double Dune_FrankHerbert = 8.99;
	double Sid_HermHesse = 6.95;
	double SALES_TAX = .0875;

// Copies per sale
	int sale1Copy = 2;
	int sale2Copy = 4;
	int sale3Copy = 1;

// Sales
	double sale1 = sale1Copy * Catch22_JosHeller;
	double sale2 = sale2Copy * Dune_FrankHerbert;
	double sale3 = sale3Copy * Sid_HermHesse;
	double preTaxSale = sale1 + sale2 + sale3;
	double taxAmount = preTaxSale * (SALES_TAX);
	double totalCost = preTaxSale + taxAmount;
	
// Print Variables	
	System.out.println("Purchase " + sale1Copy + " copies of Catch-22, Joseph Heller. Each copy costs $" + String.format("%.2f",Catch22_JosHeller) + ".");
	System.out.println("Purchase " + sale2Copy + " copies of Dune, Frank Herbert. Each copy costs $" + String.format("%.2f",Dune_FrankHerbert) + ".");
	System.out.println("Purchase " + sale3Copy + " copy of Siddhartha, Hermann Hesse. Each copy costs $" + String.format("%.2f",Sid_HermHesse) + ".");
	System.out.println("Total before tax: $" + String.format("%.2f",preTaxSale));
	System.out.println("Sales tax: $" + String.format("%.2f",taxAmount));
	System.out.println("The total cost of your order will be $" + String.format("%.2f",totalCost) + ".");
	}	
}
