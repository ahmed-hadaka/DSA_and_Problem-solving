package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
public class MaximumHeight_by_StackingCuboids {

	public static void main(String[] args) {
		System.out.println(maxHeight(new int[][] { { 74, 7, 80 }, { 7, 52, 61 }, { 62, 41, 37 }, { 91, 58, 26 },
				{ 88, 98, 5 }, { 72, 93, 23 }, { 56, 58, 94 }, { 88, 8, 64 }, { 32, 55, 5 } }));
	}

	// ------- helper methods---------//

	private static int[][] specialSort(int[][] cuboids) {
		int[] temp1 = new int[cuboids.length];
		int[][] temp2 = new int[cuboids.length][cuboids[0].length];
		for (int[] is : cuboids) {
			Arrays.sort(is);
		}

		for (int i = 0; i < cuboids.length; i++) {
			temp1[i] = cuboids[i][0];
		}

		Arrays.sort(temp1);

		for (int i = 0; i < temp1.length; i++) {
			put(temp2, i, getRow(temp1[i], cuboids));
		}
		return temp2;
	}

	private static void put(int[][] temp2, int rowIndex, int[] row) {
		temp2[rowIndex] = row;
	}

	private static int[] getRow(int val, int[][] cuboids) {
		for (int[] arr : cuboids)
			if (arr[0] == val)
				return arr;
		return null;
	}

	private static boolean isLess_or_equal(int[][] cuboids, int index, int lastPickedIndex) {
		return (cuboids[index][1] >= cuboids[lastPickedIndex][1]) && (cuboids[index][2] >= cuboids[lastPickedIndex][2]);
	}

	private static int LIS(int index, int previous, int[][] cuboidsg, int[][] memory) {
		// base case
		if (index == cuboidsg.length)
			return 0;
		// memoization
		if (memory[index][previous] != -1)
			return memory[index][previous];
		// transition
		int choice1 = LIS(index + 1, previous, cuboidsg, memory);
		int choice2 = 0;
		if (previous == cuboidsg.length || isLess_or_equal(cuboidsg, index, previous))
			choice2 = cuboidsg[index][2] + LIS(index + 1, index, cuboidsg, memory);
		memory[index][previous] = Math.max(choice1, choice2);
		return memory[index][previous];
	}

	// -----------------------------//

	public static int maxHeight(int[][] cuboids) {
		int[][] cuboidsg = specialSort(cuboids);
		final int MAX = 101;
		int[][] memory = new int[MAX][MAX];
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}
		return LIS(0, cuboidsg.length, cuboidsg, memory);
	}
}
