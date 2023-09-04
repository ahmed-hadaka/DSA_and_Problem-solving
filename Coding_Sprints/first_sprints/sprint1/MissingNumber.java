package coding_interviews1.first_sprints.sprint1;

/*
 * there is different approach to tackle this problem rather than BF. 1- sorting
 * then, loop from 0 to n and compare o(nlogn). 2- using this formula sum =
 * (n*(n+1))/2 o(n). 3- using x_or operator o(n).
 */
// https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int n = nums.length;
		long sum = (n * (n + 1)) / 2; // avoid overflow
		for (int i = 0; i < nums.length; i++) {
			sum -= nums[i];
		}
		return (int) sum;
	}
}
