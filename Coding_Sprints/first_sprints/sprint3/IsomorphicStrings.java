package coding_interviews1.first_sprints.sprint3;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicStrings {
	public static void main(String[] args) {
		String string = "sf d";
		System.out.println(string.charAt(2));
	}

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;

		Map<Character, Character> charMap = new HashMap<>();
		int n = t.length();
		for (int i = 0; i < n; i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if (charMap.isEmpty() || !charMap.containsKey(c1)) {
				charMap.put(c1, c2);
			} else {
				if (charMap.get(c1) != c2)
					return false;
			}
		}
		return true;
	}

}
