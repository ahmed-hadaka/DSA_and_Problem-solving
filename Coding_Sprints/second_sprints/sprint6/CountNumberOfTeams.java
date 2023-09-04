package coding_interviews1.second_sprints.sprint6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/count-number-of-teams/description/
public class CountNumberOfTeams {
	public int numTeams(int[] rating) {
		Map<Integer, Map<Character, List<Integer>>> map = new HashMap<>();
		int len = rating.length;
		int c = 0;
		for (int i = 0; i < len; i++) {
			map.put(rating[i], new HashMap<>());
			List<Integer> gList = new ArrayList<>();
			List<Integer> sList = new ArrayList<>();

			for (int j = i + 1; j < len; j++) {
				if (rating[j] > rating[i])
					gList.add(rating[j]);
				else {
					sList.add(rating[j]);
				}
			}

			map.get(rating[i]).put('g', gList);
			map.get(rating[i]).put('s', sList);
		}

		for (int i = 0; i < len - 2; i++) {
			List<Integer> gList = map.get(rating[i]).get('g');
			List<Integer> sList = map.get(rating[i]).get('s');
			for (int rate : gList) {
				c += map.get(rate).get('g').size();
			}

			for (int rate : sList) {
				c += map.get(rate).get('s').size();
			}
		}
		return c;
	}
}
