package coding_interviews1.second_sprints.sprint6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// https://leetcode.com/problems/find-k-closest-elements/description/
public class FindKClosestElements {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		Map<Integer, Queue<Integer>> map = new TreeMap<>();
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int t = Math.abs(arr[i] - x);
			if (map.containsKey(t)) {
				map.get(t).add(arr[i]);
			} else
				map.computeIfAbsent(t, c -> new LinkedList<>()).add(arr[i]);
		}

		for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
			Queue<Integer> val = entry.getValue();
			while (!val.isEmpty() && k > 0) {
				res.add(val.poll());
				k--;
			}
			if (k <= 0)
				break;
		}
		Collections.sort(res);
		return res;
	}
}
