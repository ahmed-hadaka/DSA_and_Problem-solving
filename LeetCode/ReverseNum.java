package problems_Java;

import java.util.Stack;

public class ReverseNum {
	public static void main(String[] args) {
		System.out.println(reverse_num(1234));
	}

	public static int reverse_num(int num) {
		if (num < 0)
			num = -num;
		if (num < 10)
			return num;
		Stack<Integer> st = new Stack<>();
		while (num > 0) {
			st.push(num % 10);
			num /= 10;
		} // num => 0
			// ------------ first solution using another stack -----------------
//		Stack<Integer> t = new Stack<>();
//		while (!st.isEmpty())
//			t.push(st.pop());
//		int retNum = 0;
//		while (!t.isEmpty())
//			retNum = retNum * 10 + t.pop();
//		return retNum;
		// ------------ first solution with some math -----------------
		int ten = 1;
		while (!st.isEmpty()) {
			num = st.pop() * ten + num;
			ten *= 10;
		}
		return num;
	}

}
