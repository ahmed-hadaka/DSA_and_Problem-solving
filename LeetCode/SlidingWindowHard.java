package problems_Java;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowHard {
	public static void main(String[] args) {
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] arr = slidingWindowHard(nums, 2);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] slidingWindowHard(int[] nums, int k) {
		Deque<Integer> pq = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		int ind = 0;
		int tempInd = 0;
		int i = 0;
		for (; i < k; i++) {
			while (!pq.isEmpty() && pq.peekLast() < nums[i]) {
				pq.pollLast();
			}
			pq.addLast(nums[i]);
		}
		res[ind++] = pq.peekFirst();
		if (pq.peekFirst() == nums[tempInd++])
			pq.remove(nums[tempInd]);

		for (; i < nums.length; i++) {
			while (!pq.isEmpty() && pq.peekLast() < nums[i])
				pq.pollLast();
			pq.addLast(nums[i]);
			res[ind++] = pq.peekFirst();
			if (pq.peekFirst() == nums[tempInd++])
				pq.remove(nums[tempInd]);
		}
		return res;
	}
}
