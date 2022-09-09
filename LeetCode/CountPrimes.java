package problems_Java;

public class CountPrimes {
	public static void main(String[] args) {
		System.out.println(countPrimes(31));
	}

	// (Sieve of Eratosthenes) Algorithm
	public static int countPrimes(int n) {
		if (n <= 2)
			return 0;
		boolean[] arr = new boolean[n];
		int limite = (int) Math.sqrt(n);
		for (int i = 2; i <= limite; i++) {
			if (!arr[i]) {
				// mark all multiples of i as true
				for (int j = i * i; j < n; j += i) {
					arr[j] = true;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!arr[i])
				count++;
		}
		return count;
	}

//	private static boolean isPrime(int num) {
//		for (int i = 2; i < num; i++) {
//			if (num % i == 0)
//				return false;
//		}
//		return true;
//	}
//
//	public static int countPrimes(int num, int original) {
//		if (num < 2)
//			return 0;
//		int subRes = 0;
//		if (num != original && isPrime(num)) {
//			subRes = 1 + countPrimes(num - 1, original);
//		} else {
//			subRes = countPrimes(num - 1, original);
//		}
//		return subRes;
//	}
}
