package coding_interviews1.first_sprints.sprint2;

// https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
	// one of two solutions.
	public int trap(int[] height) {
		int n = height.length;
		int[][] maxArr = new int[n][2];
		// compute max left
		int maxLeft = 0;
		for (int i = 0; i < n - 1; i++) {
			maxArr[i][0] = maxLeft;
			maxLeft = Math.max(maxLeft, height[i]);
		}

		// compute max right
		int maxRight = 0;
		for (int i = n - 1; i >= 0; i--) {
			maxArr[i][1] = maxRight;
			maxRight = Math.max(maxRight, height[i]);
		}

		// compute result
		int res = 0;
		for (int i = 0; i < n - 1; i++) {
			int temp = Math.min(maxArr[i][0], maxArr[i][1]) - height[i];
			if (temp > 0)
				res += temp;
		}
		return res;
	}
}
