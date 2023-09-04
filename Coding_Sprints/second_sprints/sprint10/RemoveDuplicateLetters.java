package coding_interviews1.second_sprints.sprint10;

import java.util.LinkedList;

// https://leetcode.com/problems/remove-duplicate-letters/description/
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] freq = new int[26];
		boolean[] visited = new boolean[26];
		calcFreq(s, freq);
		LinkedList<Character> st = new LinkedList<>();
		for (char c : s.toCharArray()) {

			while (!st.isEmpty() && st.peekLast() > c && freq[st.peekLast() - 'a'] > 0 && !visited[c - 'a']) {
				visited[st.removeLast() - 'a'] = false;
			}

			if (!visited[c - 'a']) {
				st.addLast(c);
				visited[c - 'a'] = true;
			}
			freq[c - 'a']--;
		}
		StringBuilder stringBuilder = new StringBuilder("");
		for (char c : st) {
			stringBuilder.append(c);
		}
		return stringBuilder.toString();
	}

	private void calcFreq(String s, int[] freq) {
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
	}

}
