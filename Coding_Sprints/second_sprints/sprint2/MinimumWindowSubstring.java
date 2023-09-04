package coding_interviews1.second_sprints.sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TLE
// https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubstring {
	Map<Character, List<Integer>> indeces = new HashMap<>();
	Map<Character, Integer> freqMap = new HashMap<>();

	public String minWindow(String s, String t) {
		if (t.length() > s.length())
			return "";
		// fill map1
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			indeces.computeIfAbsent(c, l -> new ArrayList()).add(i);
		}

		// fill map2
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (null != freqMap.putIfAbsent(c, 1)) {
				freqMap.put(c, freqMap.get(c) + 1);
			}
		}

		String min = s + "e";
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			Character key = entry.getKey();
			List<Integer> list = indeces.get(key);
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					int ind = list.get(i);
					String temp = getShortestStringStartAt(ind, s, new HashMap<>(freqMap));
					min = (temp.length() < min.length() && temp.length() != 0) ? temp : min;
					if (min.length() == t.length())
						return min;
				}
			}
		}
		return min.length() == s.length() + 1 ? "" : min;
	}

	private String getShortestStringStartAt(int ind, String s, Map<Character, Integer> freqMap) {
		StringBuilder st = new StringBuilder("");
		for (int j = ind; j < s.length(); j++) {
			char c = s.charAt(j);
			st.append(c);
			if (freqMap.containsKey(c)) {
				freqMap.put(c, freqMap.get(c) - 1);
				if (freqMap.get(c) == 0) {
					freqMap.remove(c);
				}
			}
			if (freqMap.isEmpty())
				return st.toString();
		}
		return "";
	}
}
