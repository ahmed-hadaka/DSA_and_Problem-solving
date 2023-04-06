package algorithms2_DP.enumeratingChoices;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-climbing-stairs/description/
public class MinCostClimbingStairs {
	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }));
	}

	public static int minCostClimbingStairs(int[] cost) {
		final int MAX = 1000 + 1;
		int[] memory = new int[MAX];
		Arrays.fill(memory, -1);
		int minCostFromZeroInd = getMinCost(0, cost, memory);
		Arrays.fill(memory, -1);
		int minCostFromOneInd = getMinCost(1, cost, memory);
		return Math.min(minCostFromZeroInd, minCostFromOneInd);
	}

	private static int getMinCost(int index, int[] cost, int[] memory) {
		// base case
		if (index >= cost.length)
			return 0;
		// memory
		if (memory[index] != -1)
			return memory[index];
		// transition
		memory[index] = cost[index]
				+ Math.min(getMinCost(index + 1, cost, memory), getMinCost(index + 2, cost, memory));
		return memory[index];
	}
}
