package coding_interviews1.second_sprints.sprint5;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {
	public int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		fill(map);
		int sum = 0;
		int i = 1;
		for (; i < s.length(); i++) {
			int cur = map.get(s.charAt(i));
			int prev = map.get(s.charAt(i - 1));
			if (cur <= prev)
				sum += prev;
			else
				sum -= prev;
		}
		sum += map.get(s.charAt(i - 1));
		return sum;
	}

	private void fill(Map<Character, Integer> map) {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
}
