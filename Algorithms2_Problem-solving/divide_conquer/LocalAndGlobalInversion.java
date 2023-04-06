package algorithms2_DP.divide_conquer;

// https://leetcode.com/problems/global-and-local-inversions/
public class LocalAndGlobalInversion {

	public static void main(String[] args) {
		LocalAndGlobalInversion inversion = new LocalAndGlobalInversion();
		int[] a = new int[] { 1, 2, 0 };
		System.out.println(inversion.isIdealPermutation(a));
	}

	public boolean isIdealPermutation(int[] nums) {
		if (nums.length == 1)
			return true;
		long localInterv = 0;
		long globalInterv = 0;
		for (int i = 0; i < nums.length - 1; i++) { // count local
			if (nums[i] > nums[i + 1])
				localInterv++;
		}
		globalInterv = mergeSort(nums);
		return localInterv == globalInterv;
	}

	int[] temp;

	public long mergeSort(int[] arr) {
		temp = new int[arr.length];
		return mergeSort(arr, 0, arr.length - 1);
	}

	public long mergeSort(int[] arr, int start, int end) {
		if (start == end)
			return 0;
		int mid = start + (end - start) / 2;

		long globalInterv = mergeSort(arr, start, mid);
		globalInterv += mergeSort(arr, mid + 1, end);

		globalInterv += merge(arr, start, mid, end);

		return globalInterv;
	}

	public long merge(int[] arr, int start, int mid, int end) {

		int tempIndex = start;
		int startLeftArr = start;
		int endLeftArr = mid + 1;
		int startRightArr = mid + 1;
		int endRightArr = end + 1;
		long countGlobalInterv = 0;

		while (startLeftArr < endLeftArr && startRightArr < endRightArr) {
			if (arr[startLeftArr] >= arr[startRightArr]) {
				temp[tempIndex++] = arr[startRightArr++];
				countGlobalInterv += (endLeftArr - 1) - startLeftArr + 1;
			} else
				temp[tempIndex++] = arr[startLeftArr++];
		}
		// handle remaining
		while (startLeftArr < endLeftArr)
			temp[tempIndex++] = arr[startLeftArr++];

		while (startRightArr < endRightArr)
			temp[tempIndex++] = arr[startRightArr++];

		for (int i = start; i <= end; i++)
			arr[i] = temp[i];
		return countGlobalInterv;
	}
}
