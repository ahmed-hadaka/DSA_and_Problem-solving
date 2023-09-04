package coding_interviews1.second_sprints.sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/interval-list-intersections/description/n
public class IntervalListIntersection {
	public static void main(String[] args) {
		IntervalListIntersection obj = new IntervalListIntersection();
		int[][] res = obj.intervalIntersection(new int[][] { { 1, 3 }, { 5, 9 } }, new int[][] {});
		for (int[] i : res) {
			System.out.println(Arrays.toString(i));
		}
	}

	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		int n1 = firstList.length, n2 = secondList.length;
		if (n1 == 0)
			return firstList;
		if (n2 == 0)
			return secondList;

		int i = 0, j = 0;
		int[] greatest, smallest;
		List<List<Integer>> intersections = new ArrayList<>();
		while (i < n1 && j < n2) {
			greatest = firstList[i];
			smallest = secondList[j];
			if (secondList[j][0] > firstList[i][0]) {
				greatest = secondList[j];
				smallest = firstList[i];
			}

			int t1 = greatest[1] - greatest[0];
			int t2 = greatest[1] - smallest[1];
			if ((t1 - t2) >= 0) {
				intersections.add(new ArrayList<>(Arrays.asList(greatest[0], greatest[0] + (t1 - t2))));
			}

			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else if (firstList[i][1] > secondList[j][1]) {
				j++;
			} else {
				i++;
				j++;
			}
		}

		int[][] res = new int[intersections.size()][2];
		int ind = 0;
		for (List<Integer> l : intersections) {
			res[ind++] = new int[] { l.get(0), l.get(1) };
		}
		return res;
	}
}
