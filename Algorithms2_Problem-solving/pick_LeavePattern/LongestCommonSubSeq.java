package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubSeq {
	public int longestCommonSubsequence(String text1, String text2) {
		final int MAX = 1000 + 1;
		int[][] memory = new int[MAX][MAX];
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		return LCS(0, 0, text1, text2, memory);
	}

	// o(n*m), n = text1.length, m = text2.length
	private int LCS(int index1, int index2, String text1, String text2, int[][] memory) {
		// base case
		if (index1 == text1.length() || index2 == text2.length())
			return 0;

		// memorization
		if (memory[index1][index2] != -1)
			return memory[index1][index2];

		// transition
		int choice1, choice2, choice3;
		choice1 = choice2 = choice3 = 0;
		if (text1.charAt(index1) == text2.charAt(index2))
			choice1 = 1 + LCS(index1 + 1, index2 + 1, text1, text2, memory);
		else {
			choice2 = LCS(index1, index2 + 1, text1, text2, memory);
			choice3 = LCS(index1 + 1, index2, text1, text2, memory);
		}
		memory[index1][index2] = Math.max(Math.max(choice1, choice2), choice3);
		return memory[index1][index2];
	}
}
