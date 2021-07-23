import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FactorialExample {

	public static void main(String[] args) {

		// WHat is `4!`? (Factorial iter)

		System.out.println("Iterative on int value");
		// 0! = 1 (base)
		System.out.println(factorialIter(0));
		// 4! = 4 * 3 * 2 * 1 (recursive)
		System.out.println(factorialIter(4));
		// 4! = 4 * 3!
		System.out.println(4 * factorialIter(3));

		System.out.println("\nRecursive on int value");
		System.out.println(factorialRecursive(0));
		System.out.println(factorialRecursive(4));

		System.out.println("\nRecursive from Map");
		Map<Integer, Integer> cache = new LinkedHashMap<>();
		factorialMemoize(4, cache);
		System.out.println(cache);

		System.out.println("\nNotice that it does not calculate twice");
		factorialMemoize(5, cache);
		System.out.println(cache);

		System.out.println("\nRecursive from List");
		System.out.println(partialProducts(4));
	}

	// Iterative calculation -------------------------------------------------
	public static int factorialIter(int n) {
		int result = 1;
		for (int i = 1; i <= n; ++i) {
			result = result * i;
		}
		return result;
	}

	// Single int factorization -----------------------------------------------
	public static int factorialRecursive(int n) {

		// Edge Case (invalid input)
		if (n < 0) {
			throw new IllegalArgumentException();
		}

		// Base case, which is zero
		if (n == 0) {
			return 1;
		}

		// Recursive case
		return n * factorialRecursive(n - 1);
	}

	// Cache map recursive -----------------------------------------------------
	public static int factorialMemoize(int n, Map<Integer, Integer> cache) {
		// Edge Case
		if (n < 0) {
			throw new IllegalArgumentException();
		}

		// Base Case
		if (n == 0) {
			cache.put(0, 1);
			return 1;
		}

		// Recursive Case
		if (cache.containsKey(n)) {
			return cache.get(n);
		}
		int result = n * factorialMemoize(n - 1, cache);
		cache.put(n, result);
		System.out.println(cache.get(n));
		return result;
	}

	// recursive with a list ----------------------------------------------------
	public static List<Integer> partialProducts(int n) {
		// Base Case -- list must be created in the base case if want to return list
		if (n == 0) {
			List<Integer> products = new LinkedList<>();
			products.add(1);
			return products;
		}

		// Recursive Case
		List<Integer> products = partialProducts(n - 1);

		// -- calculates the elemenet of the list
		int nm1Factorial = products.get(products.size() - 1);
		int nFactorial = n * nm1Factorial;

		// Add to end of the list
		products.add(nFactorial);
		return products;
	}
}
