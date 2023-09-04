package coding_interviews1.first_sprints;

public class RaisaEnergyOnlineExam {
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 5, 7, 19, 9, 11 };
		int[][] memory = new int[nums.length][250];
		System.out.println(rec(nums, memory, 0, 30));// 2
	}

	private static int rec(int[] nums, int[][] memory, int ind, int tar) {
		// base case
		if (tar == 0)
			return 0;
		if (ind >= nums.length || tar < 0)
			return 250;
		// Memorization
		if (memory[ind][tar] != 0)
			return memory[ind][tar];

		int leav = rec(nums, memory, ind + 1, tar);
		int pick = rec(nums, memory, ind + 1, tar - nums[ind]) + 1;

		memory[ind][tar] = Math.min(leav, pick);
		return memory[ind][tar];
	}
}
