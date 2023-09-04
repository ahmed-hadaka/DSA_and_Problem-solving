package coding_interviews1.first_sprints.sprint5;

import java.util.Arrays;

// https://leetcode.com/contest/biweekly-contest-104/problems/sum-in-a-matrix
public class SumInMatrix {
//7, 2, 1 }, { 6, 4, 2 }, { 6, 5, 3 }, { 3, 2, 1
	public static void main(String[] args) {
		System.out.println(matrixSum(new int[][] { { 1 } }));
	}

	public static int matrixSum(int[][] nums) {
		// r*c log(c)
		// [7,2,1] ==>[1, 2, 7]
		// ,[6,4,2]
		// ,[6,5,3]
		// ,[3,2,1]

		int r = nums.length, c = nums[0].length;
		for (int[] is : nums) { // r*clogc
			Arrays.sort(is);
		}
		int max = 0, score = 0;
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				max = Math.max(max, nums[j][i]);
				nums[j][i] = 0;
			}
			score += max;
			max = 0;
		}
		return score;
	}
}
