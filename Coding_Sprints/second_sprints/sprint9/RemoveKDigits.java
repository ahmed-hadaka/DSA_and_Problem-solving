package coding_interviews1.second_sprints.sprint9;

import java.util.Arrays;
import java.util.LinkedList;

//https://leetcode.com/problems/remove-k-digits/description/
public class RemoveKDigits {
	public static void main(String[] args) {
		RemoveKDigits temp = new RemoveKDigits();
		System.out.println(temp.removeKdigits("10", 1));
	}

	// monotonic stack
	public String removeKdigitsv1(String num, int k) {
		LinkedList<Character> st = new LinkedList<>();
		for (char c : num.toCharArray()) {
			while (!st.isEmpty() && k > 0 && st.peekLast() > c) {
				st.removeLast();
				k--;
			}
			st.addLast(c);
		}

		while (k-- > 0)
			st.removeLast();

		String ans = convert(st);
		return ans.length() == 0 ? "0" : ans;
	}

	private String convert(LinkedList<Character> st) {
		StringBuilder num = new StringBuilder("");
		for (char c : st) {
			if (c == '0') {
				if (num.length() != 0) {
					num.append(c);
				}
			} else {
				num.append(c);
			}
		}
		return num.toString();
	}

	// pick or leave pattern with memorization [MLE]

	int[][] memory;

	public String removeKdigits(String num, int k) {
		memory = new int[1000_00][1000_00];
		for (int[] is : memory) {
			Arrays.fill(is, -1);
		}
		int res = rec(0, num.toCharArray(), k);
		return Integer.toString(res);
	}

//
	public int rec(int idx, char[] chA, int k) {
		if (idx >= chA.length || k <= 0)
			return convert(chA);

		if (memory[idx][k] != -1)
			return memory[idx][k];

		int leave = rec(idx + 1, chA, k);

		char temp = chA[idx];
		chA[idx] = '#';

		int remove = rec(idx + 1, chA, k - 1);

		chA[idx] = temp;

		return memory[idx][k] = Math.min(leave, remove);
	}

	private int convert(char[] chA) {
		int num = 0;
		for (char c : chA) {
			if (c != '#') {
				if (c == '0') {
					if (num != 0) {
						num *= 10;
						num += (c - '0');
					}
				} else {
					num *= 10;
					num += (c - '0');
				}
			}
		}
		return num;
	}

}
