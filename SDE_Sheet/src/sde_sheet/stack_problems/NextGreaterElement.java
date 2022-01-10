package stack_problems;

import java.util.Stack;

// Problem Link: https://leetcode.com/problems/next-greater-element-ii/

public class NextGreaterElement {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 3 };
		int[] ans = nextGreaterElement(arr);
		for (int i : ans) {
			System.out.println(i);
		}

	}

	public static int[] nextGreaterElement(int[] arr) {
		// Time Complexity: O(N)
		// Space Complexity: O(N)
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> stack = new Stack<>();
		for (int i = 2 * (n - 1); i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= arr[i % n]) {
				stack.pop();
			}
			if (i < n) {
				if (!stack.isEmpty()) {
					nge[i] = stack.peek();
				} else {
					nge[i] = -1;
				}
			}
			stack.push(arr[i % n]);
		}
		return nge;
	}

}
