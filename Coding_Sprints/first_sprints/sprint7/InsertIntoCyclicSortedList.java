package coding_interviews1.first_sprints.sprint7;

// https://leetcode.ca/all/708.html
public class InsertIntoCyclicSortedList {
	public Node_ insert(Node_ head, int insertVal) {
		if (head == null) {
			Node_ newHead = new Node_();
			newHead.val = insertVal;
			newHead.next = newHead;
			return newHead;
		}
		int maxVal = Integer.MIN_VALUE;
		Node_ maxNode = head;
		Node_ cur = head;
		boolean flag = false;
		do {
			if (cur.val > maxVal) {
				maxVal = cur.val;
				maxNode = cur;
			}
			if (cur.val <= insertVal && cur.next.val >= insertVal) {
				insertAt(insertVal, cur, cur.next);
				flag = true;
				break;
			}
			cur = cur.next;
		} while (cur != head);

		if (!flag) {
			insertAt(insertVal, maxNode, maxNode.next);
		}
		return head;
	}

	private void insertAt(int insertVal, Node_ cur, Node_ next) {
		Node_ newNode = new Node_(insertVal, next);
		cur.next = newNode;
	}
}

class Node_ {
	public int val;
	public Node_ next;

	public Node_() {
	}

	public Node_(int _val, Node_ _next) {
		val = _val;
		next = _next;
	}
}