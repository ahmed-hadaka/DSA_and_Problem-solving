package problems_Java;

public class test {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1, 1 };
		System.out.println(longestIncreasingSubArrayEeasy(nums));

	}

	public static int longestIncreasingSubArrayEeasy(int[] nums) {
		int finalMax = 1;
		for (int i = 0; i < nums.length; i++) {
			int max = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[j - 1] && j + 1 > max)
					max++;
				else
					break;
			}
			if (max > finalMax)
				finalMax = max;
		}
		return finalMax;
	}

}
