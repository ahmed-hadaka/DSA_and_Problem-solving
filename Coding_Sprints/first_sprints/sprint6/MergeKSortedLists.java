package coding_interviews1.first_sprints.sprint6;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null, tail = null, smallestNode = null;
		int smallestNodeInd = -1;
		boolean flag = true;
		while (flag) {
			int smallestVal = Integer.MAX_VALUE;
			flag = false;
			for (int i = 0; i < lists.length; i++) {
				if (lists[i] != null && lists[i].val < smallestVal) {
					smallestNodeInd = i;
					smallestNode = lists[i];
					smallestVal = lists[i].val;
					flag = true;
				}
			}
			if (flag) {
				tail = concate(head, tail, smallestNode);// check if head = tail = null
				if (head == null)
					head = tail;
				remove(smallestNodeInd, lists);
			}
		}
		return head;
	}

	private ListNode concate(ListNode head, ListNode tail, ListNode smallestNode) {
		ListNode cur = new ListNode(smallestNode.val);
		if (tail == null) {
			tail = cur;
		} else {
			tail.next = cur;
			tail = cur;
		}
		return tail;
	}

	private void remove(int smallestNodeInd, ListNode[] lists) {
		lists[smallestNodeInd] = lists[smallestNodeInd].next;
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
