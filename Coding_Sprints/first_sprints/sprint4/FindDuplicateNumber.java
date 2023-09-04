package coding_interviews1.first_sprints.sprint4;

// https://leetcode.com/problems/find-the-duplicate-number/description
public class FindDuplicateNumber {
	// using Floyd's Tortoise and hare (slow, fast)pointers algorithms.
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = getFirstIntersect(nums);
		while (fast != slow) {
			fast = nums[fast];
			slow = nums[slow];
		}
		return fast; // or slow
	}

	private int getFirstIntersect(int[] nums) {
		int fast = nums[0], slow = nums[0];
		do {
			fast = nums[nums[fast]];
			slow = nums[slow];
		} while (fast != slow);

		return fast;
	}
}
