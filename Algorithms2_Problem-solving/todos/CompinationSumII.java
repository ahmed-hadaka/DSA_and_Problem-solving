package algorithms2_DP.todos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
public class CompinationSumII {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> compination = new ArrayList<>();
//	Set<List<Integer>> set = new HashSet<>();
	int[] nums;

	public static void main(String[] args) {
		System.out.println(new CompinationSumII().combinationSum(new int[] { 2, 5, 2, 1, 2 }, 5));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		nums = candidates;
		Arrays.sort(nums);
		getCompinationSum(0, target);
		return ans;
	}

	private void getCompinationSum(int ind, int target) {
		// base case
		if (target == 0) {
//			if (!set.contains(compination)) {
			ans.add(new ArrayList<>(compination));
//				set.add(new ArrayList<>(compination));
//			}
			return;
		}
		if (ind == nums.length)
			return;

		// Notes: There is no memoization

		// transition

		getCompinationSum(ind + 1, target); // leave
		if (nums[ind] <= target) {
			compination.add(nums[ind]);
			getCompinationSum(ind + 1, target - nums[ind]);// pick
			compination.remove(compination.size() - 1);
		}
	}
}
