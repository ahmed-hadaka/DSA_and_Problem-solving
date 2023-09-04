package coding_interviews1.first_sprints.sprint2;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargestElement {
	// my approach using freqArr
	public int findKthLargest(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] + 10_000;
			max = Math.max(max, nums[i]);
		}
		int[] freqArr = new int[max + 1];
		for (int i = 0; i < nums.length; i++) { // calc frequency
			freqArr[nums[i]]++;
		}
		int i = freqArr.length - 1;
		for (; k > 0; i--) {
			k -= freqArr[i];
		}

		return i + 1 - 10_000;
	}

	// min heap
	public int findKthLargestv2(int[] nums, int k) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		int i = 0;
		// 3 5 7 12 ==> we can put 4 but not 2
		for (; i < nums.length; i++) {
			if (i < k)
				pQueue.add(nums[i]);
			else if (nums[i] > pQueue.peek()) {
				pQueue.poll();
				pQueue.add(nums[i]);
			}
		}
		return pQueue.peek();
	}

}
