package problems_Java;

import java.util.LinkedList;
import java.util.Queue;

public class StackBased_on_a_queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ourStack stack = new ourStack();
		stack.push(3);
		stack.push(4);
		stack.print();

	}

}

class ourStack {
	Queue<Integer> q;

	public ourStack() {
		// TODO Auto-generated constructor stub
		q = new LinkedList<>();
	}

	void push(int val) {
		int s = q.size();
		q.add(val);
		while (s > 0) {
			q.add(q.poll());
			s--;
		}
	}

	int pop() {
		if (!q.isEmpty())
			return q.poll();
		return -1;
	}

	int peek() {
		return q.peek();
	}

	void print() {
		for (Integer i : q) {
			System.out.println(i);
		}
	}

}
//}
