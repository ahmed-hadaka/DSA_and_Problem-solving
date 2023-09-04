package coding_interviews1.first_sprints.sprint4;

// https://leetcode.com/problems/linked-list-cycle-ii/description/
public class LinkedListCycleII {
	public Node detectCycle(Node head) {
		/// o(n) memory

		// Set<ListNode> visited = new HashSet<>();
		// ListNode cur = head;
		// while(cur!= null){
		// if(visited.contains(cur))
		// return cur;
		// visited.add(cur);
		// cur = cur.next;
		// }
		// return null;

		// two pointers

		Node slow = head, fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				slow = head;
				while (fast != slow) {
					fast = fast.next; // one step
					slow = slow.next;
				}
				return fast; // or slow
			}
		}
		return null; // no cycle
	}
}
