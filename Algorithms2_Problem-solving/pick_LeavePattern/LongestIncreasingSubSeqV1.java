package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;
//https://leetcode.com/problems/longest-increasing-subsequence/description/

public class LongestIncreasingSubSeqV1 {

	public int lengthOfLIS(int[] nums) {
		final int MAX = 2500 + 1;
		int[][] memory = new int[MAX][MAX];
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}
		return LISV1(0, memory.length - 1, nums, memory);
	}

	// o(n^2) Time & Memory
	private int LISV1(int index, int lastPickedIndex, int[] nums, int[][] memory) {
		// base case
		if (index == nums.length)
			return 0;

		// memorization
		if (memory[index][lastPickedIndex] != -1)
			return memory[index][lastPickedIndex];

		// transition
		int choice1 = LISV1(index + 1, lastPickedIndex, nums, memory); // leave it
		int choice2 = 0;

		if (lastPickedIndex == memory.length - 1 || nums[lastPickedIndex] < nums[index]) { // pick it
			choice2 = 1 + LISV1(index + 1, index, nums, memory);
		}

		memory[index][lastPickedIndex] = Math.max(choice1, choice2);
		return memory[index][lastPickedIndex];
	}
}
