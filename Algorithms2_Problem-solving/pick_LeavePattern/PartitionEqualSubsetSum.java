package algorithms2_DP.pick_LeavePattern;

// https://leetcode.com/problems/partition-equal-subset-sum/description/
public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] nums) {
		final int MAX_COL = (100 * 200) / 2;
		int[][] memory1 = new int[200][MAX_COL];
		boolean[][] memory2 = new boolean[200][MAX_COL];
		int target = getSum(nums);
		if (target % 2 != 0)
			return false;
		return getPossibleSum(0, target / 2, nums, memory1, memory2);
	}

	private int getSum(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return sum;
	}

	private boolean getPossibleSum(int index, int remaining, int[] values, int[][] memory1, boolean[][] memory2) {
		// base case
		if (remaining == 0)
			return true;
		if (index == values.length)
			return false;

		// memorization
		if (memory1[index][remaining] != 0) {
			return memory2[index][remaining];
		}
		// transition
		boolean choice1;
		if (choice1 = getPossibleSum(index + 1, remaining, values, memory1, memory2))// leave it
			return true;
		boolean choice2 = false;
		if (remaining >= values[index])
			choice2 = getPossibleSum(index + 1, remaining - values[index], values, memory1, memory2);
		memory1[index][remaining] = 1; // just mark it
		memory2[index][remaining] = choice1 || choice2;
		return choice1 || choice2;
	}

}
