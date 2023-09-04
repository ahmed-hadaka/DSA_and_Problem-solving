package coding_interviews1.second_sprints.sprint2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
public class ReverseSubstringsBetweenParentheses {
	public static void main(String[] args) {
		ReverseSubstringsBetweenParentheses obj = new ReverseSubstringsBetweenParentheses();
		System.out.println(obj.reverseParentheses("(ed(et(oc))el)"));
	}

	public String reverseParentheses(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<>();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ')')
				stack.addLast(c);
			else {
				while (stack.peekLast() != '(') {
					list.add(stack.pollLast());
				}
				stack.pollLast();// (
				stack.addAll(list);
				list.clear();
			}
		}
		StringBuilder str = new StringBuilder("");
		while (!stack.isEmpty()) {
			str.append(stack.pollFirst());
		}
		return str.toString();
	}
}
