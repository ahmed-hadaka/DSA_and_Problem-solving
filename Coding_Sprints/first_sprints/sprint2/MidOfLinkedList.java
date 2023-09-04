package coding_interviews1.first_sprints.sprint2;

// https://leetcode.com/problems/middle-of-the-linked-list/description/
public class MidOfLinkedList {
	public ListNode middleNode(ListNode head) {
		ListNode slowPointer = head, fastPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		return slowPointer;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}

//  Definition for singly-linked list.
