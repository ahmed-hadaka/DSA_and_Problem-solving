package problems_Java;

public class GridSum {
	public static void main(String[] args) {
		int[][] grid = { { 1, 7, 8 }, { 2, 10, 11 }, { 20, 5, 9 } };
		System.out.println(gridSum(grid, 0, 0, 3, 3));
	}

	// the instructor approach was with direction array
	public static int gridSum(int[][] grid, int r, int c, int nR, int nC) {
		if (!(c + 1 < nC) && !(r + 1 < nR) && !((c + 1 < nC) && (r + 1 < nR))) {
			return grid[0][0];
		}
		if (c + 1 < nC && (grid[r][c + 1] > grid[r + 1][c + 1] && grid[r][c + 1] > grid[r + 1][c])) { // right
			return grid[r][c + 1] + gridSum(grid, r, c + 1, nR, nC);
		}
		if (c + 1 < nC && r + 1 < nR && (grid[r + 1][c + 1] > grid[r][c + 1] && grid[r + 1][c + 1] > grid[r + 1][c])) { // diagonal
			return grid[r + 1][c + 1] + gridSum(grid, r + 1, c + 1, nR, nC);
		}
		return grid[r + 1][c] + gridSum(grid, r + 1, c, nR, nC);

	}

}
