package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

/*
* Given an array of N positive integers, and a value target, determine if there is
*  a subset of the given numbers with sum equal to given target
*/
public class SubsetSum {

	static int[] nums;
	static final int MAX_INDEX = 500 + 1;
	static final int MAX_TARGET_VALUE = 2000 + 1;
	static final boolean[][] MEMORY = new boolean[MAX_INDEX][MAX_TARGET_VALUE];
	static final int[][] HELPER_MEMORY = new int[MAX_INDEX][MAX_TARGET_VALUE];

	public static void main(String[] args) {
		System.out.println(new SubsetSum().subsetSum(new int[] { 200 }, 300));
	}

	public boolean subsetSum(int[] values, int target) {
		nums = values;
		for (int[] i : HELPER_MEMORY) {
			Arrays.fill(i, -1);
		}
		for (boolean[] i : MEMORY) {
			Arrays.fill(i, false);
		}
		return canSubsetSum(0, target);
	}

	private boolean canSubsetSum(int ind, int target) {
		// base case
		if (target == 0)
			return true;
		if (ind == nums.length)
			return false;
		// memoization
		if (HELPER_MEMORY[ind][target] != -1)
			return MEMORY[ind][target];
		// transition
		HELPER_MEMORY[ind][target] = 1;

		if (nums[ind] <= target && canSubsetSum(ind + 1, target - nums[ind])) {
			MEMORY[ind][target] = true;
			return MEMORY[ind][target];
		}
		MEMORY[ind][target] = canSubsetSum(ind + 1, target);
		return MEMORY[ind][target];
	}
}
