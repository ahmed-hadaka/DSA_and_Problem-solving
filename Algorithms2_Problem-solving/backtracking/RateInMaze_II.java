package algorithms2_DP.backtracking;

public class RateInMaze_II {
	int[][] visited;
	int[][] matrix;
	int order;
	int[] dirR = new int[] { -1, 1, 0, 0 }; // up, down, right, left
	int[] dirC = new int[] { 0, 0, 1, -1 };
	int lengthOfPath = 0;
	int shortestPath = Integer.MAX_VALUE;
	int num_shortest_paths = 0;

// { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } }
// { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }
	public static void main(String[] args) {
		RateInMaze_II r = new RateInMaze_II();
		r.findPath(new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } }, 3);
	}

	public void findPath(int[][] m, int n) {
		matrix = m;
		order = n;
		visited = new int[n][n];
		if (matrix[n - 1][n - 1] != 0) {
			visited[0][0] = 1;
			System.out.println("numOfPossiblePathes: " + numOfPossiblePathes(0, 0));
			System.out.println("num_shortest_paths: " + num_shortest_paths);
			System.out.println("shortestPaht: " + shortestPath);
		}
	}

	// this function give us number of possible paths & number of shortest paths
	private int numOfPossiblePathes(int i, int j) {
		// base case
		if (i == order - 1 && j == order - 1) {
			if (lengthOfPath == shortestPath)
				num_shortest_paths++;
			else if (shortestPath > lengthOfPath) {
				shortestPath = lengthOfPath;
				num_shortest_paths = 1;
			}
			return 1;
		}

		// transition
		int num = 0;
		for (int k = 0; k < 4; k++) {
			int nr = i + dirR[k];
			int nc = j + dirC[k];
			if (!isValid(nr, nc) || visited[nr][nc] == 1)
				continue;
			// mark visited
			lengthOfPath++;
			visited[nr][nc] = 1;

			num += numOfPossiblePathes(nr, nc);

			// backtrack
			visited[nr][nc] = 0;
			lengthOfPath--;
		}
		return num;
	}

	private boolean isValid(int row, int column) {
		if (row >= 0 && row < order && column >= 0 && column < order && matrix[row][column] != 0)
			return true;
		return false;
	}

}
