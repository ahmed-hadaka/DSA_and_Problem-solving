package problems_Java;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindow {

	public static void main(String[] args) {
		int[] arr = { -7, -8, 7, 5, 7, 1, 6, 0 };
		int[] arr1 = get_max_window(arr, 4);
		for (int i : arr1) {
			System.out.print(i + " ");
		}
	}

	public static int[] get_max_window(int[] nums, int k) { // [-7,-8,7,5,7,1,6,0]
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] ansArr = new int[nums.length - (k - 1)];
		int v = 0;
		int i = 0;
		int ind = 0;
		for (; i < k; i++) { // o(k*k)
			pq.add(nums[i]);// o(k)
		}

		ansArr[ind++] = pq.peek();
		for (; i < nums.length; i++) {
			pq.remove(nums[v++]);
			pq.add(nums[i]);
			ansArr[ind++] = pq.peek();
		}
		return ansArr;
	}

}
