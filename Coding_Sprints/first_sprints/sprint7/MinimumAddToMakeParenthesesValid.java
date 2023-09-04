package coding_interviews1.first_sprints.sprint7;

import java.util.Stack;

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/
public class MinimumAddToMakeParenthesesValid {
	public int minAddToMakeValid(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(')
				st.push(c);
			else {
				if (!st.isEmpty() && st.peek() == '(')
					st.pop();
				else
					st.push(c);
			}
		}
		return st.size();
	}
}
