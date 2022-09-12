package problems_java_DS;

import java.util.Map;
import java.util.TreeMap;

public class MostFrequentEven {
	public static void main(String[] args) {
		int[] nums = { 4, 4, 4, 9, 2, 4 };
		System.out.println(mostFrequentEven(nums));
	}

	public static int mostFrequentEven(int[] nums) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) { // even
				if (map.containsKey(nums[i])) {
					int oldVal = map.get(nums[i]);
					map.replace(nums[i], oldVal, oldVal + 1);
				} else {
					map.put(nums[i], 1);
				}
			}
		}
		if (map.isEmpty())
			return -1;
		int max = 0, keyV = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (val > max) {
				max = val;
				keyV = key;
			}
		}
		return keyV;
	}
}
