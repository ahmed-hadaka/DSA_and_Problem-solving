package coding_interviews1.first_sprints.sprint4;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle-i/description/
public class LinkedListCycleI {
	public boolean hasCycle(Node head) {
		/// o(n) memory

		Set<Node> visited = new HashSet<>();
		Node cur = head;
		while (cur != null) {
			if (visited.contains(cur))
				return true;
			visited.add(cur);
			cur = cur.next;
		}
		return false;

		/// o(1) memory

//		int max = 10001;
//		int count = 0;
//		ListNode cur = head;
//		while (cur != null) {
//			count++;
//			if (count >= max)
//				return true;
//			cur = cur.next;
//		}
//		return false;

		/// fast, slow technique(2 pointers)
	}
}
