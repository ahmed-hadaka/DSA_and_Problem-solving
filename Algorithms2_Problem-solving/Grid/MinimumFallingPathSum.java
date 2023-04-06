package algorithms2_DP.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-falling-path-sum/
public class MinimumFallingPathSum {
	int[][] grid;
	int n;
	final int MAX = 100 + 1;
	int[][] memory = new int[MAX][MAX];

	public int minFallingPathSum(int[][] matrix) {
		// initialization
		grid = matrix;
		n = matrix.length;
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		// process
		int minCost = Integer.MAX_VALUE;
		for (int i = 0; i < matrix.length; i++) {
			int rightDiag = 0, leftDiag = 0, down = 0;
			if (matrix.length > 1) {
				rightDiag = getMinCost(1, i + 1);
				leftDiag = getMinCost(1, i - 1);
				down = getMinCost(1, i);
			}
			int minPath = Math.min(rightDiag, Math.min(leftDiag, down));
			minCost = Math.min(minCost, matrix[0][i] + minPath);
		}
		return minCost;
	}

	private int getMinCost(int r, int c) {
		// base case
		if (!isValid(r, c))
			return Integer.MAX_VALUE;

		// memoization
		if (memory[r][c] != -1)
			return memory[r][c];

		int rightDiag = getMinCost(r + 1, c + 1);
		int leftDiag = getMinCost(r + 1, c - 1);
		int down = getMinCost(r + 1, c);
		int minPath = Math.min(rightDiag, Math.min(leftDiag, down));
		memory[r][c] = minPath == Integer.MAX_VALUE ? grid[r][c] : minPath + grid[r][c];
		return memory[r][c];
	}

	private boolean isValid(int row, int column) {
		if (row >= 0 && row < n && column >= 0 && column < n)
			return true;
		return false;
	}

}
