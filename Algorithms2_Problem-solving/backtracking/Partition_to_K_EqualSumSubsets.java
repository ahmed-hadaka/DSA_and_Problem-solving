package algorithms2_DP.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
public class Partition_to_K_EqualSumSubsets {

	public static void main(String[] args) {
		Partition_to_K_EqualSumSubsets o = new Partition_to_K_EqualSumSubsets();
		System.out.println(o.canPartitionKSubsets(new int[] { 960, 3787, 1951, 5450, 4813, 752, 1397, 801, 1990, 1095,
				3643, 8133, 893, 5306, 8341, 5246 }, 6));
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int target = getSum(nums);
		if (target % k != 0 || nums.length < k)
			return false;
		List<ArrayDeque<Integer>> partitions = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			partitions.add(new ArrayDeque<>());
		}
		int partitionSum = target / k;
		int[] curPartitionSum = new int[k];
		return getPossibleSum(0, nums, k, partitions, curPartitionSum, partitionSum);
	}

	private boolean getPossibleSum(int ind, int[] nums, int k, List<ArrayDeque<Integer>> partitions,
			int[] curPartitionSum, int partitionSum) {
		// base case
		if (ind == nums.length)
			return true;

		for (int i = 0; i < k; i++) {
			ArrayDeque<Integer> curPartition = partitions.get(i);
			if (curPartitionSum[i] + nums[ind] <= partitionSum) {
				curPartitionSum[i] += nums[ind];
				curPartition.addFirst(nums[ind]);
				if (getPossibleSum(ind + 1, nums, k, partitions, curPartitionSum, partitionSum))
					return true;
				curPartitionSum[i] -= nums[ind];
				curPartition.removeFirst();
			}
		}
		return false;
	}

	private int getSum(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return sum;
	}

}
