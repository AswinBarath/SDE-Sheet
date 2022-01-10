package stack_implementations;

import java.util.EmptyStackException;

public class StackUsingLL {

	private class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head;
	int size;

	public StackUsingLL() {
		head = null;
		size = 0;
	}

	public void push(int data) {
		Node temp = new Node(data);
		temp.next = head;
		head = temp;
		size++;
	}

	public int pop() {
		if (head == null) {
			throw new EmptyStackException();
		}
		int temp = head.data;
		head = head.next;
		size--;
		return temp;
	}

	public int peek() {
		if (head == null) {
			throw new EmptyStackException();
		}
		return head.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int size() {
		return size;
	}

}
