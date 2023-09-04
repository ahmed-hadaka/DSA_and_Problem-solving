package coding_interviews1.first_sprints.sprint7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/insert-delete-getrandom-o1/description
class RandomizedSet {
	public static void main(String[] args) {

	}

	Map<Integer, Integer> map; // val to it's index in the list
	List<Integer> list;

	public RandomizedSet() {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			map.put(val, list.size());
			list.add(val);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if (map.containsKey(val)) {
			int ind = map.get(val);
			int lastInd = list.size() - 1;
			int lastVal = list.get(lastInd);
			if (list.size() != 0) {
				swap(ind, lastInd);
				map.put(lastVal, ind);
			}
			list.remove(lastInd);
			map.remove(val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		int index = (int) (Math.random() * list.size());
		return list.get(index);
	}

	private void swap(int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
}