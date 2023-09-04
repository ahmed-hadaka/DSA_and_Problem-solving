package coding_interviews1.second_sprints.sprint2;

import java.util.Arrays;

// https://leetcode.com/problems/3sum-closest/description/
public class _3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int s, th, closestSum = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for (int f = 0; f < nums.length - 2; f++) {
			s = f + 1;
			th = nums.length - 1;
			while (s < th) {
				int tempSum = nums[f] + nums[s] + nums[th];
				if (tempSum == target)
					return tempSum;
				if (tempSum < target) {
					if (Math.abs(target - closestSum) > Math.abs(target - tempSum)) {
						closestSum = tempSum;
					}
					s++;
				} else {
					if (Math.abs(target - closestSum) > Math.abs(target - tempSum)) {
						closestSum = tempSum;
					}
					th--;
				}
			}
		}
		return closestSum;
	}
}
