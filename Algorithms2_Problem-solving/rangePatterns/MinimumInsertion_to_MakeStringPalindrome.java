package algorithms2_DP.rangePatterns;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinimumInsertion_to_MakeStringPalindrome {
	char[] chArr;
	final int MAX = 500 + 1;
	int[][] memory = new int[MAX][MAX];

	public int minInsertions(String s) {
		chArr = s.toCharArray();
		for (int[] arr : memory) {
			Arrays.fill(arr, -1);
		}
		return minInsertion(0, chArr.length - 1);
	}

	private int minInsertion(int s, int e) {
		// base case
		if (s > e)
			return 0;

		// memoization
		if (memory[s][e] != -1)
			return memory[s][e];

		// transition
		if (chArr[s] != chArr[e]) {
			int insertLeft = 1 + minInsertion(s, e - 1);
			int insertRight = 1 + minInsertion(s + 1, e);
			memory[s][e] = Math.min(insertLeft, insertRight);
			return memory[s][e];
		}
		return minInsertion(s + 1, e - 1);
	}
}
