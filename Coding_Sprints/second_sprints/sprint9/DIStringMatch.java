package coding_interviews1.second_sprints.sprint9;

// https://leetcode.com/problems/di-string-match/description/
public class DIStringMatch {
	public int[] diStringMatch(String s) {

		// we can use this problem's approach
		// https://leetcode.com/problems/find-permutation/

		// but we can make use of any 'any permutation will be valid'
		int min = 0, max = s.length();
		int[] res = new int[s.length() + 1];
		int i = 0;
		for (; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'D') {
				res[i] = max--;
			} else
				res[i] = min++;
		}
		res[i] = min;
		return res;
	}
}
