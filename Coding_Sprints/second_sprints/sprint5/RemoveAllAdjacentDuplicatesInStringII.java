package coding_interviews1.second_sprints.sprint5;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/description/
public class RemoveAllAdjacentDuplicatesInStringII {
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesInStringII obj = new RemoveAllAdjacentDuplicatesInStringII();
		System.out.println(obj.removeDuplicates("pbbcggttciiippooaais", 2));
	}

	public String removeDuplicates(String s, int k) {
		Stack<Pair> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!st.isEmpty()) {
				if (st.peek().letter == c) {
					st.peek().freq = st.peek().freq + 1;
					if (st.peek().freq == k)
						st.pop();
				} else {
					st.push(new Pair(c, 1));
				}
			} else {
				st.push(new Pair(c, 1));
			}
		}
		StringBuilder str = new StringBuilder("");
		for (Pair pair : st) {
			int freq = pair.freq;
			while (freq-- > 0) {
				str.append(pair.letter);
			}
		}
		return str.toString();
	}
}

class Pair {
	char letter;
	int freq;

	public Pair(char let, int freq) {
		letter = let;
		this.freq = freq;
	}

}
