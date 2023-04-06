package algorithms2_DP.counting;

import java.util.Arrays;
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

public class NumRollsToTarget {
	static int faces;
	static final int[] nums = new int[30];
	static final int MOD = 1000000007;
	static final int MAX_DICES = 30 + 1;
	static final int MAX_TARGET = 1000 + 1;
	static final int[][][] MEMORY = new int[MAX_DICES][MAX_TARGET][MAX_DICES];

	public static void main(String[] args) {
		System.out.println(new NumRollsToTarget().numRollsToTarget(30, 30, 500));
	}

	public int numRollsToTarget(int n, int k, int target) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		for (int[][] is : MEMORY) {
			for (int[] i : is) {
				Arrays.fill(i, -1);
			}
		}
		faces = k;
		return f(0, target, n);
	}

	public int f(int ind, int target, int n) {
		// base case
		if (target == 0 && n == 0)
			return 1;
		if (ind == faces + 1 || n < 0)
			return 0;

		// memoization

		if (MEMORY[ind][target][n] != -1)
			return MEMORY[ind][target][n];

		// transition
		int res = 0;
		for (int i = 1; i <= faces; i++) {
			if (i <= target) {
				res = res + f(i, target - i, n - 1);
				res %= MOD;
			}
		}
		MEMORY[ind][target][n] = res;
		return res;
	}

}
