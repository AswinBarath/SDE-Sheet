package queue_implementations;

/*
 * Queue Implementation using Arrays
*/

public class QueueUsingArrays {
	int queue[];
	int front;
	int rear;
	int capacity;
	int elementCount;

	public QueueUsingArrays(int size) {
		this.capacity = size;
		front = rear = 0;
		queue = new int[capacity];
	}

	public void push(int data) {
		if (elementCount == capacity) {
			System.out.println("Queue is full");
			return;
		}
		queue[rear % capacity] = data;
		rear++;
		elementCount++;
	}

	public int pop() {
		if (elementCount == 0) {
			System.out.println("Queue is Empty");
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
}
