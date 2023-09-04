package coding_interviews1.second_sprints.sprint3;

// https://leetcode.com/problems/reverse-nodes-in-k-group/description/
public class ReverseNodesInk_Group {
	// 1,2,3,4,5
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		head.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;
		ReverseNodesInk_Group obj = new ReverseNodesInk_Group();
		obj.print(head);

		obj.print(obj.reverseKGroup(head, 3));
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head.next == null)
			return head;

		ListNode prevH = null, h = head, prev = head, cur = head.next, finalHead = head;
		int c = 1;
		while (!(prev == null || cur == null)) {
			while (cur != null && c < k) {
				prev = cur;
				cur = cur.next;
				c++;
			}
			if (cur == null && c < k)
				return finalHead;
			prev.next = null;
			ListNode[] l = reverse(h);
			if (prevH != null)
				prevH.next = l[0];
			else
				finalHead = l[0];
			l[1].next = cur;
			prevH = l[1];
			h = cur;
			prev = cur;
			if (cur != null)
				cur = cur.next;
			c = 1;
		}
		return finalHead;
	}

	private ListNode[] reverse(ListNode head) {
		ListNode[] ans = new ListNode[2];
		ans[1] = head;
		if (head == null || head.next == null) {
			ans[0] = head;
			return ans;
		}
		ListNode second = head, first = head.next, third = null;
		while (second != null) {
			second.next = third;
			third = second;
			second = first;
			if (first != null)
				first = first.next;
		}
		ans[0] = third;
		return ans;
	}

	private void print(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "=>");
			head = head.next;
		}
		System.out.println();
	}
}
