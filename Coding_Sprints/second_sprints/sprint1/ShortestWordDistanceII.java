package coding_interviews1.second_sprints.sprint1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.codingninjas.com/codestudio/problems/shortest-word-distance-ii_1459114?leftPanelTab=0
public class ShortestWordDistanceII {
	Map<String, List<Integer>> map = new HashMap<>();

	public ShortestWordDistanceII(String[] words) {
		for (int i = 0; i < words.length; i++) {
			map.putIfAbsent(words[i], new ArrayList<>());
			map.get(words[i]).add(i);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> l1 = map.get(word1);
		List<Integer> l2 = map.get(word2);

		int ind1 = 0, ind2 = 0, res = Integer.MAX_VALUE;
		while (ind1 < l1.size() && ind2 < l2.size()) {
			res = Math.min(res, Math.abs(l1.get(ind1) - l2.get(ind2)));
			if (l1.get(ind1) < l2.get(ind2)) {
				ind1++;
			} else {
				ind2++;
			}
		}
		return res;
	}
}
