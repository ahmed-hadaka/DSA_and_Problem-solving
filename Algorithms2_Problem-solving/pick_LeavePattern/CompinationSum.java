package algorithms2_DP.pick_LeavePattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/combination-sum/description/
public class CompinationSum {
	static List<List<Integer>> ans = new ArrayList<>();
	static Set<List<Integer>> set = new HashSet<>();
	static int[] nums;

	public static void main(String[] args) {
		System.out.println(new CompinationSum().combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		nums = candidates;
		getCompinationSum(0, target, new ArrayList<>());
		return ans;
	}

	private void getCompinationSum(int ind, int target, ArrayList<Integer> list) {
		// base case
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		if (ind == nums.length)
			return;

		// Notes: There is no memoization

		// transition

		getCompinationSum(ind + 1, target, list); // leave

		if (nums[ind] <= target) {
			list.add(nums[ind]);
			getCompinationSum(ind, target - nums[ind], list);// pick
			list.remove(list.size() - 1);
		}
	}
}
