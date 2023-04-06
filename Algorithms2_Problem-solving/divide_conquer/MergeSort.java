package algorithms2_DP.divide_conquer;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int[] sortedArr = mergeSort.mergeSort(new int[] { 12, 35, 87, 26, 9, 28, 7 });
		for (int i : sortedArr) {
			System.out.print(i + " ");
		}
	}

	int[] temp;

	public int[] mergeSort(int[] arr) {
		int inputLength = arr.length;
		if (inputLength < 2)
			return arr;
		temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1);
		return arr;
	}

	public void mergeSort(int[] arr, int start, int end) {
		if (start == end)
			return;
		int mid = start + (end - start) / 2;

		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);

		merge(arr, start, mid, end);

	}

	public void merge(int[] arr, int start, int mid, int end) {

		int tempIndex = start;

		int startLeftArr = start;
		int endLeftArr = mid + 1;
		int startRightArr = mid + 1;
		int endRightArr = end + 1;

		while (startLeftArr < endLeftArr && startRightArr < endRightArr) {
			if (arr[startLeftArr] >= arr[startRightArr])
				temp[tempIndex++] = arr[startRightArr++];
			else
				temp[tempIndex++] = arr[startLeftArr++];
		}

		while (startLeftArr < endLeftArr) // handle remaining
			temp[tempIndex++] = arr[startLeftArr++];

		while (startRightArr < endRightArr)
			temp[tempIndex++] = arr[startRightArr++];

		for (int i = start; i <= end; i++)
			arr[i] = temp[i];
	}
}
