package problems_Java;

public class JosephusProblem {
	public static void main(String[] args) {
		int[] res = josephusProblem(7, 14);
		for (int i : res) {
			System.out.print(i + " ");

		}
	}

	public static int[] josephusProblem(int n, int k) {
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		int size = nums.length;
		if (k > size)
			k %= size;
		if (k == 0)
			k = size;
		int i = 0, count = 0;
		int[] res = new int[size];
		int resInd = 0;
		while (size > 0) {
			if (nums[i] != -Integer.MAX_VALUE) {
				count++;
				if (count == k) {
					count = 0; // reset
					size--;
					res[resInd++] = nums[i];
					nums[i] = -Integer.MAX_VALUE;
				}
			}
			i++;
			i %= nums.length;
		}
		return res;
	}

}
