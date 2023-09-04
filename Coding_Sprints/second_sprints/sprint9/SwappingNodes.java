package coding_interviews1.second_sprints.sprint9;

// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
public class SwappingNodes {
	public ListNode swapNodes(ListNode head, int k) {
		ListNode first = null, second = null, cur = head;
		int i = 1;
		int len = getLen(head);
		if (len == 1)
			return head;
		while (cur != null && (first == null || second == null)) {
			if (i == k) {
				first = cur;
			}
			if (i == (len - k + 1)) {
				second = cur;
			}
			cur = cur.next;
			i++;
		}
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
		return head;
	}

	private int getLen(ListNode head) {
		int len = 0;
		while (head != null) {
			head = head.next;
			len++;
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