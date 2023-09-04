package coding_interviews1.second_sprints.sprint10;

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/
public class RemoveConsecutiveZeroSumFromLL {

	public ListNode removeZeroSumSublists(ListNode head) {
		ListNode prev = head, nHead = prev, temp = new ListNode(Integer.MIN_VALUE);
		int sum = 0;
		for (ListNode cur = head; cur != null;) {
			temp = new ListNode(Integer.MIN_VALUE);

			for (ListNode cur2 = cur; cur2 != null; cur2 = cur2.next) {
				sum += cur2.val;
				if (sum == 0) {
					temp = cur2.next;
				}
			}
			sum = 0;
			if (temp == null || temp.val != Integer.MIN_VALUE) {
				if (cur == nHead) {
					prev = temp;
					nHead = prev;
					cur = temp;
				} else {
					prev.next = temp;
					cur = prev;
				}
			} else {
				prev = cur;
				cur = cur.next;
			}
		}
		return nHead;
	}
}

class ListNode {
	ListNode next;
	int val;

	public ListNode() {

	}

	public ListNode(int val) {
		this.val = val;
	}

}
