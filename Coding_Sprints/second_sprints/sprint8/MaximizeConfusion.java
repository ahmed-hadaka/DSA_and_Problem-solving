package coding_interviews1.second_sprints.sprint8;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/description/
public class MaximizeConfusion {
	public int maxConsecutiveAnswers(String answerKey, int k) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('T', 0);
		map.put('F', 0);
		int l = 0, res = 0;
		for (int r = 0; r < answerKey.length(); r++) {
			char c = answerKey.charAt(r);
			map.put(c, map.get(c) + 1);
			int min = Math.min(map.get('T'), map.get('F'));
			while (min > k) {
				map.put(answerKey.charAt(l), map.get(answerKey.charAt(l)) - 1);
				l++;
				min = Math.min(map.get('T'), map.get('F'));
			}
			res = Math.max(res, r - l + 1);
		}
		return res;
	}
}
