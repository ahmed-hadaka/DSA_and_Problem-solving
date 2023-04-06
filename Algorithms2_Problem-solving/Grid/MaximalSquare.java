package algorithms2_DP.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/maximal-square/description/
public class MaximalSquare {
	int rows, columns;
	final int MAX = 300 + 1;
	char[][] grid;
	int[][] memory = new int[MAX][MAX];

	public int maximalSquare(char[][] matrix) {
		grid = matrix;
		rows = matrix.length;
		columns = matrix[0].length;
		for (int[] cs : memory) {
			Arrays.fill(cs, -1);
		}
		int maxSquareArea = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					int curArea = getMaxArea(i, j);
					maxSquareArea = Math.max(maxSquareArea, curArea);
				}
			}
		}
		return maxSquareArea * maxSquareArea;
	}

	private int getMaxArea(int i, int j) {
		// base case
		if (!isValid(i, j) || grid[i][j] != '1')
			return 0;

		// memorization
		if (memory[i][j] != -1)
			return memory[i][j];
		// transition

		int right = getMaxArea(i, j + 1);
		int diagonal = getMaxArea(i + 1, j + 1);
		int down = getMaxArea(i + 1, j);
		memory[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
		return memory[i][j];
	}

	private boolean isValid(int row, int column) {
		if (row >= 0 && row < rows && column >= 0 && column < columns)
			return true;
		return false;
	}
}
