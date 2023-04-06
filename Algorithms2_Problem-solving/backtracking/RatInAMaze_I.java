package algorithms2_DP.backtracking;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
public class RatInAMaze_I {
	static int[][] visited;
	static int[][] visited1;
	static int[][] matrix;
	static int order;

	public static ArrayList<String> findPath(int[][] m, int n) {
		ArrayList<String> pathes = new ArrayList<>();
		matrix = m;
		order = n;
		visited = new int[n][n];
		visited1 = new int[n][n];
		if (matrix[n - 1][n - 1] != 0) {
			numOfPathes(0, 0, pathes, "");
		}
		return pathes;
	}

	private static void numOfPathes(int i, int j, ArrayList<String> pathes, String s) {
		// base case
		if (i == order - 1 && j == order - 1) {
			pathes.add(s);
			return;
		}
		if (!isValid(i, j) || visited[i][j] != 0)
			return;

		// mark visited
		visited[i][j] = 1;

		// transition
		numOfPathes(i + 1, j, pathes, s + "D");
		numOfPathes(i, j + 1, pathes, s + "R");
		numOfPathes(i - 1, j, pathes, s + "U");
		numOfPathes(i, j - 1, pathes, s + "L");

		visited[i][j] = 0;
	}

	private static boolean isValid(int row, int column) {
		if (row >= 0 && row < order && column >= 0 && column < order && matrix[row][column] != 0)
			return true;
		return false;
	}

}
