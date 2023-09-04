package coding_interviews1.first_sprints.sprint1;

// https://leetcode.com/problems/maximum-subarray/
public class MaxSubarray {
	public static void main(String[] args) {
		MaxSubarray maxSubarray = new MaxSubarray();
		System.out.println(maxSubarray.maxSubArray(new int[] { -5, -4, -1, -7, -8 }));
	}

	// prefix sum
	public int maxSubArray(int[] nums) {
		int prefixSum = 0, maxSofar = Integer.MIN_VALUE, minSofar = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			// get max so far
			maxSofar = Math.max(maxSofar, prefixSum);
			// process
			if (i != 0)
				maxSofar = Math.max(maxSofar, prefixSum - minSofar);
			// get min so far
			minSofar = Math.min(minSofar, prefixSum);
		}
		return maxSofar;
	}
}
