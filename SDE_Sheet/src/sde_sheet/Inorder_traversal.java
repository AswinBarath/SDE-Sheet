package sde_sheet;

//Time Complexity: O(N)
//Space Complexity: O(N)
//- In worst case, the tree is skewed (Vertical linked list)
//- Auxiliary space used in Recursion

public class Inorder_traversal {

	// Left - Root - Right
	public static void inorder_traversal(Node root) {
		if (root == null)
			return;

		inorder_traversal(root.left);
		System.out.print(root.data + " ");
		inorder_traversal(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(6);
		root.right.left = new Node(7);
		root.right.right = new Node(8);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		inorder_traversal(root); // 4 2 6 5 1 7 3 9 8 10
	}

}
