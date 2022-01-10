package queue_implementations;

public class Client {

	public static void main(String[] args) {

		StackUsingQueue st = new StackUsingQueue(5);
		st.push(3);
		st.push(2);
		st.push(4);
		st.push(1);
		System.out.println("Peek -> " + st.peek());
		st.pop();
		System.out.println("Peek -> " + st.peek());
		st.print();
	}

}
