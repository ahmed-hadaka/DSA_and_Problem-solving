package coding_interviews1.second_sprints.sprint7;

import java.util.HashMap;
import java.util.Map;

public class Max {

	public static void main(String[] args) {
		Max max = new Max();
		System.out.println(max.characterReplacement("AABABBA", 1));
	}

	public int characterReplacement(String s, int k) {

		Map<Character, Integer> freqMap = new HashMap<>();
		int left = 0, maxCharFreq = 0, res = 0;
		for (int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			// update frequency
			int old = freqMap.getOrDefault(c, 0);
			freqMap.put(c, old + 1);
			maxCharFreq = Math.max(maxCharFreq, old + 1);

			while ((right - left + 1) - maxCharFreq > k) {
				// remove from the current window and update the frequency
				int oldfreq = freqMap.get(s.charAt(left));
				freqMap.put(s.charAt(left), oldfreq - 1);
				left += 1;
			}
			res = Math.max(res, right - left + 1);
		}
		return res;
	}
}
