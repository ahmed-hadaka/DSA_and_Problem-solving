package algorithms2_DP.enumeratingChoices;

import java.util.Arrays;

public class PerfectSquares {
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}

	public static int numSquares(int n) {
		final int MAX = 1000 + 1;
		int[] memory = new int[MAX];
		Arrays.fill(memory, -1);
		return minPerfectSqar(n, memory);
	}

	private static int minPerfectSqar(int n, int[] memory) {
		// base case
		if (n <= 0)
			return 0;

		// memory
		if (memory[n] != -1)
			return memory[n];

		// transition
		int temp = Integer.MAX_VALUE;
		for (int i = 1; (i * i) <= n; i++) {
			temp = Math.min(temp, 1 + minPerfectSqar(n - i * i, memory));
		}
		memory[n] = temp;
		return memory[n];
	}
}
