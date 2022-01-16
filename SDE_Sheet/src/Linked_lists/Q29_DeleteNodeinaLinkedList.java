package Linked_lists;

import Linked_lists.templates.ListNode;

import Linked_lists.templates.LinkedList;

class DeleteNodeinaLinkedListSolution {
	public void deleteNode(ListNode node) {

		// Copy the next value and reference to the current node
		node.val = node.next.val;
		node.next = node.next.next;

	}
}

public class Q29_DeleteNodeinaLinkedList {

	public static void main(String[] args) {
		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		DeleteNodeinaLinkedListSolution del = new DeleteNodeinaLinkedListSolution();

		del.deleteNode(head.next.next); // Deleting 3rd node

		// Print from the new LinkedList
		listOp.printList(head);
	}

}
