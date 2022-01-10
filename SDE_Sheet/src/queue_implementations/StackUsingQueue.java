package queue_implementations;

/*
 * Implementation of Stack using a single Queue
 */

public class StackUsingQueue {
	// T.C & S.C => O(N)
	int queue[];
	int front;
	int rear;
	int capacity;
	int elementCount;

	public StackUsingQueue(int size) {
		this.capacity = size;
		front = rear = 0;
		elementCount = 0;
		queue = new int[capacity];
	}

	public void push(int data) {
		if (elementCount == capacity) {
			System.out.println("Stack Overflow");
			return;
		}
		queue[rear % capacity] = data;
		rear++;
		elementCount++;
		for (int i = 0; i < elementCount - 1; i++) {
			queue[rear % capacity] = pop();
			rear++;
			elementCount++;
			/* Use this code snippet to check internal status 
			System.out.println("--");
			for(int ele : queue) {
				System.out.print(ele + ", ");
			}
			System.out.println();
			System.out.println("front="+(front%capacity));
			System.out.println("rear="+(rear%capacity));
			System.out.println("--");
			// Use this code snippet to check internal status */
		}
	}

	public int pop() {
		if (elementCount == 0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int temp = queue[front % capacity];
		queue[front % capacity] = -1;
		front++;
		elementCount--;
		return temp;
	}

	public int peek() {
		if (elementCount == 0) {
			return -1;
		}
		return queue[front % capacity];
	}

	boolean isEmpty() {
		return elementCount == 0;
	}

	public void print() {
		System.out.print("top->");
		for (int i = front; i < rear; i++) {
			System.out.println(queue[i % capacity]);
		}
	}
}

/*
 * 
 * Brute - force : Implement Stack Using Two Queues
 * T.C & S.C => O(N)
 * 
 * Algorithm:-
 * 
 * 	push(x)
 * 			(.) Add x to q2
 * 			(.) q1 to q2 ( element by element insertion ) 
 *  		(.) swap ( q1 and q2 )
 * 
 * 	pop()
 * 			(.) Remove the top of q1
 * 	
 * 
 * Pseudo code:-
 * 
 * push(x) {
 * 		q1.push(x)
 * 		while(!q1.isEmpty()) {
 * 			q2.push(q1.front());
 * 			q1.pop();
 * 		}
 * 		swap(q1, q2);
 * }
 * 
 * pop() {
 * 		q1.pop()
 * }
 * 
 * top() {
 * 		return q1.front();
 * }
 * 
 */
