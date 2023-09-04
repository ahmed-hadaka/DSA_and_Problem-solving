package coding_interviews1.second_sprints.sprint4;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/find-and-replace-in-string/description/
public class FindAndReplaceInString {

	public static void main(String[] args) {
		FindAndReplaceInString obj = new FindAndReplaceInString();
		System.out.println(obj.findReplaceString("abcd", new int[] { 0, 2 }, new String[] { "a", "cd" },
				new String[] { "eee", "ffff" }));
	}

	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
		Node head = creatDLL(s)[0];
		Map<Integer, Node> map = initializeMap(new HashMap<>(), head);

		for (int i = 0; i < indices.length; i++) {
			int endInterv = isSubstring(s, indices[i], sources[i]);
			if (endInterv != -1) {
				Node[] tempDLL = creatDLL(targets[i]);
				Node start = map.get(indices[i]);
				Node end = map.get(endInterv);
				if (indices[i] != 0) {
					start.prev.next = tempDLL[0];
					tempDLL[0].prev = start.prev;
				}
				if (endInterv != s.length() - 1) {
					tempDLL[1].next = end.next;
					end.next.prev = tempDLL[1];
				}
				if (indices[i] == 0) {
					head = tempDLL[0];
				}
			}
		}
		return getString(head);
	}

	private String getString(Node head) {
		StringBuilder str = new StringBuilder("");
		while (head != null) {
			str.append(head.val);
			head = head.next;
		}
		return str.toString();
	}

	private int isSubstring(String s, int i, String string) {
		int j = 0;
		while (i < s.length() && j < string.length()) {
			if (s.charAt(i) != string.charAt(j))
				return -1;
			i++;
			j++;
		}
		if (j < string.length())
			return -1;
		return i - 1;
	}

	private Map<Integer, Node> initializeMap(Map<Integer, Node> map, Node head) {
		Node cur = head;
		int i = 0;
		while (cur != null) {
			map.put(i, cur);
			i++;
			cur = cur.next;
		}
		return map;
	}

	private Node[] creatDLL(String s) {
		Node h = null, t = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Node newNode = new Node(c);
			if (i == 0) {
				h = newNode;
				t = newNode;
			} else {
				t.next = newNode;
				newNode.prev = t;
				t = newNode;
			}
		}
		return new Node[] { h, t };
	}
}

class Node {
	char val;
	Node next, prev;

	public Node(char val) {
		this.val = val;
	}

	public Node() {

	}
}
