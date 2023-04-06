package algorithms2_DP.rangePatterns;

import java.util.Arrays;

public class MatrixChainMultiplication {

	static int[][] matrices = { { 5, 10 }, { 10, 19 }, { 19, 7 } }; // 1615
	static final int MAX = 100 + 1;
	static int[][] memory = new int[MAX][MAX];

	public static void main(String[] args) {
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}
		System.out.println(mcm(0, matrices.length - 1));
	}

	private static int mcm(int sIndex, int eIndex) { // o(n^3)time, o(n^2)memory
		// base case
		if (sIndex == eIndex)
			return 0;
		// memory
		if (memory[sIndex][eIndex] != -1)
			return memory[sIndex][eIndex];
		// transition
		int totalCost = Integer.MAX_VALUE;
		for (int k = sIndex + 1; k <= eIndex; k++) {
			int left_rightCost = mcm(sIndex, k - 1) + mcm(k, eIndex);
			int Cost = matrices[sIndex][0] * matrices[k - 1][1] * matrices[eIndex][1];
			totalCost = Math.min(totalCost, left_rightCost + Cost);
		}
		return totalCost;
	}
}
