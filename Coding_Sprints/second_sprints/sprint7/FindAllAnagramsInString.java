package coding_interviews1.second_sprints.sprint7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/permutation-in-string/description/
// https://leetcode.com/problems/find-all-anagrams-in-a-string/description

public class FindAllAnagramsInString {
	// sliding window with two hashmaps
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		Map<Character, Integer> pMap = new HashMap<>();
		Map<Character, Integer> sMap = new HashMap<>();
		if (p.length() > s.length())
			return ans;

		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (null != pMap.putIfAbsent(c, 1)) {
				pMap.put(c, pMap.get(c) + 1);
			}
		}

		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (null != sMap.putIfAbsent(c, 1)) {
				sMap.put(c, sMap.get(c) + 1);
			}
			if (i >= p.length() - 1) {// comparing two hashmaps // o(26)
				if (isEqual(sMap, pMap))
					ans.add(l);
				// remove left
				if (sMap.get(s.charAt(l)) > 1) {
					sMap.put(s.charAt(l), sMap.get(s.charAt(l)) - 1);
				} else
					sMap.remove(s.charAt(l));
				l++;
			}

		}
		return ans;
	}

	private boolean isEqual(Map<Character, Integer> sMap, Map<Character, Integer> pMap) {
		boolean ans = true;
		if (sMap.size() == pMap.size()) {
			for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
				char k = entry.getKey();
				int val = entry.getValue();
				if (!(pMap.containsKey(k) && pMap.get(k) == val)) {
					ans = false;
					break;
				}
			}

		} else
			ans = false;
		return ans;
	}

}
