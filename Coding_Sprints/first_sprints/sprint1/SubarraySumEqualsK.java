package coding_interviews1.first_sprints.sprint1;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		int sum = 0, res = 0;
		freqMap.put(0, 1); // initial value
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (freqMap.containsKey(sum - k)) {
				res += freqMap.get(sum - k);
			}
			// increment the frequency
			Integer tempInteger = freqMap.putIfAbsent(sum, 1);
			if (tempInteger != null) {
				freqMap.put(sum, tempInteger + 1);
			}
		}
		return res;
	}

}
