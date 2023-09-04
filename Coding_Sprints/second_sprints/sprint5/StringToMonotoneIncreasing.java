package coding_interviews1.second_sprints.sprint5;

// https://leetcode.com/problems/flip-string-to-monotone-increasing/description/
public class StringToMonotoneIncreasing {
	public int minFlipsMonoIncr(String s) {
		int[][] freq = new int[s.length()][2];
		int ones = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '1')
				ones++;
			freq[i][0] = ones;
		}

		int zeros = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (c == '0')
				zeros++;
			freq[i][1] = zeros;
		}

		int minReplac = Integer.MAX_VALUE;
		int leftOnesSofar = 0, rightZerosSofar = 0;

		for (int k = 0; k <= s.length(); k++) {
			leftOnesSofar = 0;
			rightZerosSofar = 0;
			if (k - 1 >= 0)
				leftOnesSofar = freq[k - 1][0];
			if (k < s.length())
				rightZerosSofar = freq[k][1];
			minReplac = Math.min(rightZerosSofar + leftOnesSofar, minReplac);
		}

		return minReplac;
	}
}
