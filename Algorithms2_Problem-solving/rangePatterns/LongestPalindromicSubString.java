package algorithms2_DP.rangePatterns;

import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-substring/description/
public class LongestPalindromicSubString {
	public String longestPalindrome(String s) {
		if (s.length() == 1)
			return s;
		int max = 0;
		String ans = s.substring(0, 1);
		final int MAX_LENGTH = 1000 + 1;
		int[][] memory = new int[MAX_LENGTH][MAX_LENGTH];
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		for (int i = 0; i < s.length() - 1; i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (isPalindrome(i, j, s, memory)) {
					if ((j - i + 1) > max) {
						max = j - i + 1;
						ans = s.substring(i, j + 1);
					}
				}
			}
		}
		return ans;
	}

	private boolean isPalindrome(int n1, int n2, String s, int[][] memory) {
		// base case
		if (n1 >= n2)
			return true;
		// memoization
		if (memory[n1][n2] != -1) {
			return memory[n1][n2] == 0 ? false : true;
		}
		// transitions
		if (s.charAt(n1) == s.charAt(n2)) {
			boolean res = isPalindrome(n1 + 1, n2 - 1, s, memory);
			if (res) {
				memory[n1][n2] = 1; // true
			} else {
				memory[n1][n2] = 0; // false
			}
			return res;
		}
		memory[n1][n2] = 0;
		return false;
	}
}
