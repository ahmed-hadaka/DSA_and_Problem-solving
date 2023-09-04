package coding_interviews1.second_sprints.sprint3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/description/
public class LeastNumOfUniqueInteger {
	public static void main(String[] args) {
		LeastNumOfUniqueInteger obj = new LeastNumOfUniqueInteger();
		System.out.println(obj.findLeastNumOfUniqueInts(new int[] { 5, 5, 4 }, 1));
	}

	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

		for (int i : arr) {
			if (null != map.putIfAbsent(i, 1)) {
				map.put(i, map.get(i) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			pq.add(new Integer[] { key, val });
		}

		while (true) {
			Integer[] t = pq.peek();
			if (t[1] > k)
				return pq.size();
			else if (t[1] == k)
				return (pq.size() - 1);
			else {
				k -= t[1];
			}
			pq.poll();
		}
	}
}
