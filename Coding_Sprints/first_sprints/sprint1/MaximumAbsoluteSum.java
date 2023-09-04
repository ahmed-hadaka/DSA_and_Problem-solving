package coding_interviews1.first_sprints.sprint1;

// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/
public class MaximumAbsoluteSum {
	public int maxAbsoluteSum(int[] nums) {
		int sum = 0, max = 0, min = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		return max - min;
	}
}
