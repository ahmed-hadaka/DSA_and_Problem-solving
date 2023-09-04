package coding_interviews1.first_sprints.sprint1;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(l.lengthOfLongestSubstring(""));
	}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int res = 0, count = 0;
		int firstCharInd = 0;

		for (int i = 0; i < s.length(); i++) {
			while (set.contains(s.charAt(i))) {
				res = Math.max(res, count);
				set.remove(s.charAt(firstCharInd));
				firstCharInd++;
				count--;
			}
			set.add(s.charAt(i));
			count++;
		}
		return res = Math.max(res, count);
	}

}
