package coding_interviews1.first_sprints.sprint3;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
public class RemoveNthNodeFromLast {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = getLeng(head);
		int iterations = len - n + 1;
		int count = 1;
		ListNode cur = head, prev = head;

		while (count < iterations) {
			count++;
			prev = cur;
			cur = cur.next;
		}
		if (prev == cur)
			head = head.next;
		else
			prev.next = cur.next;
		return head;
	}

	private int getLeng(ListNode head) {
		ListNode cur = head;
		int count = 0;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
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
