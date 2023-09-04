package coding_interviews1.first_sprints.sprint1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/description/
public class ContainsDuplicateII {
	// using map
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (indexMap.containsKey(nums[i])) {
				if (Math.abs(i - indexMap.get(nums[i])) <= k)
					return true;
			}
			indexMap.put(nums[i], i);
		}
		return false;
	}

	// using set with sliding window

	public boolean containsNearbyDuplicateV1(int[] nums, int k) {
		int left = 0;
		Set<Integer> set = new HashSet<>();
		int i = 0;
		boolean reachedEnd = false;
		// construct first window
		for (; i <= k; i++) {
			if (i == nums.length) {
				reachedEnd = true;
				break;
			}
			set.add(nums[i]);
		}
		if (reachedEnd) {
			if (set.size() != nums.length)
				return true;
			return false;
		}

		if (set.size() != k + 1)
			return true;

		for (; i < nums.length; i++) {
			set.remove(nums[left++]);
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
