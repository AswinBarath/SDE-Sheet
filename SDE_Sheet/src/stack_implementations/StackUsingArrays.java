package stack_implementations;

/*
 * Stack Implementation using Arrays
*/

public class StackUsingArrays {
	int stack[];
	int top;
	int capacity;

	public StackUsingArrays(int size) {
		this.capacity = size;
		top = -1;
		stack = new int[capacity];
	}

	public void push(int data) throws Exception {
		if (top == capacity - 1) {
			throw new Exception("Stack Overflow");
		}
		top++;
		stack[top] = data;
	}

	public int pop() throws Exception {
		if (top == -1) {
			throw new Exception("Stack Underflow");
		}
		int temp = stack[top];
		top--;
		return temp;
	}

	public int peek() throws Exception {
		if (top == -1) {
			throw new Exception("Stack Underflow");
		}
		return stack[top];
	}

	boolean isEmpty() {
		return top == -1;
	}
}
