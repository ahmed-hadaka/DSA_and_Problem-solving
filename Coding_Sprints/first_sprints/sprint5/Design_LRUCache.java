package coding_interviews1.first_sprints.sprint5;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/lru-cache/
public class Design_LRUCache {
	Map<Integer, int[]> keyMap;
	Map<Integer, Node> LRUMap;
	Node head, tail;
	int capacity;
	int counter;

	public Design_LRUCache(int capacity) {
		this.capacity = capacity;
		counter = 0;
		keyMap = new HashMap<>();
		LRUMap = new HashMap<>();
		head = tail = null;
	}

	public int get(int key) {
		if (keyMap.isEmpty() || !keyMap.containsKey(key)) {
			counter++;
			return -1;
		}
		int[] old = keyMap.get(key);
		keyMap.put(key, new int[] { old[0], counter }); // update counter first map

		Node cur = LRUMap.get(old[1]); // update LRU in second map
		deleteNode(cur);
		addToTheEnd(cur, counter);// add to the end of dll then, map.
		LRUMap.remove(old[1]);

		counter++;
		return old[0];
	}

	// add to the end of dll then, map.
	private void addToTheEnd(Node cur, int counter2) {
		if (tail == null) {
			tail = cur;
			head = cur;
		} else {
			tail.next = cur;
			cur.prev = tail;
			tail = cur;
		}

		LRUMap.put(counter2, cur);
	}

	private void deleteNode(Node cur) {
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

	public void put(int key, int value) {
		if (!keyMap.isEmpty() && keyMap.containsKey(key)) {
			int[] old = keyMap.get(key);
			keyMap.put(key, new int[] { value, counter }); // update value and counter first map

			Node cur = LRUMap.get(old[1]); // update value and LRU in second map
			deleteNode(cur);
			addToTheEnd(new Node(key, value), counter);
			LRUMap.remove(old[1]);
		} else {
			if (keyMap.size() < capacity) {
				keyMap.put(key, new int[] { value, counter });
				addToTheEnd(new Node(key, value), counter);
			} else {
				// delete LRU from dll
				Node old = head;
				head = head.next;
				if (head == null)
					tail = null;
				// remove LRU from lru map
				int oldCounter = keyMap.get(old.key)[1];
				LRUMap.remove(oldCounter);
				// add the new one at the end of lru map
				addToTheEnd(new Node(key, value), counter);
				// remove LRU from keymap and add the new one
				keyMap.remove(old.key);
				keyMap.put(key, new int[] { value, counter });

			}

		}
		counter++;
	}
}

class Node {
	Node next, prev;
	int key, value;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
