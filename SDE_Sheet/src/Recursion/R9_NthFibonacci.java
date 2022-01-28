package Recursion;

import java.util.Scanner;

public class R9_NthFibonacci {

	public static void main(String[] args) {

		System.out.println("Enter number N: ");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();

		// iterative method:
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println("(Iterative)Nth Fibonacci number for N = " + n + " is " + arr[n]);

		// recursive method
		System.out.println("(Iterative)Nth Fibonacci number for N = " + n + " is " + nthFibonacciRecursive(n));

		input.close();
	}

	public static int nthFibonacciRecursive(int n) {
		if (n <= 1) {
			return n;
		}

		return nthFibonacciRecursive(n - 1) + nthFibonacciRecursive(n - 2);
	}

}
