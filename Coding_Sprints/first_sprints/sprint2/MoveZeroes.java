package coding_interviews1.first_sprints.sprint2;

// https://leetcode.com/problems/move-zeroes/description/
public class MoveZeroes {
	// trick (more observations)
	public void moveZeroes(int[] nums) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[k] = nums[i];
				if (k != i)
					nums[i] = 0;
				k++;
			}
		}

	}

	// two pointers approach
//	public void moveZeroes1(int[] nums) {
//		int len = nums.length;
//		if (len == 1)
//			return;
//		int s = 0, e = s + 1;
//		while (s < len && e < len) {
//			while (e < len && s < len && nums[s] != 0 && nums[e] != 0) {
//				s += 2;
//				e += 2;
//			}
//
//			while (e < len && nums[s] == 0 && nums[e] == 0) {
//				e++;
//			}
//
//			if (e < len && s < len && nums[s] != 0 && nums[e] == 0) {
//				s += 1;
//				e += 1;
//				continue;
//			}
//			swap(s, e, nums, len);
//			s += 1;
//			e = s + 1;
//		}
//	}
//
//	private void swap(int s, int e, int[] nums, int len) {
//		if (e < len && s < len) {
//			int temp = nums[s];
//			nums[s] = nums[e];
//			nums[e] = temp;
//		}
//	}
}
