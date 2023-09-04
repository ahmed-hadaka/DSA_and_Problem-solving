package coding_interviews1.second_sprints.sprint6;

// https://leetcode.com/problems/palindrome-linked-list/description/
public class PalindromLinkedList {
	// o(1) space
	public boolean isPalindrome(ListNode head) {
		// loop to get length
		int len = 0;
		ListNode cur = head, tail = null;
		while (cur != null) {
			tail = cur;
			cur = cur.next;
			len++;
		}

		// loop to get mid node
		int mid = len / 2;
		len = mid;
		cur = head;
		while (mid-- > 0) {
			cur = cur.next;
		}

		// rec from mid till end to reverse the other half's pointers
		reverse(cur);

		// apply palindrom algo
		boolean res = true;
		while (tail != null && tail != head) {
			if (head.val != tail.val) {
				res = false;
				break;
			}
			tail = tail.next;
			head = head.next;
		}
		return res;

	}

	private void reverse(ListNode node) {
		if (node.next == null)
			return;

		reverse(node.next);

		node.next.next = node;
		node.next = null;
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
