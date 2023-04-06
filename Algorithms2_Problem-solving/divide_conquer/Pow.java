package algorithms2_DP.divide_conquer;

//https://leetcode.com/problems/powx-n/
public class Pow {
	double fastPow(double x, long n) { // log(n)
		if (n == 0)
			return 1.0;

		double result = fastPow(x, n / 2);

		result *= result;
		if (n % 2 != 0)
			result *= x;

		return result;
	}

	double myPow(double x, int n) {
		long N = n;
		if (N < 0) {
			x = 1 / x;
			N = -N; // -MAX_INT overflows.
		}
		return fastPow(x, N);
	}
}
