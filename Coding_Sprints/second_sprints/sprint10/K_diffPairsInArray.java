package coding_interviews1.second_sprints.sprint10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
// like TwoSum problem but, Unique pairs only
public class K_diffPairsInArray {
	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int prev = Integer.MIN_VALUE, c = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			while (nums[i] == prev) {
				i++;
				if (i >= nums.length)
					return c;
			}
			if (Arrays.binarySearch(nums, i + 1, nums.length, nums[i] + k) > 0)
				c++;
			prev = nums[i];
		}
		return c;
	}

//	o(n) hashmap

	public int findPairs1(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				// count how many elements in the array that appear more than twice.
				if (entry.getValue() >= 2) {
					count++;
				}
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}

		return count;
	}
}
