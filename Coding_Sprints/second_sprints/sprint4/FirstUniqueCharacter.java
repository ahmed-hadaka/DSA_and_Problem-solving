package coding_interviews1.second_sprints.sprint4;

import java.util.LinkedHashMap;
import java.util.Map;

// https://leetcode.com/problems/first-unique-character-in-a-string/description/
public class FirstUniqueCharacter {
	public int firstUniqChar(String s) {
		Map<Character, int[]> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (null != map.putIfAbsent(c, new int[] { 1, i })) {
				map.put(c, new int[] { map.get(c)[0] + 1, i });
			}
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.get(c)[0] == 1)
				return map.get(c)[1];
		}
		return -1;
	}
}
