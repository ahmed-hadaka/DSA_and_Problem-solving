package coding_interviews1.second_sprints.sprint9;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/find-permutation/
public class FindPermutation {
	public ArrayList<Integer> findPerm(final String A, int B) {

		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= B; i++) {
			ans.add(i);
		}

		int sp = 0;
		for (int fp = 0; fp < A.length(); fp++) {
			sp = fp;
			if (A.charAt(sp) == 'D') {
				while (sp < A.length() && A.charAt(sp) == 'D')
					sp++;
				int j = fp + 1;
				for (int i = sp; i >= fp; i--) {
					ans.set(i, j++);
				}
				fp = sp;
			}
		}
		return ans;
	}

}
