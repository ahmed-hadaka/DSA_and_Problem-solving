package algorithms2_DP.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/out-of-boundary-paths/
public class OutOfBoundaryPaths {
	final int MAX = 50 + 1;
	final int MOD = 1000000007;
	int rows, columns;
	int[][][] memory = new int[MAX][MAX][MAX];

	public static void main(String[] args) {
		System.out.println(new OutOfBoundaryPaths().findPaths(8, 50, 23, 5, 26));
	}

	public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		rows = m;
		columns = n;
		for (int[][] _2D : memory) {
			for (int[] _1D : _2D) {
				Arrays.fill(_1D, -1);
			}
		}

		return getPaths(startRow, startColumn, maxMove);
	}

	private int getPaths(int row, int column, int remiaing) {
		// base case
		if (row < 0 || row >= rows || column < 0 || column >= columns)
			return 1;
		if (remiaing == 0)
			return 0;

		// memoization
		if (memory[row][column][remiaing] != -1)
			return memory[row][column][remiaing];

		// transition
		int up = getPaths(row - 1, column, remiaing - 1);
		int down = getPaths(row + 1, column, remiaing - 1);
		int right = getPaths(row, column + 1, remiaing - 1);
		int left = getPaths(row, column - 1, remiaing - 1);
		// be careful on overflow!!
		memory[row][column][remiaing] = (((up + down) % MOD) + ((right + left) % MOD)) % MOD;
		return memory[row][column][remiaing];
	}

}
