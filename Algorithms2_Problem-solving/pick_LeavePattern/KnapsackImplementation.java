package algorithms2_DP.pick_LeavePattern;

import java.util.Arrays;

// https://www.spoj.com/problems/KNAPSACK/
public class KnapsackImplementation {
	public static void main(String[] args) {
		int[] w = { 10, 4, 6, 5, 1 };
		int[] v = { 10, 15, 2, 8, 2 };
		int limit = 21;
		final int MAX = 2000 + 1;
		int[][] memory = new int[MAX][MAX];
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}
		System.out.println(knapSack(0, limit, w, v, memory));
	}

	// follow pick or leave pattern.
	private static int knapSack(int index, int remaining, int[] w, int[] v, int[][] memory) {
		// base case
		if (index == w.length)
			return 0;

		// memorization
		if (memory[index][remaining] != -1)
			return memory[index][remaining];

		// transition
		int choice1 = knapSack(index + 1, remaining, w, v, memory); // leave it
		int choice2 = 0;

		if (remaining >= w[index]) { // pick it
			choice2 = v[index] + knapSack(index + 1, remaining - w[index], w, v, memory);
		}

		memory[index][remaining] = Math.max(choice1, choice2);
		return memory[index][remaining];
	}
}

//10, 4, 20, 5, 7 - 10, 20, 30
//10, 15, 3, 1, 4 == 12 - 60, 100, 120 == 60
