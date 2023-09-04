package coding_interviews1.first_sprints.sprint2;

// https://leetcode.com/problems/is-subsequence/description/
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		// so, if any one of them is empty, it's a valid case.
		int sIndex = 0, tIndex = 0, count = 0;
		while (sIndex < s.length() && tIndex < t.length()) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				count++;
				sIndex++;
				tIndex++;
			} else
				tIndex++;
		}
		return count == s.length() ? true : false;
	}
}
