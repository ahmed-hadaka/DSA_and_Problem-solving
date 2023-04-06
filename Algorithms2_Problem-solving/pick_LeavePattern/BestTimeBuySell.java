package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class BestTimeBuySell {
	static int[][][] memory;
	static int[] pricesx;

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 1, 2, 3, 0, 2 }));
	}

	public static int maxProfit(int[] prices) {
		final int MAX = 5000 + 1;
		memory = new int[MAX][2][2];
		pricesx = prices;
		for (int[][] i : memory) {
			for (int[] j : i) {
				Arrays.fill(j, -1);
			}
		}
		return getMaxProfit(0, 1, 0);
	}

	private static int getMaxProfit(int index, int isLeave, int haveItem) {
		// base case
		if (index >= pricesx.length)
			return 0;

		// memoization
		if (memory[index][isLeave][haveItem] != -1)
			return memory[index][isLeave][haveItem];

		// transitions
		int choice1 = getMaxProfit(index + 1, 1, haveItem); // leave
		int choice2 = 0, choice3 = 0;
		if (isLeave == 1)
			choice2 = -pricesx[index] + getMaxProfit(index + 1, 0, 1);// buy
		if (haveItem == 1)
			choice3 = pricesx[index] + getMaxProfit(index + 1, 0, 0);// sell
		memory[index][isLeave][haveItem] = Math.max(choice1, Math.max(choice2, choice3));
		return memory[index][isLeave][haveItem];
	}
}
