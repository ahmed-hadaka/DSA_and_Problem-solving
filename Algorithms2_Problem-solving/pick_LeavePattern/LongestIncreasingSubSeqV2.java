package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

public class LongestIncreasingSubSeqV2 {

	public static void main(String[] args) {
		final int MAX = 2500 + 1;
		int[] memory = new int[MAX];
		Arrays.fill(memory, -1);
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] numsX = new int[nums.length + 1];
		numsX[0] = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			numsX[i + 1] = nums[i];
		}
		LongestIncreasingSubSeqV2 l = new LongestIncreasingSubSeqV2();
		System.out.println(l.lis(0, numsX, memory) - 1);
	}

	// starting from the index, what is the lis from it, given that we MUST include
	// this nums[index] with us
	private int lis(int index, int[] nums, int[] memory) {
		// base case
		if (index == nums.length)
			return 0;

		// memorization
		if (memory[index] != -1)
			return memory[index];

		// transition
		int max = 0;
		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] > nums[index]) {
				max = Math.max(max, lis(i, nums, memory));
			}
		}
		memory[index] = max + 1; // add 1 for current index
		return memory[index];
	}

}
