package algorithms2_DP.rangePatterns;

import java.util.Arrays;

//https://leetcode.com/problems/partition-array-for-maximum-sum/
public class BurstBalloons {

	public static void main(String[] args) {
		BurstBalloons balloons = new BurstBalloons();
		System.out.println(balloons.maxCoins(new int[] { 3, 1, 5, 8 }));
	}

	int[] Ballons;
	final int MAX = 300 + 2 + 1;
	int[][] memory = new int[MAX][MAX];

	public int maxCoins(int[] nums) {
		// adding boundaries
		Ballons = new int[nums.length + 2];
		Ballons[0] = Ballons[Ballons.length - 1] = 1;
		for (int i = 1; i < Ballons.length - 1; i++) {
			Ballons[i] = nums[i - 1];
		}
		// initialize memory
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}

		return getMaxCoins(1, Ballons.length - 2);
	}

	private int getMaxCoins(int s, int e) {
		// base case
		if (s == e + 1)
			return 0;

		// momoization
		if (memory[s][e] != -1)
			return memory[s][e];

		// transition
		int maxCost = Integer.MIN_VALUE;
		for (int i = s; i <= e; i++) {
			int left = getMaxCoins(s, i - 1);
			int right = getMaxCoins(i + 1, e);
			int curCost = Ballons[s - 1] * Ballons[i] * Ballons[e + 1];
			maxCost = Math.max(maxCost, left + right + curCost);
		}
		memory[s][e] = maxCost;
		return memory[s][e];
	}

}
