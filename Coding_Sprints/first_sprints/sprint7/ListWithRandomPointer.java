package coding_interviews1.first_sprints.sprint7;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/copy-list-with-random-pointer/description/
public class ListWithRandomPointer {
	public static void main(String[] args) {
		Map<Node, Integer> map = new HashMap<>();
		Node node1 = new Node(3);
		node1.next = new Node(2);
		node1.random = new Node(1);

		map.put(node1, 9);
		Node cur = node1;
		System.out.println(map.get(cur));
	}

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		Map<Node, Integer> map1 = new HashMap<>();
		Map<Integer, Node> map2 = new HashMap<>();
		Node tH = head;
		Node newH = new Node(head.val);
		Node cur = newH;
		int i = 0;
		map1.put(tH, i);
		map2.put(i, cur);
		i++;
		while (tH != null) {
			if (tH.next != null) {
				Node nextNode = new Node(tH.next.val);
				cur.next = nextNode;
				map1.put(tH.next, i);
				map2.put(i, nextNode);
			} else {
				cur.next = null;
			}
			tH = tH.next;
			cur = cur.next;
			i++;
		}
		cur = newH;
		while (head != null) {
			if (head.random != null) {
				cur.random = map2.get(map1.get(head.random));
			} else {
				cur.random = null;
			}
			cur = cur.next;
			head = head.next;
		}
		return newH;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
