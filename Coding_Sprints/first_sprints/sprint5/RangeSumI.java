package coding_interviews1.first_sprints.sprint5;

// https://leetcode.com/problems/range-sum-query-immutable/description/
public class RangeSumI {
	int[] nums;

	public RangeSumI(int[] nums) {
		this.nums = nums;
		for (int i = 1; i < nums.length; i++) { // prefix sum
			nums[i] = nums[i] + nums[i - 1];
		}
	}

	public int sumRange(int left, int right) {
		if (left - 1 < 0)
			return nums[right];

		return nums[right] - nums[left - 1];
	}
}
