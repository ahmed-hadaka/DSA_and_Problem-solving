package algorithms2_DP.fibonacci;

import java.util.Arrays;

public class FibonacciMemoization {
	static long[] memory = new long[81];

	public static void main(String[] args) {
		Arrays.fill(memory, -1);
		System.out.println(fib(80));
	}

	public static long fib(int num) {
		// base case
		if (num <= 1)
			return 1;
		// transition
		if (memory[num] != -1)
			return memory[num];
		return memory[num] = fib(num - 1) + fib(num - 2);
	}
}
