package coding_interviews1.second_sprints.sprint9;

// https://leetcode.com/problems/merge-in-between-linked-lists/description/
public class MergeInBetweenLinkedList {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode cur = list1;
		int i = 0;
		boolean flag1 = false, flag2 = false, flag3 = false;
		while (!flag1 || !flag2) {
			flag3 = false;
			if (i == a - 1) {
				ListNode temp = cur;
				cur = cur.next;
				temp.next = list2;
				flag3 = true;
				flag1 = true;
			}

			if (i == b + 1) {
				ListNode tail2 = getTail(list2);
				tail2.next = cur;
				cur = cur.next;
				flag3 = true;
				flag2 = true;
			}
			if (!flag3)
				cur = cur.next;
			i++;
		}
		return list1;
	}

	private ListNode getTail(ListNode h2) {
		while (h2.next != null) {
			h2 = h2.next;
		}
		return h2;
	}
}