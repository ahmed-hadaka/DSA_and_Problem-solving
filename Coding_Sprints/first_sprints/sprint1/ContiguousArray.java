package coding_interviews1.first_sprints.sprint1;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contiguous-array/description/
public class ContiguousArray {
// same concept as subarray sum equal k problem
	public int findMaxLength(int[] nums) {
		// convert 0 to -1
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}
		Map<Integer, Integer> firstIndexOf = new HashMap<>();
		int sum = 0, res = 0;
		firstIndexOf.put(0, -1); // initial value
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (firstIndexOf.containsKey(sum)) {
				res = Math.max(res, i - firstIndexOf.get(sum));
			} else {
				firstIndexOf.put(sum, i);
			}
		}
		return res;
	}

}
