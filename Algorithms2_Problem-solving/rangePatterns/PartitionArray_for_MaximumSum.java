package algorithms2_DP.rangePatterns;

import java.util.Arrays;

// https://leetcode.com/problems/partition-array-for-maximum-sum/description/
public class PartitionArray_for_MaximumSum {
	int[] Arr;
	int K;
	final int MAX = 500 + 1;
	int[] memory = new int[MAX];

	public int maxSumAfterPartitioning(int[] arr, int k) {
		Arr = arr;
		K = k;
		Arrays.fill(memory, -1);
		return bestSplit(0);
	}

	private int bestSplit(int ind) {
		// base case
		if (ind == Arr.length)
			return 0;

		// memoization
		if (memory[ind] != -1)
			return memory[ind];

		// transition
		int maxVal = Integer.MIN_VALUE;
		int totalSum = Integer.MIN_VALUE;
		for (int i = ind; i < ind + K; i++) {
			if (i >= Arr.length)
				break;
			maxVal = Math.max(maxVal, Arr[i]);
			int curSum = maxVal * (i - ind + 1);
			totalSum = Math.max(totalSum, bestSplit(i + 1) + curSum);
		}
		memory[ind] = totalSum;
		return memory[ind];
	}
}
