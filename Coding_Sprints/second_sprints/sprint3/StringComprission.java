package coding_interviews1.second_sprints.sprint3;

import java.util.Arrays;

// https://leetcode.com/problems/string-compression/description/
public class StringComprission {
//  'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' 
// 'a','a','b','b','c','c','c'
	public static void main(String[] args) {
		StringComprission obj = new StringComprission();
		char[] chars = new char[] { 'a' };
		System.out.println(obj.compress(chars));
		System.out.println(Arrays.toString(chars));

	}

	public int compress(char[] chars) {
		StringBuilder str = new StringBuilder("");
		for (int i = 0; i < chars.length; i++) {
			str.append(chars[i]);
			if (i + 1 < chars.length && chars[i + 1] == chars[i]) {
				int[] temp = getNum(chars, i + 1, chars[i]);
				int count = temp[0] + 1;
				str.append(Integer.toString(count));
				i = temp[1] - 1;
			}
			str.append(",");
		}
		String s = str.substring(0, str.length() - 1).toString();

		int resLen = 0;
		for (int i = 0; i < s.length(); i++) {
			chars[resLen++] = s.charAt(i);
			if (i + 1 < s.length() && s.charAt(i + 1) != ',') {
				int[] temp = getNumLen(chars, resLen, s, i + 1);
				resLen += temp[0];
				i = temp[1];
			} else {
				i++;
			}

		}
		return resLen;
	}

	private int[] getNumLen(char[] arr, int ind, String s, int i) {
		int num = 0;
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			num++;
			arr[ind++] = s.charAt(i);
			i++;
		}
		return new int[] { num, i };
	}

	private int[] getNum(char[] chars, int i, char c) {
		int num = 0;
		while (i < chars.length && chars[i] == c) {
			num++;
			i++;
		}
		return new int[] { num, i };
	}
}
