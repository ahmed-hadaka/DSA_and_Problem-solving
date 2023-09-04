package coding_interviews1.first_sprints.sprint5;

import java.util.Stack;

// https://leetcode.com/problems/maximal-rectangle/description
public class MaximalRectangle {
	public static void main(String[] args) {
		MaximalRectangle maximalRectangle = new MaximalRectangle();
		System.out.println(maximalRectangle.maximalRectangle(new char[][] { { '1', '0', '1', '0', '0' },
				{ '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));
	}

	public int maximalRectangle(char[][] matrix) {
		int res = 0;
		int[][] intMatrix = convertToInt(matrix);
		calcHeight(intMatrix); // o(n*m) time

		for (int r = 0; r < matrix.length; r++) { // o(n*m) time
			res = Math.max(res, maxRectangleArea(intMatrix[r]));
		}

		return res;
	}

	private int[][] convertToInt(char[][] matrix) {
		int[][] intMatrix = new int[matrix.length][matrix[0].length];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				intMatrix[r][c] = matrix[r][c] - '0';
			}
		}
		return intMatrix;
	}

	private void calcHeight(int[][] matrix) {
		int tempRow = 0, count;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				tempRow = r;
				count = 0;
				while (tempRow >= 0 && matrix[tempRow][c] > 0) {
					tempRow--;
					count++;
				}
				matrix[r][c] = tempRow == r ? 0 : count;
			}
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
