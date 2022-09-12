package problems_java_DS;

/*
 * robot go either to right, down or left and select the max value until there is no cells available.
*/
public class GreedyRobot {
	public static void main(String[] args) {
		int[][] grid = { { 11, 13, 6, 5 }, { 14, 4, 17, 16 }, { 7, 2, 3, 10 }, { 1, 8, 9, 12 }, };
		System.out.println(greedtRobot(grid)); // 61
	}

	public static int greedtRobot(int[][] grid) {
		int max = 0, i = 0, j = 0, r = grid.length, c = grid[i].length, count = grid[i][j];
		int tI = 0, tJ = 0;
		while (i < r - 1 || j < c - 1) {
			if (i + 1 < r && grid[i + 1][j] > max) { // down
				max = grid[i + 1][j];
				tI = i + 1;
				tJ = j;
			}
			if (j + 1 < c && grid[i][j + 1] > max) { // right
				max = grid[i][j + 1];
				tJ = j + 1;
				tI = i;
			}
			if (i + 1 < r && j + 1 < c && grid[i + 1][j + 1] > max) { // diagonal
				max = grid[i + 1][j + 1];
				tI = i + 1;
				tJ = j + 1;
			}
			i = tI;
			j = tJ;
			count += grid[i][j];
			max = 0;
		}
		return count;
	}

}
