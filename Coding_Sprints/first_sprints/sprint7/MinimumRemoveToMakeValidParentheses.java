package coding_interviews1.first_sprints.sprint7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
public class MinimumRemoveToMakeValidParentheses {
	public String minRemoveToMakeValid(String s) {
		Stack<List<String>> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == ')') {
				if (c == '(')
					st.push(new ArrayList<>(Arrays.asList("(", Integer.toString(i))));
				else {
					if (!st.isEmpty() && st.peek().get(0) == "(")
						st.pop();
					else
						st.push(new ArrayList<>(Arrays.asList(")", Integer.toString(i))));
				}
			}
		}
		StringBuilder sBuilder = new StringBuilder(s);
		while (!st.isEmpty()) {
			int ind = Integer.parseInt(st.pop().get(1));
			sBuilder.deleteCharAt(ind);
		}
		return sBuilder.toString();
	}
}
