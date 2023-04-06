package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber/description/
public class House_Robber {
	public static void main(String[] args) {
		System.out.println(rob(new int[] { 2, 7, 9, 3, 1 }));
	}

	public static int rob(int[] nums) {
		final int MAX = 100 + 1;
		int[] memory = new int[MAX];
		Arrays.fill(memory, -1);
		return pick_leave(0, memory, nums);
	}

	private static int pick_leave(int index, int[] memory, int[] nums) {
		// base case
		if (index >= nums.length)
			return 0;
		// memoization
		if (memory[index] != -1)
			return memory[index];
		// transitions
		int choice1 = pick_leave(index + 1, memory, nums);
		int choice2 = nums[index] + pick_leave(index + 2, memory, nums);
		memory[index] = Math.max(choice1, choice2);
		return memory[index];
	}
}
