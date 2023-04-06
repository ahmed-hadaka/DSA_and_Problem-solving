package algorithms2_DP.enumeratingChoices;

import java.util.Arrays;

// https://leetcode.com/problems/integer-break/description/
public class IntegerBreak {
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}

	public static int integerBreak(int n) {
		if (n <= 3)
			return n - 1;
		final int MAX = 58 + 1;
		int[] memory = new int[MAX];
		Arrays.fill(memory, -1);
		return getMaxProduct(n, memory);
	}

	private static int getMaxProduct(int n, int[] memory) {
		// base case
		if (n == 1)
			return 1;

		// memorization
		if (memory[n] != -1)
			return memory[n];
		// transition
		int temp = n;
		for (int i = 1; i < n; i++) {
			temp = Math.max(temp, i * getMaxProduct(n - i, memory));
		}
		memory[n] = temp;
		return memory[n];
	}
}
