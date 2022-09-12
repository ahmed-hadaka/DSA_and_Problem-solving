package problems_java_DS;

import java.util.ArrayList;
import java.util.List;

public class DiagonalTraverse {
	public static void main(String[] args) {
		int[][] grid = { { 8, 16, 9 }, { 3, 15, 27 }, { 14, 25, 29 } };
//		int[][] grid = { { 2, 5 }, { 8, 4 }, { 0, -1 } };
		int[] s = diagonalTraversal(grid);
		for (int i : s) {
			System.out.print(i + " ");
		}
	}

	public static int[] diagonalTraversal(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		int ind = 0;
		int[] res = new int[r * c];
		int dim = r + c - 1;
		List<List<Integer>> temp = new ArrayList<>(); // o(n^2) space
		while (dim-- > 0) {
			temp.add(new ArrayList<>());
		}
		for (int i = 0; i < r; i++) { // o(n^2) time
			for (int j = 0; j < c; j++) {
				temp.get(i + j).add(mat[i][j]);
			}
		}
		for (int i = 0; i < temp.size(); i++) {// o(n^2) time
			if (i != 0 && i % 2 != 0) {
				for (Integer item : temp.get(i)) {
					res[ind++] = item;
				}
			} else {
				List<Integer> l = temp.get(i);
				for (int j = l.size() - 1; j >= 0; j--) {
					res[ind++] = l.get(j);
				}
			}
		}

		return res;
	}
}
