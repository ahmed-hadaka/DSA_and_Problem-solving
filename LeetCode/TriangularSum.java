package problems_java_DS;

/*
 * print the sum of upper and lower diagonal in a matrix
*/
public class TriangularSum {
	public static void main(String[] args) {
		int[][] grid = { { 8, 16, 9 }, { 3, 15, 27 }, { 14, 25, 29 } };
		int[] res = triangularSum(grid);
		for (int i : res) {
			System.out.println(i);
		}

	}

	public static int[] triangularSum(int[][] grid) {
		int[] res = new int[2];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (j >= i)
					res[0] += grid[i][j];

				if (i >= j)
					res[1] += grid[i][j];
			}
		}
		return res;
	}
}
