package algorithms2_DP.counting;

import java.util.Arrays;

//https://leetcode.com/problems/decode-ways/
public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays o = new DecodeWays();
		System.out.println(o.numDecodings("2611055971756562"));
	}

	static char[] nums;
	static final int MAX = 100 + 1;
	static int[] memory = new int[MAX];

	public int numDecodings(String s) {
		nums = s.toCharArray();
		Arrays.fill(memory, -1);

		return getNumDecoding(0);
	}

	private int getNumDecoding(int ind) {
		// base case
		if (ind == nums.length)
			return 1;
		if (nums[ind] == '0')
			return 0;

		// momoization
		if (memory[ind] != -1)
			return memory[ind];

		// transition
		int numWays = getNumDecoding(ind + 1);
		if (isValidTwoDigites(ind))
			numWays += getNumDecoding(ind + 2);

		memory[ind] = numWays;
		return numWays;
	}

	private boolean isValidTwoDigites(int ind) {
		if (nums[ind] > '2' || nums[ind] == '0' || ind + 1 >= nums.length || (nums[ind + 1] > '6' && nums[ind] == '2'))
			return false;
		return true;
	}
}
