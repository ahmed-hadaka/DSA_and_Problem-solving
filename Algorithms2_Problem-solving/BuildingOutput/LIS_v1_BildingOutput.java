package algorithms2_DP.BuildingOutput;

import java.util.Arrays;

public class LIS_v1_BildingOutput {
	final int MAX = 2500 + 1;
	int[][] memory = new int[MAX][MAX];
	int[] nums;

	public static void main(String[] args) {
		System.out.println(new LIS_v1_BildingOutput().lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
	}

	public int lengthOfLIS(int[] numbers) {
		nums = numbers;
		for (int[] i : memory) {
			Arrays.fill(i, -1);
		}
		LISV1_print(0, memory.length - 1);
		System.out.println();
		return LISV1(0, memory.length - 1);
	}

	// o(n^2) Time & Memory
	private int LISV1(int index, int lastPickedIndex) {
		// base case
		if (index == nums.length)
			return 0;

		// memorization
		if (memory[index][lastPickedIndex] != -1)
			return memory[index][lastPickedIndex];

		// transition
		int choice1 = LISV1(index + 1, lastPickedIndex); // leave it
		int choice2 = 0;

		if (lastPickedIndex == memory.length - 1 || nums[lastPickedIndex] < nums[index]) { // pick it
			choice2 = 1 + LISV1(index + 1, index);
		}

		memory[index][lastPickedIndex] = Math.max(choice1, choice2);
		return memory[index][lastPickedIndex];
	}

	private void LISV1_print(int index, int lastPickedIndex) {
		// base case
		if (index == nums.length)
			return;

		int optimal = LISV1(index, lastPickedIndex);
		int leave = LISV1(index + 1, lastPickedIndex);
//		int pick;

//		if (lastPickedIndex == memory.length - 1 || nums[lastPickedIndex] < nums[index]) { // pick it
//			pick = 1 + LISV1(index + 1, index);
//		}

		if (optimal == leave)
			LISV1_print(index + 1, lastPickedIndex);
		else {
			System.out.print(nums[index] + " ");
			LISV1_print(index + 1, index);
		}
	}
}
