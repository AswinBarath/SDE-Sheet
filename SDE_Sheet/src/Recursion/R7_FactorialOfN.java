package Recursion;

/*
 * Time complexity: O(N)
 * Space Complexity: O(N) --> Auxiliary space - Stack space while each recursive call waits
 */

public class R7_FactorialOfN {

	public static void main(String[] args) {

		// parameterized way
		int N = 5;
		int product = 1;
		factorialOfNParametrized(N, product);

		// functional way
		N = 5;
		System.out.println(factorialOfNFunctional(N));

	}

	private static void factorialOfNParametrized(int i, int product) {

		if (i < 1) {
			System.out.println(product);
			return;
		}

		factorialOfNParametrized(i - 1, product * i);
	}

	private static int factorialOfNFunctional(int i) {

		if (i <= 1) {
			return 1;
		}

		return i * factorialOfNFunctional(i - 1);
	}

}
