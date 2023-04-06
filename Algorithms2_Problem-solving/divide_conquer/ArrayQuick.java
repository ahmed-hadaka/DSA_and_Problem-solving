package algorithms2_DP.divide_conquer;

public class ArrayQuick {

	private int[] a;

	public static void main(String[] args) {
		ArrayQuick quick = new ArrayQuick();
		quick.a = new int[] { 12, 9, 9, 9, 12 };
		quick.quickSort(0, quick.a.length - 1);
		for (int i : quick.a) {
			System.out.print(i + " ");
		}
	}

	private int nElems;

	public void insert(int value) {
		a[nElems] = value;
		nElems++;
	}

	public int getSize() {
		return nElems;
	}

	public void display() {
		for (int j = 0; j < nElems; j++)
			System.out.print(a[j] + " ");
		System.out.println();
	}

	public void quickSort(int start, int end) {
		if (start >= end)
			return;
		int pivotIndex = partitionIt(start, end);
		quickSort(start, pivotIndex - 1);
		quickSort(pivotIndex + 1, end);
	}

	public int partitionIt(int start, int end) {
		int i = start;
		int pivot = end;
		for (int j = start; j < a.length - 1; j++) {
			if (a[j] < a[pivot]) {
				swap(j, i);
				i++;
			}
		}
		swap(i, pivot);
		return i;
	}

	public void swap(int i, int j) {
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
