package coding_interviews1.first_sprints.sprint7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.ca/all/311.html
public class MatrixChainMulti {

	public int[][] multiply(int[][] mat1, int[][] mat2) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int[][] res = new int[mat1.length][mat2[0].length];

		for (int r = 0; r < mat1.length; r++) {
			for (int c = 0; c < mat1[0].length; c++) {
				map.putIfAbsent(r, new ArrayList<>());
				map.get(r).add(c);
			}
		}

		for (int r = 0; r < mat1.length; r++) {
			for (int c = 0; c < mat2[0].length; c++) {
				if (map.containsKey(r)) {
					for (Integer i : map.get(r)) {
						res[r][c] += (mat1[r][i] * mat2[i][r]);
					}
				}
			}
		}

		return res;
	}
}
