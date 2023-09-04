package coding_interviews1.second_sprints.sprint4;

import java.util.HashMap;
import java.util.Map;

// http://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
public class LongestSubstringWithAtMostKDistCharacter {

	public int longestSubstring(String s, int k) {
		if (k == 0)
			return 0;
		if (k > s.length())
			return s.length();

		Map<Character, Integer> freqMap = new HashMap<>();
		int left = 0, right = 0;
		int maxLen = 0;
		for (; right < s.length(); right++) {
			char c = s.charAt(right);
			if (null != freqMap.putIfAbsent(c, 1)) {
				freqMap.put(c, freqMap.get(c) + 1);
			}

			while (freqMap.size() > k) {
				maxLen = Math.max(maxLen, right - left);
				freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
				if (freqMap.get(s.charAt(left)) == 0)
					freqMap.remove(s.charAt(left));
				left++;
			}
		}
		maxLen = Math.max(maxLen, right - left);
		return maxLen;
	}
}
