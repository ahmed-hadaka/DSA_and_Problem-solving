package coding_interviews1.second_sprints.sprint9;

// https://leetcode.com/problems/maximum-width-ramp/description/
public class MaximumWidthRamp {
	public int maxWidthRamp(int[] nums) {
		int maxWidth = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums.length - 1 - i <= maxWidth)
				break;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] <= nums[j]) {
					maxWidth = Math.max(maxWidth, j - i);
					break;
				}
			}
		}
		return maxWidth == Integer.MIN_VALUE ? 0 : maxWidth;

	}

}
