package problems_Java;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbbbb"));
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;
		char[] arr = s.toCharArray();
		int c = 0, max = 0, t = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				if (map.get(arr[i]) == i - 1) { // prev
					c -= (c - 1);
					map.clear();
					map.put(arr[i], i);
				} else {
					map.remove(arr[t++]);
					c--;
					i--;
				}
			} else {
				map.put(arr[i], i);
				c++;
			}
			if (c > max)
				max = c;
		}
		return max;
	}
}
