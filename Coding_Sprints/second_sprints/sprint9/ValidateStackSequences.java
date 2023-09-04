package coding_interviews1.second_sprints.sprint9;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/validate-stack-sequences/description/
public class ValidateStackSequences {
	public boolean validateStackSequences(int[] pushed, int[] popped) {
		List<Integer> st = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < pushed.length; i++) {
			st.add(pushed[i]);
			while (!st.isEmpty() && popped[j] == st.get(st.size() - 1)) {
				st.remove(st.size() - 1);
				j++;
			}
		}
		return st.isEmpty();
	}
}
