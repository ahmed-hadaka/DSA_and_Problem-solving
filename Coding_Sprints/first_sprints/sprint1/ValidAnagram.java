package coding_interviews1.first_sprints.sprint1;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> freqMap = new HashMap<>();
		// compute the frequency of the first string
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer tempInteger = freqMap.putIfAbsent(c, 1);
			if (tempInteger != null) {
				freqMap.put(c, tempInteger + 1);
			}
		}
		// compare
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			if (freqMap.containsKey(c)) {
				int charFreq = freqMap.get(c);
				if (charFreq != 0) {
					freqMap.put(c, charFreq - 1);
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
