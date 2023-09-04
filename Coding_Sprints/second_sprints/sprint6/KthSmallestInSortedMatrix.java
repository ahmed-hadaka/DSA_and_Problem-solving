package coding_interviews1.second_sprints.sprint6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class KthSmallestInSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		Map<Integer, List<int[]>> map = new TreeMap<>();
		int n = matrix.length;
		int[] tArr = null;
		// initialize
		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(matrix[i][0], d -> new ArrayList<>()).add(new int[] { i, 0 });
		}
		// process
		while (k-- > 0) {
			tArr = removeSmallest(map);
			if (tArr[1] + 1 >= n)
				continue;
			map.computeIfAbsent(matrix[tArr[0]][tArr[1] + 1], d -> new ArrayList<>())
					.add(new int[] { tArr[0], tArr[1] + 1 });
		}
		return matrix[tArr[0]][tArr[1]];
	}

	private int[] removeSmallest(Map<Integer, List<int[]>> map) {
		int[] res = null;
		int k = 0;
		boolean flag = false;
		for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
			List<int[]> l = entry.getValue();
			res = l.get(0);
			l.remove(0);
			if (l.size() == 0)
				flag = true;
			k = entry.getKey();
			break;
		}
		if (flag)
			map.remove(k);
		return res;
	}

}
