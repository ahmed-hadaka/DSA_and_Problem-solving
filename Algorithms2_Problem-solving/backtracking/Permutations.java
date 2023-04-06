package algorithms2_DP.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 2, 1], [3, 1, 2]]
// [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// [[1, 1, 2], [1, 2, 1],  [2, 1, 1]

// https://leetcode.com/problems/permutations/
public class Permutations {

	public static void main(String[] args) {
		Permutations permutations = new Permutations();
		System.out.println(permutations.permute(new int[] { 1, 1, 2 }));
	}

	List<List<Integer>> permList;
	int[] nums_;

	public List<List<Integer>> permute(int[] nums) {
		permList = new ArrayList<>();
		nums_ = nums;
		getPermutations(0);
		return permList;
	}

	private void getPermutations(int ind) {
		if (ind == nums_.length - 1) {
			List<Integer> list = Arrays.stream(nums_).boxed().toList();
			if (!permList.contains(list))
				permList.add(list);
			return;
		}

		for (int i = ind; i < nums_.length; i++) {
			swap(i, ind);
			getPermutations(ind + 1);
			swap(i, ind); // backtrack

		}

	}

	private void swap(int i, int ind) {
		int temp = nums_[i];
		nums_[i] = nums_[ind];
		nums_[ind] = temp;
	}

}
