package coding_interviews1.second_sprints.sprint8;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/find-the-most-competitive-subsequence/description/
public class MostCompetitiveSubsequence {
	public int[] mostCompetitive(int[] nums, int k) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < nums.length; i++) {

			while (!st.isEmpty() && st.peek() > nums[i] && nums.length - i > (k - st.size())) {
				st.pop();
			}
			st.push(nums[i]);
		}
		int[] res = new int[st.size()];
		int i = 0;
		for (int n : st) {
			res[i++] = n;
		}
		return Arrays.copyOf(res, k);
	}
}
