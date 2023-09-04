package coding_interviews1.second_sprints.sprint6;

import java.util.HashSet;
import java.util.Set;
// https://leetcode.com/problems/happy-number/description/

// we can apply Floyd Cycling Detection algo (slow-fast)
public class HappyNumber {
	public static void main(String[] args) {
		HappyNumber happyNumber = new HappyNumber();
		System.out.println(happyNumber.isHappy(19));
	}

	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		while (!set.contains(n)) {
			set.add(n);
			n = squareSum(n);
		}
		return n == 1;
	}

	private int squareSum(int n) {
		int sum = 0;

		while (n > 0) {
			sum += (n % 10) * (n % 10);
			n /= 10;
		}
		return sum;
	}
}
