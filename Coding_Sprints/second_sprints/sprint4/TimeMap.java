package coding_interviews1.second_sprints.sprint4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/time-based-key-value-store/description/
public class TimeMap {
	Map<String, Map<Integer, String>> map;

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (map.containsKey(key)) {
			map.get(key).put(timestamp, value);
		} else {
			Map<Integer, String> tempMap = new TreeMap<>();
			tempMap.put(timestamp, value);
			map.put(key, tempMap);
		}
	}

	public String get(String key, int timestamp) {
		if (map.containsKey(key)) {
			Map<Integer, String> tempMap = map.get(key);
			if (tempMap.containsKey(timestamp))
				return tempMap.get(timestamp);
			String prev = "";
			for (Map.Entry<Integer, String> entry : tempMap.entrySet()) {
				int key1 = entry.getKey();
				String val = entry.getValue();
				if (key1 > timestamp)
					return prev;
				prev = val;
			}
			return prev;
		}
		return "";
	}
}
