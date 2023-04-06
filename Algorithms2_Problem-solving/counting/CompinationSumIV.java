package algorithms2_DP.counting;

import java.util.Arrays;

//https://leetcode.com/problems/combination-sum-iv/
public class CompinationSumIV {
	int[] globalNums;
	int[][] memory = new int[201][1001];

	public static void main(String[] args) {
		System.out.println(new CompinationSumIV().combinationSum4(new int[] { 1, 2, 3 }, 4));
	}

	public int combinationSum4(int[] nums, int target) {
		globalNums = nums;
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}
		return getPossibleComp(0, target);
	}

	private int getPossibleComp(int ind, int target) {
		// base case
		if (target == 0)
			return 1;
		if (ind == globalNums.length)
			return 0;
		// memoization
		if (memory[ind][target] != -1)
			return memory[ind][target];

		// transition
		int res = 0;
		for (int i = 0; i < globalNums.length; i++) {
			if (globalNums[i] <= target) {
				res += getPossibleComp(i, target - globalNums[i]);
			}
		}
		memory[ind][target] = res;
		return res;

	}
}
