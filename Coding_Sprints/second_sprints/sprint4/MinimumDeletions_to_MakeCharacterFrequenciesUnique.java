package coding_interviews1.second_sprints.sprint4;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/
public class MinimumDeletions_to_MakeCharacterFrequenciesUnique {
	public static void main(String[] args) {
		MinimumDeletions_to_MakeCharacterFrequenciesUnique obj = new MinimumDeletions_to_MakeCharacterFrequenciesUnique();
		System.out.println(obj.minDeletions("ceabaacb"));
	}

	public int minDeletions(String s) {
		if (s.length() == 1)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		Map<Integer, Stack<Character>> freqMap = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (null != map.putIfAbsent(c, 1)) {
				map.put(c, map.get(c) + 1);
			}
		}

		int maxFreq = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Character key = entry.getKey();
			Integer val = entry.getValue();
			maxFreq = Math.max(maxFreq, val);
			freqMap.computeIfAbsent(val, st -> new Stack<>()).push(key);
		}

		int j, minDeletions = 0;
		for (int i = 1; i <= maxFreq; i++) {
			while (freqMap.containsKey(i) && freqMap.get(i).size() > 1) {
				j = i;
				while (freqMap.containsKey(j)) {
					j--;
				}
				minDeletions += (i - j);
				char c = freqMap.get(i).pop();
				if (j > 0) {
					freqMap.computeIfAbsent(j, k -> new Stack<>()).push(c);
				}
			}
		}
		return minDeletions;
	}

}
