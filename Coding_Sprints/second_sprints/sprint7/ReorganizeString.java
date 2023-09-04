package coding_interviews1.second_sprints.sprint7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
// (SAME) https://leetcode.com/problems/distant-barcodes/description/

// https://leetcode.com/problems/reorganize-string/description/
public class ReorganizeString {
	public String reorganizeString(String s) {
		Map<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (null != freqMap.putIfAbsent(c, 1)) {
				freqMap.put(c, freqMap.get(c) + 1);
			}
		}
		int[][] arr = new int[freqMap.size()][2];
		int c = 0;
		for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
			int k = entry.getKey() - 'a';
			int val = entry.getValue();
			arr[c][0] = k;
			arr[c][1] = val;
			c++;
		}

		Arrays.sort(arr, (a, b) -> b[1] - a[1]);
		char[] chArr = new char[s.length()];
		int k = 0, len = 0;
		if (s.length() % 2 == 0)
			len = s.length() - 1;
		else
			len = s.length();
		for (int i = 0; i < arr.length; i++) {
			while (arr[i][1] > 0) {
				chArr[k] = (char) (arr[i][0] + 'a');

				arr[i][1]--;
				k += 2;
				if (!(k == s.length() - 1 && s.length() % 2 == 0))
					k %= len;
			}
		}
		char prev = '#';
		for (char ch : chArr) {
			if (ch == prev) {
				return "";
			} else
				prev = ch;
		}
		return new String(chArr);
	}

}
