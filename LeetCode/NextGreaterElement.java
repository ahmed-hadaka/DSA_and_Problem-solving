package problems_Java;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/
public class NextGreaterElement {
	public static void main(String[] args) {

	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) { // o(L2 + L1)
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < nums2.length; i++) { // o(L2)

			while (!st.isEmpty() && nums2[i] > nums2[st.peek()]) {
				map.put(nums2[st.pop()], nums2[i]);
			}
			st.push(i);
		}

		for (int i = 0; i < nums1.length; i++) { // o(L1)
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}

}
