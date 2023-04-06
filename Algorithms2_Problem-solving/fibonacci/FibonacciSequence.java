package algorithms2_DP.fibonacci;

// top-down approach
public class FibonacciSequence {
	public static void main(String[] args) {
		System.out.println(fib(6));
	}

	public static int fib(int n) {
		if (n <= 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}
}
