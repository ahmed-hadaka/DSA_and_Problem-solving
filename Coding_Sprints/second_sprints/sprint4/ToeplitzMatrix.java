package coding_interviews1.second_sprints.sprint4;

// https://leetcode.com/problems/toeplitz-matrix/description/
public class ToeplitzMatrix {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int n = matrix.length, m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isValid(i - 1, j - 1, n, m)) {
					if (matrix[i][j] != matrix[i - 1][j - 1])
						return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(int i, int j, int r, int c) {
		if (i >= 0 && i < r && j >= 0 && j < c)
			return true;
		return false;
	}
}
