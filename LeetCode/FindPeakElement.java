package problems_java_DS;

public class FindPeakElement {
	public static void main(String[] args) {

		int[] nums = { 1 };
//		int[] nums = { 3, 4, 3, 2, 1 };
//		int[] nums = { 1, 2, 3, 4 };
//		int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
//		int[] nums = { 1, -1, 2, 3, 5, 6, 4 };
		System.out.println(findPeakElement(nums, 0, nums.length - 1));
	}

	public static int findPeakElement(int[] nums, int s, int e) {
		if (s > e)
			return -1;
		int mid = (s + e) / 2;
		if (mid - 1 < 0) {
			if (nums[mid] > nums[mid + 1])
				return mid;
		} else if (mid + 1 >= nums.length) {
			if (nums[mid] > nums[mid - 1])
				return mid;
		} else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
			return mid;
		int res = findPeakElement(nums, s, mid - 1);
		if (res == -1)
			return findPeakElement(nums, mid + 1, e);
		else {
			return res;
		}

	}

	public int findPeakElement_shorter(int[] nums) {
		int i = 0;
		for (; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return i;
		}
		return i;
	}

}
