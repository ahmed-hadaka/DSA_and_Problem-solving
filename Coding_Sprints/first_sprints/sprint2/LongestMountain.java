package coding_interviews1.first_sprints.sprint2;

// https://leetcode.com/problems/longest-mountain-in-array/description/

/*
*another o(n) solution with 3 passes based on this idea.
*https://leetcode.com/problems/longest-mountain-in-array/solutions/135593/c-java-python-1-pass-and-o-1-space/?orderBy=most_votes
*/
public class LongestMountain {
	// o(n^2)
	public int longestMountain(int[] arr) {
		int longestLen = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			int downs = calcDowns(i, arr);
			int ups = calcUps(i, arr);
			if (downs == 0 || ups == 0)
				continue;
			longestLen = Math.max(longestLen, ups + downs + 1);
		}
		return longestLen;
	}

	private int calcDowns(int e, int[] nums) {
		int downs = 0;
		for (int i = e; i > 0; i--) {
			if (nums[i] > nums[i - 1])
				downs++;
			else
				break;
		}
		return downs;
	}

	private int calcUps(int s, int[] nums) {
		int ups = 0;
		for (int i = s; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				ups++;
			else
				break;
		}
		return ups;
	}
}
