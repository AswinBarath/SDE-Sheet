package queue_implementations;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueueCollection {

	private Queue<Integer> queue = new LinkedList<>();

	/** Initialize your data structure here. */
	public StackUsingQueueCollection() {

	}

	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++)
			queue.add(queue.remove());
	}

	// make sure you change this function parameter to int
	// in leetcode its void
	public int pop() {
		return queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	public static void main(String[] args) {
		StackUsingQueueCollection stack = new StackUsingQueueCollection();
		stack.push(3);
		stack.push(4);
		stack.push(2);
		System.out.println("top -> " + stack.top());
		stack.pop();
		System.out.println("top -> " + stack.top());
	}

}
