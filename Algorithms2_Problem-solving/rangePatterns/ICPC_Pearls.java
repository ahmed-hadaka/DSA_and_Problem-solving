package algorithms2_DP.rangePatterns;

//https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=676
/*
We're given two arrays, quantity and price
- quantity[i] = the number of pearls to buy of the ith type
-price[i] = the price per single pearl in the ith type
● The cost of a subarray [start, end] is as follows
- Assume s = sum of the quantities in the subarray: quantity[start], …, quantity[end]
- Total price = price[end] * (s+10)
● Goal: buy all pearls with the minimum possible price
- That is, find the best array to sub-arrays split
● Array length <= 100. quantity[i] and price[i] <= 1000
*/
import java.util.Arrays;

public class ICPC_Pearls {
	static final int[] QUANTITY = { 1, 1, 100 };
	static final int[] PRICES = { 10, 11, 12 };
	static final int MAX = 100 + 1;
	static int[] memory = new int[MAX];

	public static void main(String[] args) {
		Arrays.fill(memory, -1);
		System.out.println(bestSplitWithMinCost(0));
	}

	private static int bestSplitWithMinCost(int ind) {
		// base case
		if (ind == PRICES.length)
			return 0;

		// memoization
		if (memory[ind] != -1)
			return memory[ind];

		// transition
		int totalCost = Integer.MAX_VALUE;
		for (int i = ind; i < PRICES.length; i++) {
			int sum = getSum(ind, i); // we can replace it with accumulating the sum
			int curCost = (sum + 10) * PRICES[i];
			totalCost = Math.min(totalCost, bestSplitWithMinCost(i + 1) + curCost);
		}
		memory[ind] = totalCost;
		return memory[ind];
	}

	private static int getSum(int startInd, int endInd) {
		int sum = 0;
		for (int j = startInd; j <= endInd; j++) {
			sum += QUANTITY[j];
		}
		return sum;
	}

}
