package coding_interviews1.first_sprints.sprint4;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-product-of-three-numbers/
public class MaxProductOf3Nums {
	public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		int i = nums.length - 1;
		return Math.max(nums[0] * nums[1] * nums[i], nums[i] * nums[i - 1] * nums[i - 2]);
	}
}
