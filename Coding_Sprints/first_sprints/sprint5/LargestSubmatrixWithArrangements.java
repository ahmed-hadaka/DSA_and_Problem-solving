package coding_interviews1.first_sprints.sprint5;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/
public class LargestSubmatrixWithArrangements {

	public int largestSubmatrix(int[][] matrix) {
		int res = 0;
		calcHeight(matrix); // o(n*m) time
		for (int i = 0; i < matrix.length; i++) {
			Arrays.sort(matrix[i]);
			res = Math.max(res, maxRectangleArea(matrix[i]));
		}
		return res;
	}

	private void calcHeight(int[][] matrix) {

		int rows = matrix.length, cols = matrix[0].length;
// with prefix sum for cols
		for (int c = 0; c < cols; c++)
			for (int r = 1; r < rows; r++) {
				if (matrix[r][c] != 0)
					matrix[r][c] += 1 * matrix[r - 1][c];
			}
	}

	private int maxRectangleArea(int[] row) {
		int[] prevSmallHeight = getPrevSmallHeight(row);
		int[] nextSmallHeight = getNextSmallHeight(row);

		int maxArea = 0, curArea = 0;
		for (int i = 0; i < row.length; i++) {
			curArea = row[i] * (nextSmallHeight[i] - prevSmallHeight[i] - 1);
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	private int[] getPrevSmallHeight(int[] row) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[row.length];
		// initial fill
		for (int i = 0; i < res.length; i++) {
			res[i] = -1;
		}
		// process
		for (int i = row.length - 1; i >= 0; i--) {
			while (!st.isEmpty() && row[i] < row[st.peek()]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		return res;
	}

	private int[] getNextSmallHeight(int[] row) {
		Stack<Integer> st = new Stack<>();
		int[] res = new int[row.length];
		// initial fill
		for (int i = 0; i < res.length; i++) {
			res[i] = row.length;
		}
		// process
		for (int i = 0; i < row.length; i++) {
			while (!st.isEmpty() && row[i] < row[st.peek()]) {
				res[st.pop()] = i;
			}
			st.push(i);
		}
		return res;
	}
}
