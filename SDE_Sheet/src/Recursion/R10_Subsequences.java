package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Definition of Subsequence:
 * 	A Contiguous / non-Contiguous sequences which follows the order
 * 
 *  Example:
 *  	arr -> [3,1,2]
 *  
 *  	Subsequences: (n=3 => 8 subsequences)
 *  		{}
 *  		3
 *  		1
 *  		2
 *  		3,1
 *  		1,2
 *  		3,2
 * 			3,1,2  
 * 
 * (In comparison, sub-array is just Contiguous) 
 * 
 * Time: Complexity: O(2^n * n)
 * Space Complexity: O(n)
 */

public class R10_Subsequences {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

//		System.out.println("Enter array size: ");
//		int n = input.nextInt();
//
//		System.out.println("Enter array elements: ");
//		int[] arr = new int[n];
//		for (int i = 0; i < n; i++) {
//			arr[i] = input.nextInt();
//		}

		int n = 3;
		int[] arr = { 3, 2, 1 };

		recursiveSubsequences1(0, arr, n, new ArrayList<Integer>());

//		List<Integer> ans2 = recursiveSubsequences2(n, arr);

		input.close();

	}

	public static void recursiveSubsequences1(int i, int[] arr, int n, List<Integer> sub) {
		if (i == n) {
			System.out.println(sub);
			return;
		}
		// Pick
		sub.add(arr[i]);
		recursiveSubsequences1(i + 1, arr, n, sub);
		sub.remove(sub.lastIndexOf(arr[i]));

		// Not Pick
		recursiveSubsequences1(i + 1, arr, n, sub);
	}

//	public static List<Integer> recursiveSubsequences2(int n, int[] arr) {
//
//	}

}
