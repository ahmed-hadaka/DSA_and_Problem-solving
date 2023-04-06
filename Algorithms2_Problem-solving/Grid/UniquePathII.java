package algorithms2_DP.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths-ii/
public class UniquePathII {
	final int MAX = 100 + 1;
	int[][] grid;
	int rows, columns;
	int[][] memory = new int[MAX][MAX];

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		grid = obstacleGrid;
		rows = grid.length;
		columns = grid[0].length;
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		// edge case
		if (grid[0][0] == 1)
			return 0;
		return getUniquePath(0, 0);
	}

	private int getUniquePath(int row, int column) {
		// base case
		if (row == rows - 1 && column == columns - 1)
			return grid[row][column] == 0 ? 1 : 0;

		// memoization
		if (memory[row][column] != -1)
			return memory[row][column];

		// transition
		int right = 0, down = 0;
		if (isValid(row, column + 1))
			right = getUniquePath(row, column + 1);

		if (isValid(row + 1, column))
			down = getUniquePath(row + 1, column);
		return right + down;
	}

	private boolean isValid(int row, int column) {
		if (row >= 0 && row < rows && column >= 0 && column < columns && grid[row][column] != 1)
			return true;
		return false;
	}

}
