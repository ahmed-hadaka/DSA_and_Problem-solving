package algorithms2_DP.BuildingOutput;

import java.util.Arrays;

public class EditDistance_BildingOutput {
	final int MAX = 500 + 1;
	int[][] memory = new int[MAX][MAX];
	String word1, word2;

	public static void main(String[] args) {
		new EditDistance_BildingOutput().printMinDistance("horse", "ros");// ros
	}

	public void printMinDistance(String word1, String word2) {
		this.word1 = word1;
		this.word2 = word2;
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		System.out.println(getMinDistance(0, 0));
		getMinDistance_print(0, 0);
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
		int nothing = 500, change = 500, remove = 500, insert = 500;
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

	private void getMinDistance_print(int index1, int index2) {
		// base case
		if (index1 == word1.length() && !(index2 == word2.length())) {
			for (int i = index2; i < word2.length(); i++) {
				System.out.println("insert " + word2.charAt(index2));
			}
			return;
		}
		if (index2 == word2.length() && !(index1 == word1.length())) {
			for (int i = index1; i < word1.length(); i++) {
				System.out.println("delete at index " + index1 + " letter " + word1.charAt(index1));
			}
			return;
		} else if (index2 == word2.length() && index1 == word1.length())
			return;

		int optimal = getMinDistance(index1, index2);

		int change = 500, remove = 500, insert = 500;
		if (word1.charAt(index1) == word2.charAt(index2)) {
			getMinDistance_print(index1 + 1, index2 + 1);
			return;
		} else {
			change = 1 + getMinDistance(index1 + 1, index2 + 1);
			remove = 1 + getMinDistance(index1 + 1, index2);
			insert = 1 + getMinDistance(index1, index2 + 1);
		}

		if (change == optimal) {
			System.out.println("In " + word1 + " change letter at original idx " + index1 + " letter "
					+ word1.charAt(index1) + " to letter " + word2.charAt(index2));
			getMinDistance_print(index1 + 1, index2 + 1);
		} else if (remove == optimal) {
			System.out.println("In " + word1 + " delete original idx " + index1 + " letter " + word1.charAt(index1));
			getMinDistance_print(index1 + 1, index2);
		} else if (insert == optimal) {
			System.out.println("In " + word1 + " insert at original idx " + index1 + " letter " + word2.charAt(index2));
			getMinDistance_print(index1, index2 + 1);
		}
	}
}
