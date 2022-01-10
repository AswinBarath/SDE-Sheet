package stack_implementations;

import java.util.Stack;

public class StackInCollections {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();

		stack.push(10);

		while (!stack.isEmpty()) {
			System.out.println(stack.peek());
			stack.pop();
		}

		System.out.println(stack.size());

	}

}
