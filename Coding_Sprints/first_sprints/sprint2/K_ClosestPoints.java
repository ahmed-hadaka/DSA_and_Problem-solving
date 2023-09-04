package coding_interviews1.first_sprints.sprint2;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/
public class K_ClosestPoints {
	public static void main(String[] args) {
		K_ClosestPoints k_ClosestPoints = new K_ClosestPoints();
		int[][] s = k_ClosestPoints.kClosest(new int[][] { { 0, 1 }, { 1, 0 } }, 2);
		for (int[] is : s) {
			System.out.println(is[0] + " " + is[1]);
			System.out.println();
		}
	}

	public int[][] kClosest(int[][] points, int k) {
		int[][] ans = new int[k][2];
		PriorityQueue<int[]> pQueue = new PriorityQueue<>(new RatingCompare());
		int i = 0;
		// 12 7 5 3==> we can put 4 but not 2
		for (; i < points.length; i++) {
			if (i < k)
				pQueue.add(points[i]);
			else if (dist(points[i]) < dist(pQueue.peek())) {
				pQueue.poll();
				pQueue.add(points[i]);
			}
		}
		int j = 0;
		for (int[] point : pQueue) {
			ans[j++] = point;
		}
		return ans;
	}

	private double dist(int[] point) {
		int x1 = 0;
		int x2 = point[0];
		int y1 = 0;
		int y2 = point[1];
		double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		return distance;
	}
}

class RatingCompare implements Comparator<int[]> {

	public int compare(int[] m1, int[] m2) {
		if (dist(m1) > dist(m2))
			return -1;
		if (dist(m1) < dist(m2))
			return 1;
		else
			return 0;
	}

	private double dist(int[] point) {
		int x1 = 0;
		int x2 = point[0];
		int y1 = 0;
		int y2 = point[1];
		double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		return distance;
	}

}
