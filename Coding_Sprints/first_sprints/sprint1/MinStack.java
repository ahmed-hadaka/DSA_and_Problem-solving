package coding_interviews1.first_sprints.sprint1;

import java.util.ArrayList;

// https://leetcode.com/problems/min-stack/
public class MinStack {
	ArrayList<int[]> list;
	int len = -1;

	public MinStack() {
		list = new ArrayList<>();
	}

	public void push(int val) {
		if (len == -1) {
			list.add(new int[] { val, val });
		} else {
			int prevMin = list.get(len)[1];
			int minSofar = Math.min(val, prevMin);
			list.add(new int[] { val, minSofar });
		}
		len++;
	}

	public void pop() {
		list.remove(len--);
	}

	public int top() {
		return list.get(len)[0];
	}

	public int getMin() {
		return list.get(len)[1];
	}

}
