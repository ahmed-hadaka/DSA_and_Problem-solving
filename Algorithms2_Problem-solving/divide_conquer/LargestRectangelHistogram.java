package algorithms2_DP.divide_conquer;

// https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangelHistogram {
// 2,1,5,6,2,3
// 2, 4
	public static void main(String[] args) {
		LargestRectangelHistogram l = new LargestRectangelHistogram();
		int res = l.largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });
		System.out.println(res);
	}

	// my first approach o(n^2) TLE
	public int largestRectangleArea1(int[] heights) {
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			int count = 0;
			for (int j = 0; j < heights.length; j++) {
				if (heights[j] >= heights[i])
					count++;
				else if (j < i)
					count = 0;// reset
				else
					break;
			}
			maxArea = Math.max(maxArea, heights[i] * count);
		}
		return maxArea;
	}

	public int largestRectangleArea(int[] heights) {
		return gitMaxArea(heights, 0, heights.length - 1);
	}

	private int gitMaxArea(int[] heights, int s, int e) {
		if (s > e)
			return 0;

		int minPoleIndex = gitMinPole(heights, s, e);

		int maxLeftArea = gitMaxArea(heights, s, minPoleIndex - 1);
		int maxRightArea = gitMaxArea(heights, minPoleIndex + 1, e);

		return Math.max(Math.max(maxLeftArea, maxRightArea), heights[minPoleIndex] * (e - s + 1));
	}

	private int gitMinPole(int[] heights, int s, int e) {
		int min = Integer.MAX_VALUE;
		int minIndex = s;
		for (int i = s; i <= e; i++) {
			if (heights[i] < min) {
				min = heights[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
