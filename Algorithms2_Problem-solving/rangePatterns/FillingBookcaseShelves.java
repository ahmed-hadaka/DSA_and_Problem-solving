package algorithms2_DP.rangePatterns;

import java.util.Arrays;

// https://leetcode.com/problems/filling-bookcase-shelves/
public class FillingBookcaseShelves {

	int[][] Books;
	int ShelfWidth;
	final int MAX = 1000 + 1;
	int[] memory = new int[MAX];

	public int minHeightShelves(int[][] books, int shelfWidth) {
		Books = books;
		ShelfWidth = shelfWidth;
		Arrays.fill(memory, -1);
		return bestSplit(0);
	}

	private int bestSplit(int ind) {
		// base case
		if (ind == Books.length)
			return 0;

		// memoization
		if (memory[ind] != -1)
			return memory[ind];

		// transition
		int totalHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		int totalWidth = 0;
		for (int i = ind; i < Books.length; i++) {
			totalWidth += Books[i][0];
			if (totalWidth > ShelfWidth)
				break;
			maxHeight = Math.max(maxHeight, Books[i][1]);
			totalHeight = Math.min(totalHeight, bestSplit(i + 1) + maxHeight);
		}
		memory[ind] = totalHeight;
		return memory[ind];
	}
}
