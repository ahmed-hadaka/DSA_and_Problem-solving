package algorithms2_DP.enumeratingChoices;

import java.util.Arrays;

// https://leetcode.com/problems/edit-distance/
public class EditDistance {
	final int MAX = 500 + 1;
	int[][] memory = new int[MAX][MAX];
	String word1, word2;

	public int minDistance(String word1, String word2) {
		this.word1 = word1;
		this.word2 = word2;
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		return getMinDistance(0, 0);
	}

	private int getMinDistance(int index1, int index2) {
		// base case
		if (index1 == word1.length())
			return word2.length() - index2;
		if (index2 == word2.length())
			return word1.length() - index1;

		// memoization
		if (memory[index1][index2] != -1)
			return memory[index1][index2];
// "horse", "ros"
		// transitions
		int nothing = 0, change = 0, remove = 0, insert = 0;
		if (word1.charAt(index1) == word2.charAt(index2))
			nothing = getMinDistance(index1 + 1, index2 + 1);
		else {
			change = 1 + getMinDistance(index1 + 1, index2 + 1);
			remove = 1 + getMinDistance(index1 + 1, index2);
			insert = 1 + getMinDistance(index1, index2 + 1);
		}
		memory[index1][index2] = Math.min(Math.min(nothing, change), Math.min(remove, insert));
		return memory[index1][index2];
	}

}
