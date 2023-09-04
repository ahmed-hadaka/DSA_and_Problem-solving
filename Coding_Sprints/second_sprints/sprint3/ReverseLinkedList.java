package coding_interviews1.second_sprints.sprint3;

// https://leetcode.com/problems/reverse-linked-list/description/
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode second = head, first = head.next, third = null;
		while (second != null) {
			second.next = third;
			third = second;
			second = first;
			if (first != null)
				first = first.next;
		}
		return third;
	}
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
