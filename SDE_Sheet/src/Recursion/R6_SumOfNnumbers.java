package Recursion;

/*
 * Time complexity: O(N)
 * Space Complexity: O(N) --> Auxiliary space - Stack space while each recursive call waits
 */

/*
 * Two ways to solve this problem:
 * 	Parameter way
 * 	Functional way
 */
public class R6_SumOfNnumbers {

	public static void main(String[] args) {

		// parameterized way
		int N = 10;
		int sum = 0;
		sumOfNnumbersParametrized(N, sum);

		// functional way
		N = 10;
		System.out.println(sumOfNnumbersFunctional(N));

	}

	private static void sumOfNnumbersParametrized(int i, int sum) {

		if (i == 0) {
			System.out.println(sum);
			return;
		}

		sumOfNnumbersParametrized(i - 1, sum + i);
	}

	private static int sumOfNnumbersFunctional(int i) {

		if (i < 1) {
			return 0;
		}

		return i + sumOfNnumbersFunctional(i - 1);
	}

}
