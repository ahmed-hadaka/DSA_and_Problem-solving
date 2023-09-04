package coding_interviews1.first_sprints.sprint4;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/verifying-an-alien-dictionary/description/
public class VerifyingAlienDictionary {
	// compare every two adjacent words
	Map<Character, Integer> map;

	public boolean isAlienSorted(String[] words, String order) {
		map = new HashMap<>();
		if (words.length == 1)
			return true;
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}

		for (int i = 0; i < words.length - 1; i++) {
			int j = i + 1;
			if (compare(words[i], words[j]) < 0)
				return false;
		}
		return true;
	}

	private int compare(String s1, String s2) {
		String smallest;
		if (s1.length() >= s2.length()) {
			smallest = s2;
		} else {
			smallest = s1;
		}

		for (int i = 0; i < smallest.length(); i++) {
			int c1 = map.get(s1.charAt(i));
			int c2 = map.get(s2.charAt(i));
			if (c1 > c2)
				return -1;
			else if (c1 < c2)
				return 1;
		}
		if (s1.length() == s2.length()) {
			return 1;
		} else {
			if (s1.length() > s2.length())
				return -1;
			else
				return 1;
		}
	}
}
