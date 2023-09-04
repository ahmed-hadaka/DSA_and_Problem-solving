package coding_interviews1.second_sprints.sprint6;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/
public class NumberOfGoodWaysToSplitString {
	public int numSplits(String s) {
		int[] tempArr = new int[s.length()];
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!set.contains(c))
				set.add(c);
			tempArr[i] = set.size();
		}
		set.clear();
		int count = 0;
		for (int i = s.length() - 1; i > 0; i--) {
			char c = s.charAt(i);
			if (!set.contains(c))
				set.add(c);
			if (set.size() == tempArr[i - 1])
				count++;
		}
		return count;
	}
}
