package coding_interviews1.first_sprints.sprint1;

// https://leetcode.com/problems/maximum-sum-circular-subarray/
public class MaximumSumCircularSubarray {
	// BAD problem!!
	public int maxSubarraySumCircular(int[] nums) {
		int[] A = nums;
		int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
		for (int a : A) {
			curMax = Math.max(curMax + a, a);
			maxSum = Math.max(maxSum, curMax);
			curMin = Math.min(curMin + a, a);
			minSum = Math.min(minSum, curMin);
			total += a;
		}
		return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
	}
}
