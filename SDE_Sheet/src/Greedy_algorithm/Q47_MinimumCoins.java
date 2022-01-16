package Greedy_algorithm;

import java.util.Vector;

public class Q47_MinimumCoins {

	public static void findMinCoins(int V) {
		Vector<Integer> ans = new Vector<>();

		int[] denom = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		int n = denom.length;

		for (int i = n - 1; i >= 0; i--) {
			while (V >= denom[i]) {
				V -= denom[i];
				ans.add(denom[i]);
			}
		}

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(" " + ans.elementAt(i));
		}
		System.out.println();

	}

	public static void main(String[] args) {

		System.out.println("Denominations for 49:");
		findMinCoins(49);
		System.out.println("Denominations for 84:");
		findMinCoins(84);

	}

}
