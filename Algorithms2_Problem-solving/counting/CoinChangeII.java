package algorithms2_DP.counting;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change-ii/description/
public class CoinChangeII {

	static int[] nums;
	static final int MAX_INDEX = 300 + 1;
	static final int MAX_TARGET_VALUE = 5000 + 1;
	static final int[][] MEMORY = new int[MAX_INDEX][MAX_TARGET_VALUE];

	public static void main(String[] args) {
		System.out.println(new CoinChangeII().change(5, new int[] { 1, 2, 5 }));
	}

	public int change(int amount, int[] coins) {
		nums = coins;
		for (int[] i : MEMORY) {
			Arrays.fill(i, -1);
		}
		int res = minCoins(0, amount);
		return res;
	}

	private int minCoins(int ind, int target) {
		// base case
		if (target == 0)
			return 1;
		if (ind == nums.length)
			return 0;

		// memoization
		if (MEMORY[ind][target] != -1)
			return MEMORY[ind][target];

		// transition
		int res = minCoins(ind + 1, target);// leave

		if (nums[ind] <= target) {
			res += minCoins(ind, target - nums[ind]); // pick
		}

		MEMORY[ind][target] = res;
		return MEMORY[ind][target];
	}
}
