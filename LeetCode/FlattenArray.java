package problems_java_DS;

public class FlattenArray {
	public static void main(String[] args) {
		int[][] grid = { { 11, 13, 6, 5 }, { 14, 4, 17, 16 }, { 7, 2, 3, 10 }, { 1, 8, 9, 12 }, };
		int[] res = flattenArray(grid);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
	// 1D => 2D ( i = ind / cols, j = ind % col )
	// 2D => 1D ( ind = i*cols+j )

	public static int[] flattenArray(int[][] arr) {
		int r = arr.length, c = arr[0].length;
		int[] res = new int[c * r];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				res[i * c + j] = arr[i][j];
			}
		}
		return res;
	}

}
