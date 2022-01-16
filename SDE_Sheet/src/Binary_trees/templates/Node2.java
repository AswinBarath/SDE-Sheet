package Binary_trees.templates;

class Node2 {

	int data;
	Node2 left;
	Node2 right;

	public Node2(int key) {
		this.data = key;
	}

	public Node2(int key, Node2 left, Node2 right) {
		this.data = key;
		this.left = left;
		this.right = right;
	}

}