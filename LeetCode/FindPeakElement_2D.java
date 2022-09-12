package problems_java_DS;

public class FindPeakElement_2D {
	public static void main(String[] args) {

	}

	public int[] findPeakGrid(int[][] mat) {
		int rows = mat.length, cols = mat[0].length;
		int[] res = new int[2];
		// u, d, l, r
		int[] di = { -1, 1, 0, 0 };
		int[] dj = { 0, 0, -1, 1 };
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean flag = true;
				for (int k = 0; k < 4; k++) {
					int r = i + di[k];
					int c = j + dj[k];
					if (r < rows && c < cols && mat[r][c] > mat[i][j]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
	}
}
