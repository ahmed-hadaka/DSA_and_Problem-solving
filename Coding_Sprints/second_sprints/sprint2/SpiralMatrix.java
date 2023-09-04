package coding_interviews1.second_sprints.sprint2;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/description/
public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix obj = new SpiralMatrix();
		System.out.println(obj.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		int n = matrix.length, m = matrix[0].length;
		if (n == 1) {
			for (int i : matrix[0]) {
				ans.add(i);
			}
			return ans;
		} else if (m == 1) {
			for (int i = 0; i < matrix.length; i++) {
				ans.add(matrix[i][0]);
			}
			return ans;
		}

		int i = 0, j = 0, rightInter = m - 1, leftInter = 0;
		int upInter = 1, downInter = n - 1;
		while (ans.size() < (n * m - 1)) {
			while (j < rightInter)
				ans.add(matrix[i][j++]);
			if (!(ans.size() < (n * m - 1)))
				break;
			while (i < downInter)
				ans.add(matrix[i++][j]);
			if (!(ans.size() < (n * m - 1)))
				break;
			while (j > leftInter)
				ans.add(matrix[i][j--]);
			if (!(ans.size() < (n * m - 1)))
				break;
			while (i > upInter)
				ans.add(matrix[i--][j]);
			rightInter--;
			downInter--;
			upInter++;
			leftInter++;
		}

		if (ans.size() != n * m)
			ans.add(matrix[i][j]);
		return ans;
	}
}
