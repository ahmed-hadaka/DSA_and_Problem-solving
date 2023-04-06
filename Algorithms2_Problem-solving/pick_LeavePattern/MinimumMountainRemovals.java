package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

// Not Complete ..
//https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
public class MinimumMountainRemovals {
	static int[] numsx;
	static int[][] memory1;
	static int[][] memory2;

	public static void main(String[] args) {
		System.out.println(minimumMountainRemovals(new int[] { 4, 3, 2, 1, 1, 2, 3, 1 }));
	}

	public static int minimumMountainRemovals(int[] nums) {
		final int MAX = 1000 + 1; // here :|
		numsx = nums;
		memory1 = new int[MAX][MAX];
		memory2 = new int[MAX][MAX];
		for (int[] i : memory1) {
			Arrays.fill(i, -1);
		}
		for (int[] i : memory2) {
			Arrays.fill(i, -1);
		}
		int LTR = left_to_right_LIS(0, numsx.length);
		int RTL = right_to_left_LIS(nums.length - 1, numsx.length);
		return numsx.length - (LTR + RTL - 1);
	}

	private static int left_to_right_LIS(int index, int prevIndex) {
		// base case
		if (index >= numsx.length)
			return 0;
		// memoization
		if (memory1[index][prevIndex] != -1)
			return memory1[index][prevIndex];
		// transitions
		int choice1 = left_to_right_LIS(index + 1, prevIndex);
		int choice2 = 0;
		if (prevIndex == numsx.length || numsx[index] > numsx[prevIndex])
			choice2 = 1 + left_to_right_LIS(index + 1, index);
		memory1[index][prevIndex] = Math.max(choice1, choice2);
		return memory1[index][prevIndex];
	}

	private static int right_to_left_LIS(int index, int prevIndex) {
		// base case
		if (index < 0)
			return 0;
		// memoization
		if (memory2[index][prevIndex] != -1)
			return memory2[index][prevIndex];
		// transitions
		int choice1 = right_to_left_LIS(index - 1, prevIndex); // leave it
		int choice2 = 0;
		if (prevIndex == numsx.length || numsx[index] > numsx[prevIndex])
			choice2 = 1 + right_to_left_LIS(index - 1, index); // pick it
		memory2[index][prevIndex] = Math.max(choice1, choice2);
		return memory2[index][prevIndex];
	}
}
