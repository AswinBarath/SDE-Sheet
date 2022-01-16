package Linked_lists;

import Linked_lists.templates.ListNode;

import Linked_lists.templates.LinkedList;

public class Q26_MiddleOfLL {

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static void main(String[] args) {
		ListNode head = null;

		LinkedList listOp = new LinkedList();

		// Create a Linked List [1,2,3,4,5] :
		for (int i = 1; i <= 5; i++) {
			head = listOp.insert(head, i);
		}

		// Print the original LinkedList
		listOp.printList(head);

		Q26_MiddleOfLL mid = new Q26_MiddleOfLL();

		ListNode middle = mid.middleNode(head);

		// Print from the middle of LinkedList ( just to check )
		listOp.printList(middle);
	}

}
