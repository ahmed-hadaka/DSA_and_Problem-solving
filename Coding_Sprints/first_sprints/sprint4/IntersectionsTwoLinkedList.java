package coding_interviews1.first_sprints.sprint4;

// https://leetcode.com/problems/find-the-duplicate-number/description/
public class IntersectionsTwoLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// o(m+n) time, o(1) space using lengths
		int c1 = 0, c2 = 0;
		ListNode cur1 = headA, cur2 = headB;
		while (cur1 != null || cur2 != null) {
			if (cur1 != null) {
				c1++;
				cur1 = cur1.next;
			}
			if (cur2 != null) {
				c2++;
				cur2 = cur2.next;
			}
		}
		int diff = Math.abs(c1 - c2);
		if (c1 > c2) {
			c1 = 0;
			cur1 = headA;
			while (c1 != diff) {
				c1++;
				cur1 = cur1.next;
			}
			cur2 = headB;
		} else {
			c2 = 0;
			cur2 = headB;
			while (c2 != diff) {
				c2++;
				cur2 = cur2.next;
			}
			cur1 = headA;
		}

		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1; // or cur2
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
