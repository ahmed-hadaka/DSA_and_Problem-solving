package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/description/
public class CoinChange {

	static int[] nums;
	static final int MAX_INDEX = 12 + 1;
	static final int MAX_TARGET_VALUE = 10000 + 1;
	static final int[][] MEMORY = new int[MAX_INDEX][MAX_TARGET_VALUE];

	public static void main(String[] args) {
		System.out.println(new CoinChange().coinChange(new int[] { 1, 2, 5 }, 11));
	}

	public int coinChange(int[] coins, int amount) {
		nums = coins;
		for (int[] i : MEMORY) {
			Arrays.fill(i, -1);
		}
		int res = minCoins(0, amount);
		return res;
	}

// 1  2  5 ==>    11

	private int minCoins(int ind, int target) {
		// base case
		if (target == 0)
			return 0;
		if (ind == nums.length)
			return Integer.MAX_VALUE;

		// memoization
		if (MEMORY[ind][target] != -1)
			return MEMORY[ind][target];

		// transition
		int leave = minCoins(ind + 1, target);

		int pick = 0;
		if (nums[ind] <= target) {
			int temp = minCoins(ind, target - nums[ind]);
			pick = temp == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + temp;
		}

		return Math.min(pick, leave);
	}
}
