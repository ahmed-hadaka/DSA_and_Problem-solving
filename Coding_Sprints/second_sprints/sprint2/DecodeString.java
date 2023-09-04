package coding_interviews1.second_sprints.sprint2;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/decode-string/description/
// 3[a2[c]]
//3[a]2[bc]
// 2[abc]3[cd]ef
public class DecodeString {
	public static void main(String[] args) {
		DecodeString decodeString = new DecodeString();
		System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
	}

	StringBuilder str = new StringBuilder("");
	Stack<Integer> st = new Stack<>();
	Map<Integer, Integer> map = new HashMap<>();

	public String decodeString(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[')
				st.push(i);
			if (c == ']')
				map.put(st.pop(), i);
		}
		rec(s, 0, s.length());
		return str.toString();
	}

// 01234567
// 3[a2[c]]
	private void rec(String s, int start, int end) {
		for (int i = start; i < end; i++) {
			char c = s.charAt(i);
			if (!Character.isDigit(c)) {
				str.append(c);
			} else {
				int[] count = getCount(i, s); // return the number value and the end index
				int[] interv = new int[] { count[1] + 1, map.get(count[1]) };
				for (int j = 0; j < count[0]; j++) {
					rec(s, interv[0], interv[1]);
				}
				i = interv[1];
			}
		}
	}

	private int[] getCount(int i, String s) {
		char c = s.charAt(i);
		int val = 0;
		while (Character.isDigit(c)) {
			val *= 10;
			val += (c - '0');
			i++;
			c = s.charAt(i);
		}
		return new int[] { val, i };
	}
}
