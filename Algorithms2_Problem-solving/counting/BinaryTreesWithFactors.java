package algorithms2_DP.counting;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/binary-trees-with-factors/

public class BinaryTreesWithFactors {
	int[] nums;
	final int MOD = 1000000007;
	Set<Integer> set = new HashSet<>();
	Map<Integer, Long> memory = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(new BinaryTreesWithFactors().numFactoredBinaryTrees(new int[] { 18, 3, 6, 2 }));
	}

	public int numFactoredBinaryTrees(int[] arr) {
		nums = arr;
		for (int i : arr) {
			set.add(i);
		}
		int count = 0;
		for (int i : arr)
			count += numBinaryTrees(i) % MOD;
		return count;
	}

	private long numBinaryTrees(int num) {
		// memoization
		if (memory.containsKey(num))
			return memory.get(num);

		// transition
		long count = 1;
		for (int i : nums) {
			int firstDivisor = num % i;
			int secondDivisor = num / i;
			if ((firstDivisor == 0) && set.contains(secondDivisor)) {
				count += numBinaryTrees(firstDivisor) * numBinaryTrees(secondDivisor);
			}
		}
		memory.put(num, count);
		return count;
	}

}
