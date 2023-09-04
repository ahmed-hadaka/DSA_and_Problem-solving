package coding_interviews1.second_sprints.sprint5;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/
public class MinimumNumberIncrements {
	// there is a method reaching initial from tar (not intutive for me :|)
	// this: TLE ==> reaching tar from initial
	int minOperation;

	public int minNumberOperations(int[] target) {
		int n = target.length;
		int[] initial = new int[n];
		minOperation = 0;
		rec(initial, target, 0, n - 1);
		return minOperation;
	}

	private void rec(int[] initial, int[] tar, int st, int end) {
		if (st > end)
			return;
		int[] min = getMin(tar, st, end);// min[0] = minInd, min[1] = minVal
		minOperation += (min[1] - initial[min[0]]);
		Arrays.fill(initial, st, end + 1, min[1]);

		rec(initial, tar, min[0] + 1, end);
		rec(initial, tar, st, min[0] - 1);
	}

	private int[] getMin(int[] tar, int st, int end) {
		int[] res = new int[2];
		res[1] = 1000_02;
		for (int i = st; i <= end; i++) {
			if (res[1] > tar[i]) {
				res[0] = i;
				res[1] = tar[i];
			}
		}
		return res;
	}
}
