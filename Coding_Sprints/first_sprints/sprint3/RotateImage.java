package coding_interviews1.first_sprints.sprint3;

// https://leetcode.com/problems/rotate-image/description/
public class RotateImage {

	public void rotate(int[][] matrix) {
		// swapping cells around the left diagonal.
		int n = matrix.length;
		for (int i = 1; i < n; i++) {
			int r1 = i, c1 = i;
			int r2 = i, c2 = i;
			while (isValid(r1 - 1, c1, n)) {
				swap(r1 - 1, c1, r2, c2 - 1, matrix);
				r1--;
				c2--;
			}
		}

		// swapping cols
		int l = 0, r = n - 1;
		while (l < r) {
			for (int i = 0; i < n; i++) {
				swap(i, l, i, r, matrix);
			}
			l++;
			r--;
		}
	}

	private boolean isValid(int r, int c, int n) {
		if (r >= 0 && r < n && c >= 0 && c < n)
			return true;
		return false;
	}

	private void swap(int r1, int c1, int r2, int c2, int[][] matrix) {
		int temp = matrix[r1][c1];
		matrix[r1][c1] = matrix[r2][c2];
		matrix[r2][c2] = temp;
	}

}
