package coding_interviews1.first_sprints.sprint7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.ca/all/1429.html
public class FirstUnique {

	public static void main(String[] args) {
		// tast case 1------------
		FirstUnique firstUnique = new FirstUnique(new int[] { 2, 3, 5 });
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(5);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(2);
		System.out.println(firstUnique.showFirstUnique());
		firstUnique.add(3);
		System.out.println(firstUnique.showFirstUnique());

		// tast case 2---------
//		FirstUnique firstUnique = new FirstUnique(new int[] { 7, 7, 7, 7, 7, 7 });
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(7);
//		firstUnique.add(3);
//		firstUnique.add(3);
//		firstUnique.add(7);
//		firstUnique.add(17);
//		System.out.println(firstUnique.showFirstUnique());

		// tast case 3----------
//		FirstUnique firstUnique = new FirstUnique(new int[] { 809 });
//		System.out.println(firstUnique.showFirstUnique());
//		firstUnique.add(809);
//		System.out.println(firstUnique.showFirstUnique());
	}

	List<Integer> list;
	Map<Integer, Integer> map; // value ==> index

	public FirstUnique(int[] nums) {
		list = new ArrayList<>();
		map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}
	}

	public int showFirstUnique() {
		if (!list.isEmpty())
			return list.get(0);
		return -1;
	}

	public void add(int val) {
		if (map.containsKey(val)) {
			if (map.get(val) != null) {
				remove(map.get(val));
				map.put(val, null);
			}
		} else {
			list.add(val);
			map.put(val, list.size() - 1);
		}
	}

	private void remove(int ind) {
		int lastVal = list.get(list.size() - 1);
		swap(ind);
		map.put(lastVal, ind);
	}

	private void swap(int ind) {
		list.set(ind, list.get(list.size() - 1));
		list.remove(list.size() - 1);
	}

}
