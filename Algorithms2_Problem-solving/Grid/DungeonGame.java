package algorithms2_DP.Grid;

import java.util.Arrays;

// https://leetcode.com/problems/dungeon-game/
public class DungeonGame {
	int rows, columns;
	final int MAX = 200 + 1;
	int[][] grid;
	int[][] memory = new int[MAX][MAX];

	public int calculateMinimumHP(int[][] dungeon) {
		rows = dungeon.length;
		columns = dungeon[0].length;
		grid = dungeon;
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		return getMinHealth(0, 0);
	}

	private int getMinHealth(int r, int c) {
		// base case
		if (!isValid(r, c))
			return Integer.MAX_VALUE;

		// memoization
		if (memory[r][c] != -1)
			return memory[r][c];
		if (r == rows - 1 && c == columns - 1) {
			if (grid[r][c] >= 0)
				return 1;
			else
				return 1 - grid[r][c];
		}

		int min = Math.min(getMinHealth(r, c + 1), getMinHealth(r + 1, c));

		int ans = 0;
		if (min > grid[r][c])
			ans = min - grid[r][c];
		else
			ans = 1;

		memory[r][c] = ans;
		return ans;
	}

	private boolean isValid(int row, int column) {
		if (row >= 0 && row < rows && column >= 0 && column < columns)
			return true;
		return false;
	}
}
