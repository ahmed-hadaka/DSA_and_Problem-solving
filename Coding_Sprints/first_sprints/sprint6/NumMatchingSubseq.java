package coding_interviews1.first_sprints.sprint6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/number-of-matching-subsequences/description/
public class NumMatchingSubseq {
	public int numMatchingSubseq(String s, String[] words) {
		// o(n*words[i].len*dup)

		Map<Character, List<Integer>> map = new HashMap<>();
		int count = 0;
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				List<Integer> l = new ArrayList<>();
				map.put(c, l);
			}
			map.get(c).add(count);
			count++;
		}
		int lastPosition, res = 0;
		boolean flag, innerFlag = false;
		for (String str : words) {
			lastPosition = -1;
			flag = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (map.containsKey(c)) {
					List<Integer> indexes = map.get(c);
					innerFlag = false;
					for (int j = 0; j < indexes.size(); j++) {
						if (indexes.get(j) > lastPosition) {
							lastPosition = indexes.get(j);
							innerFlag = true;
							break;
						}
					}
					if (!innerFlag) {
						flag = false;
						break;
					}
				} else {
					flag = false;
					break;
				}
			}
			if (flag)
				res++;
		}
		return res;
	}
}
