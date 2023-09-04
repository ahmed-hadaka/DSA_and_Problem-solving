package coding_interviews1.first_sprints.sprint1;

// https://leetcode.com/problems/maximum-difference-between-increasing-elements/
public class MaxDiffereceBetween2Items {
	// we can solve it also by keep tracking the min value so far.

	public int maximumDifference(int[] nums) {
		int[] suffixMax = new int[nums.length];
		suffixMax[nums.length - 1] = nums[nums.length - 1];

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > suffixMax[i + 1])
				suffixMax[i] = nums[i];
			else
				suffixMax[i] = suffixMax[i + 1];
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			max = Math.max(max, suffixMax[i + 1] - nums[i]);
		}
		return max <= 0 ? -1 : max;
	}
}
