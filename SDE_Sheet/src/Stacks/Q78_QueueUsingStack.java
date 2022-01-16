package Stacks;

import java.util.Stack;

public class Q78_QueueUsingStack {

	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();

	/** Initialize your data structure here. */
	public Q78_QueueUsingStack() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		input.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		// shift input to output
		if (output.empty())
			while (input.empty() == false) {
				output.push(input.peek());
				input.pop();
			}

		int x = output.peek();
		output.pop();
		return x;
	}

	/** Get the front element. */
	public int peek() {
		// shift input to output
		if (output.empty())
			while (input.empty() == false) {
				output.push(input.peek());
				input.pop();
			}
		return output.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return input.empty() && output.empty();
	}

	public static void main(String[] args) {
		Q78_QueueUsingStack q = new Q78_QueueUsingStack();

		q.push(3);
		q.push(4);
		q.push(1);

		System.out.println("peek -> " + q.peek());

		q.pop();

		System.out.println("peek -> " + q.peek());

	}

}

/*
 * 
 * Implement Queue Using Two Stacks
 * 
 * T.C => O(1) amortized
 * S.C => O(N)
 * 
 * Algorithm:-
 * 
 * 	push(x)
 * 			(.) s1 to s2 ( element by element insertion )
 * 			(.) Add x to s1
 *  		(.) swap ( s2 and s1 )
 * 
 * 	pop()
 * 			(.) Remove the top of s1
 * 	
 * 
 * Pseudo code:-
 * 
 * ( Let's name s1 and s2 as input and output respectively )
 * 
 * push(x) {
 * 		input.push(x)
 * }
 * 
 * pop() {
 * 		swap(input, output);
 * 		output.pop()
 * }
 * 
 * top() {
 * 		if(output not empty)
 * 			return output.top
 * 		else {
 * 			swap(input, output)
 * 			output.top
 * 		}
 * }
 * 
 */
