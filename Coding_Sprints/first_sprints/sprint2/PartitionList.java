package coding_interviews1.first_sprints.sprint2;

// https://leetcode.com/problems/partition-list/description/
public class PartitionList {
	public ListNode partition(ListNode head, int x) {

		// my approach (just in-place solution, delete then insert)
		if (head == null || head.next == null)
			return head;

		ListNode cur = head, prevListNode = head, partitioNode = null, newHead = head;
		while (cur != null) {
			if (cur.val >= x) {
				if (partitioNode == null) {
					partitioNode = prevListNode;
				}
			} else {
				if (cur != head && partitioNode != null) {
					ListNode deletedNode = cur;
					// delete temp
					prevListNode.next = cur.next;
					cur = prevListNode;
					// insert after partitionNode
					if (partitioNode.val >= x) {
						ListNode tempNode = partitioNode;
						newHead = deletedNode;
						deletedNode.next = tempNode;
						partitioNode = newHead;
					} else {
						ListNode temp = partitioNode.next;
						partitioNode.next = deletedNode;
						deletedNode.next = temp;
						partitioNode = deletedNode;
					}
				}
			}
			prevListNode = cur;
			cur = cur.next;
		}
		return newHead;
	}

}

// Definition for singly-linked list.
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
