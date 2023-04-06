package algorithms2_DP.fibonacci;

// tabulation technique
public class Fibonacci_bootom_up {
	public static void main(String[] args) {
		System.out.println(fib(1));
	}

	public static long fib(int num) {
		long a = 1, b = 1, c = 1;

		for (int i = 2; i <= num; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
}
