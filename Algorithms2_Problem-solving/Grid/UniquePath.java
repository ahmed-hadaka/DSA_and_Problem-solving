package algorithms2_DP.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/unique-paths/description/
public class UniquePath {

	final int MAX = 100 + 1;
	int rows, columns;
	int[][] memory = new int[MAX][MAX];

	public int uniquePaths(int m, int n) {
		rows = m;
		columns = n;
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}

		return getUniquePath(0, 0);
	}

	private int getUniquePath(int row, int column) {
		// base case
		if (row == rows - 1 && column == columns - 1)
			return 1;

		// memoization
		if (memory[row][column] != -1)
			return memory[row][column];

		// transition
		int right = 0, down = 0;
		if (isValid(row, column + 1))
			right = getUniquePath(row, column + 1);

		if (isValid(row + 1, column))
			down = getUniquePath(row + 1, column);

		memory[row][column] = right + down;
		return memory[row][column];
	}

	private boolean isValid(int row, int column) {
		if (row >= 0 && row < rows && column >= 0 && column < columns)
			return true;
		return false;
	}
}
