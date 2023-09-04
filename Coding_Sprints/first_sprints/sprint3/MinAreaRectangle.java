package coding_interviews1.first_sprints.sprint3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// https://leetcode.com/problems/minimum-area-rectangle/description/
public class MinAreaRectangle {

	public int minAreaRect(int[][] points) {
		Set<Pair> set = new HashSet<>();
		int minArea = Integer.MAX_VALUE;
		for (int[] point : points) {
			set.add(new Pair(point[0], point[1]));
		}
		// traverse all valid diagonals
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				// if valid diagonal
				if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
					int[] p1 = points[i], p3 = points[j];
					if (set.contains(new Pair(p1[0], p3[1])) && set.contains(new Pair(p3[0], p1[1]))) {
						int tempArea = Math.abs(p1[0] - p3[0]) * Math.abs(p1[1] - p3[1]);
						minArea = Math.min(minArea, tempArea);
					}
				}
			}
		}
		return minArea == Integer.MAX_VALUE ? 0 : minArea;
	}
}

class Pair {
	int f, s;

	public Pair(int f, int s) {
		this.f = f;
		this.s = s;
	}

	@Override
	public int hashCode() {
		return Objects.hash(f, s);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		return f == other.f && s == other.s;
	}

}
