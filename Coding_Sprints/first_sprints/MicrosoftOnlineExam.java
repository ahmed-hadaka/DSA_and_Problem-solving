package coding_interviews1.first_sprints;

import java.util.Arrays;

public class MicrosoftOnlineExam {

	public static void main(String[] args) {

		MicrosoftOnlineExam temp = new MicrosoftOnlineExam();
		int len = temp.solution(new int[] { 1, 4, 3, 5 }, new int[] { 3, 4 });
		System.out.println(len);
	}

	public int solution(int[] A, int[] B) {
		int len = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if (isMatch(i, j, A, B)) {
					len = Math.min(len, j - i + 1);
					break;
				}
			}
			if (len == B.length) {
				return len;
			}
		}
		return len;
	}

	public boolean isMatch(int i, int j, int[] A, int[] B) {
		int[] temp = new int[j - i + 1];
		int count = 0;
		for (int l = i; l <= j; l++, count++) {
			temp[count] = A[l];
		}
		Arrays.sort(temp);
		for (int k = 0; k < B.length; k++) {
			int ind = Arrays.binarySearch(temp, B[k]);
			if (ind < 0)
				return false;
		}
		return true;
	}
}
