package coding_interviews1.first_sprints.sprint4;

// https://leetcode.com/problems/next-permutation/description/
public class NextPerm {
	// TOP 100 Asked Problems
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		int j = n - 1;
		if (i >= 0) {
			while (nums[j] <= nums[i])
				j--;
			swap(i, j, nums);
		}
		// reverse the non-incresing
		j = n - 1;
		i++;
		while (i < j) {
			swap(i, j, nums);
			i++;
			j--;
		}
	}

	private void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
