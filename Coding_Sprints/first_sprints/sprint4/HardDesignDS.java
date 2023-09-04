package coding_interviews1.first_sprints.sprint4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/all-oone-data-structure/description/
public class HardDesignDS {
	Map<String, Node> map;
	Node head, tail;

	public HardDesignDS() {
		map = new HashMap<>();
	}

	public void inc(String key) {
		if (map.isEmpty()) {
			Node node = new Node(1);
			node.set.add(key);
			map.put(key, node);
			head = node;
			tail = node;
		} else if (map.containsKey(key)) {
			Node cur = map.get(key);
			Node nextNode;
			if (cur.next != null && cur.next.count == cur.count + 1) {
				nextNode = cur.next;
			} else {
				nextNode = insertNodeAfter(cur);//
			}
			cur.set.remove(key);
			nextNode.set.add(key);
			map.put(key, nextNode);
			if (cur.set.isEmpty()) {
				removeNode(cur);//
			}
		} else {

			insertKey(key);
			map.put(key, head);
		}
	}

	private void removeNode(Node cur) {
		if (cur == head || cur == tail) {
			if (cur == head) {
				head = cur.next;
				if (head != null)
					head.prev = null;
			}
			if (cur == tail) {
				tail = cur.prev;
				if (tail != null)
					tail.next = null;
			}
		} else {
			cur.prev.next = cur.next;
			cur.next.prev = cur.prev;
		}
	}

	private Node insertNodeAfter(Node cur) {
		Node newNode = new Node(cur.count + 1);
		if (cur == tail) {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		} else {
			Node tempNode = cur.next;
			cur.next = newNode;
			newNode.prev = cur;
			newNode.next = tempNode;
			tempNode.prev = newNode;
		}
		return newNode;
	}

	private void insertKey(String key) {
		if (head.count > 1) {
			Node node = new Node(1);
			node.set.add(key);
			node.next = head;
			node.prev = null;
			head.prev = node;
			head = node;
		} else {
			head.set.add(key);
		}
	}

	public void dec(String key) {
		Node cur = map.get(key);
		if (cur.count == 1) {
			cur.set.remove(key);
			if (cur.set.isEmpty()) {
				map.remove(key);
				head = head.next;
				if (head != null)
					head.prev = null;
				else {
					tail = null;
				}
			}
		} else {
			Node prevNode;
			if (cur.prev != null && cur.prev.count == cur.count - 1) {
				prevNode = cur.prev;
			} else {
				prevNode = insertNodeBefore(cur);
			}
			prevNode.set.add(key);
			cur.set.remove(key);
			map.put(key, prevNode);

			if (cur.set.isEmpty()) {
				removeNode(cur);
			}
		}
	}

	private Node insertNodeBefore(Node cur) {
		Node prevNode = new Node(cur.count - 1);
		if (cur == head) {
			head.prev = prevNode;
			prevNode.next = head;
			head = prevNode;
		} else {
			cur.prev.next = prevNode;
			prevNode.prev = cur.prev;
			prevNode.next = cur;
			cur.prev = prevNode;
		}
		return prevNode;
	}

	public String getMaxKey() {
		if (tail == null)
			return "";
		return tail.set.iterator().next();
	}

	public String getMinKey() {
		if (head == null)
			return "";
		return head.set.iterator().next();
	}
}

class Node {
	int count;
	Node next, prev;
	Set<String> set;

	public Node(int count) {
		this.count = count;
		set = new HashSet<>();
	}
}
