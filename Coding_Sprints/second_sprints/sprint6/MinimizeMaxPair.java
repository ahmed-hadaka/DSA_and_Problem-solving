package coding_interviews1.second_sprints.sprint6;

import java.util.Arrays;

// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/
public class MinimizeMaxPair {
	public int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int len = nums.length, r = len - 1, res = 0;
		for (int l = 0; l < len; l++) {
			res = Math.max(nums[l] + nums[r], res);
			r--;
		}
		return res;
	}
}
