package coding_interviews1.second_sprints.sprint1;

// https://leetcode.com/problems/add-two-numbers/description/
public class AddTwoNumbers {
	ListNode head;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur = head;
		ListNode cur1 = l1, cur2 = l2;
		int num = 0, carry = 0;
		while (cur1 != null || cur2 != null || carry != 0) {
			num = 0;
			num += carry;
			if (cur1 != null) {
				num += cur1.val;
				cur1 = cur1.next;
			}
			if (cur2 != null) {
				num += cur2.val;
				cur2 = cur2.next;
			}
			if (num > 9) {
				num %= 10;
				carry = 1;
			} else
				carry = 0;
			ListNode node = new ListNode(num);
			if (cur == null) {
				cur = node;
				head = node;
			} else {
				cur.next = node;
				cur = cur.next;
			}
		}
		return head;
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
