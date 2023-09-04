package coding_interviews1.second_sprints.sprint8;

// https://leetcode.com/problems/rotate-list/description/
public class RotateList {
	ListNode tail;

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;
		ListNode tempH = head, res = null;
		tail = head;
		int len = getLen(head);

		k %= len;
		if (k == 0)
			return head;
		int diff = len - k;
		while (--diff > 0) {
			tempH = tempH.next;
		}

		res = tempH.next;
		tempH.next = null;
		tail.next = head;

		return res;
	}

	private int getLen(ListNode h) {
		int len = 0;
		while (h != null) {
			len++;
			tail = h;
			h = h.next;
		}
		return len;
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
