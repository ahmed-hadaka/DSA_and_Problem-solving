package algorithms2_DP.rangePatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

class MinimumCost_to_CutStick {
	int[] arr;
	int nX;
	final int MAX = 100 + 1;
	Map<List<Integer>, Integer> memory = new HashMap<>();

	public int minCost(int n, int[] cuts) {
		arr = cuts;
		nX = n;
		int res = getMinCost(0, nX);
		return res == Integer.MAX_VALUE ? 0 : res;
	}

	private int getMinCost(int s, int e) {
		// base case
		if (s == (e - 1))
			return 0;

		// memoization
		List<Integer> key = new ArrayList<>(Arrays.asList(s, e));

		if (memory.containsKey(key))
			return memory.get(key);

		// transition
		int totalCost = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < e && arr[i] > s) {
				int left = getMinCost(s, arr[i]);
				int right = getMinCost(arr[i], e);
				totalCost = Math.min(totalCost, (e - s) + left + right);
			}
		}
		int value = totalCost == Integer.MAX_VALUE ? 0 : totalCost;
		memory.put(key, value);
		return value;
	}

//
	public static void main(String[] args) {
		System.out.println(new MinimumCost_to_CutStick().minCost(7, new int[] { 1, 3, 4, 5 }));
	}

}