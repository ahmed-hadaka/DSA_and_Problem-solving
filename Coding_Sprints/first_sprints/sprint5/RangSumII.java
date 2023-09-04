package coding_interviews1.first_sprints.sprint5;

// https://leetcode.com/problems/range-sum-query-2d-immutable/description/
public class RangSumII {
	// 1- prefix sum for every row ==> o(row.leng)
	// 2- prefix sum for every row then, for every colum ==> o(max(row.len,
	// col.len))

	// int[][] matrix;
	// public RangSumII(int[][] matrix) {
	// this.matrix = matrix;
	// int r = matrix.length, c = matrix[0].length;
	// for(int i = 0; i < r; i++){
	// for(int j = 1; j < c; j++){
	// matrix[i][j] = matrix[i][j] + matrix[i][j-1];
	// }
	// }
	// }

	// public int sumRegion(int row1, int col1, int row2, int col2) {
	// int leftR, leftC, rightR, rightC, sum = 0;
	// for(int i = row1; i <= row2; i++){
	// leftR = i;
	// leftC = col1-1;
	// rightR = leftR;
	// rightC = col2;
	// if(leftC >= 0)
	// sum+= matrix[rightR][rightC] - matrix[leftR][leftC];
	// else
	// sum+= matrix[rightR][rightC] - 0;
	// }
	// return sum;
	// }

	int[][] matrix;

	public RangSumII(int[][] matrix) {
		this.matrix = matrix;
		int r = matrix.length, c = matrix[0].length;
		// prefix sum for every row
		for (int i = 0; i < r; i++) {
			for (int j = 1; j < c; j++) {
				matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
			}
		}

		// prefix sum for every col
		for (int i = 0; i < c; i++) {
			for (int j = 1; j < r; j++) {
				matrix[j][i] = matrix[j][i] + matrix[j - 1][i];
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		if (col1 - 1 < 0) {
			if (row1 - 1 < 0)
				sum = matrix[row2][col2];
			else
				sum = matrix[row2][col2] - matrix[row1 - 1][col2];
		} else {
			if (row1 - 1 < 0)
				sum = matrix[row2][col2] - matrix[row2][col1 - 1];
			else
				sum = matrix[row2][col2] - matrix[row2][col1 - 1] - matrix[row1 - 1][col2] + matrix[row1 - 1][col1 - 1];
		}
		return sum;
	}
}
