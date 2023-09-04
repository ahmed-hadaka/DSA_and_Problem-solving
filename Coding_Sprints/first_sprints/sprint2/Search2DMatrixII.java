package coding_interviews1.first_sprints.sprint2;

public class Search2DMatrixII {
	// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
	public boolean searchMatrix(int[][] matrix, int target) {
		// my first solution ~ o(n*m) with some optimization
//		int colBoundry = matrix[0].length;
//		for (int row = 0; row < matrix.length; row++) {
//			for (int col = 0; col < colBoundry; col++) {
//				if (matrix[row][col] == target)
//					return true;
//				if (matrix[row][col] > target) {
//					if (col == 0)
//						return false; // return earlier
//					colBoundry = col;
//					break;
//				}
//			}
//		}
//		return false;

		// better solution
		int row = 0;
		int col = matrix[0].length - 1;

		while (col >= 0 && row < matrix.length) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] > target)
				col--;
			else if (matrix[row][col] < target)
				row++;
		}
		return false;
	}
}
