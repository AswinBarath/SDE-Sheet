package Stacks;

import java.util.Stack;

// Problem link: https://leetcode.com/problems/valid-parentheses/

public class Q79_ValidParentheses {

	public static void main(String[] args) {
		String s = "[()[]{}]";

		System.out.println(checkValid(s));

	}

	private static boolean checkValid(String s) {
		// Time Complexity: O(N)
		// Space Complexity: O(N)

		Stack<Character> stack = new Stack<>();
		for (char it : s.toCharArray()) {
			if (it == '(' || it == '[' || it == '{') {
				stack.push(it);
			} else {
				if (stack.isEmpty())
					return false;
				char curr = stack.pop();
				if ((curr == '(' && it == ')') || (curr == '[' && it == ']') || (curr == '{' && it == '}'))
					continue;
				else
					return false;
			}
		}
		return stack.isEmpty();
	}

}
