package coding_interviews1.second_sprints.sprint2;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

// https://leetcode.ca/all/716.html
public class MaxStack {
	Map<Integer, Integer> freqMap;
	Stack<Integer> st;

	public MaxStack() {
		freqMap = new TreeMap<>(Collections.reverseOrder());
		st = new Stack<>();
	}

	public void push(int x) {
		st.push(x);
		if (null != freqMap.putIfAbsent(x, 1)) {
			freqMap.put(x, freqMap.get(x) + 1);
		}
	}

	public int pop() {
		int val = st.pop();
		freqMap.put(val, freqMap.get(val) - 1);
		if (freqMap.get(val) == 0)
			freqMap.remove(val);
		return val;
	}

	public int top() {
		return st.peek();
	}

	public int peekMax() {
		int x = 0;
		int maxVal = 0;
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			Integer key = entry.getKey();
			maxVal = key;
			x++;
			if (x == 1)
				break;
		}
		return maxVal;
	}

	public int popMax() {
		int x = 0;
		int maxVal = 0;
		Deque<Integer> temp = new ArrayDeque<>();
		for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
			Integer key = entry.getKey();
			maxVal = key;
			x++;
			if (x == 1)
				break;
		}

		// update map
		freqMap.put(maxVal, freqMap.get(maxVal) - 1);
		if (freqMap.get(maxVal) == 0)
			freqMap.remove(maxVal);

		// remove it from stack using tempList
		while (st.peek() != maxVal) {
			temp.addFirst(st.pop());
		}
		st.pop();
		while (!temp.isEmpty()) {
			st.push(temp.getFirst());
		}
		return maxVal;
	}

}
