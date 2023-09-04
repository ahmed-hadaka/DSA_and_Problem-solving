package coding_interviews1.first_sprints.sprint3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/4sum/description/
public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		int n = nums.length;
		Map<Integer, List<int[]>> map = new HashMap<>(n * n);
		Set<List<Integer>> res = new HashSet<>();

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];

				if (map.containsKey(sum)) {
					map.get(sum).add(new int[] { i, j });
				} else {
					List<int[]> container = new ArrayList<>();
					container.add(new int[] { i, j });
					map.put(nums[i] + nums[j], container);
				}
			}
		}

		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int remainSum = target - nums[i] + nums[j];
				if (map.containsKey(remainSum)) {
					for (int[] ks : map.get(remainSum)) {
						if (i != ks[0] && i != ks[1] && j != ks[0] && j != ks[1]) {
							List<Integer> _4Sum = Arrays.asList(nums[i], nums[j], nums[ks[0]], nums[ks[1]]);
							Collections.sort(_4Sum);
							res.add(_4Sum);
						}
					}
				}
			}
		}
		return new ArrayList<>(res);
	}
}
