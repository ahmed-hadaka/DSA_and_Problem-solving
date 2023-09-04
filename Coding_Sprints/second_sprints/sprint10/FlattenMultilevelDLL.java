package coding_interviews1.second_sprints.sprint10;

// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/description/
public class FlattenMultilevelDLL {
	public Node flatten(Node head) {
		f(head);
		return head;
	}

	private Node f(Node root) {
		while (root != null) {
			if (root.child != null) {
				Node tail = f(root.child);
				Node temp = root.next;
				root.next = root.child;
				root.child.prev = root;
				root.child = null;
				if (temp != null)
					temp.prev = tail;
				tail.next = temp;
				root = tail;
			} else if (root.next == null) {
				return root;
			} else {
				root = root.next;
			}
		}
		return null;
	}
}

class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
}
