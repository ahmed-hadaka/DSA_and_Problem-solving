package coding_interviews1.second_sprints.sprint2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/subdomain-visit-count/description/
public class SubdomainVisitCount {
	public List<String> subdomainVisits(String[] cpdomains) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < cpdomains.length; i++) {
			String cpDomain = cpdomains[i];
			String[] arr = cpDomain.split(" ");
			int num = Integer.parseInt(arr[0]);
			if (null != map.putIfAbsent(arr[1], num)) {
				map.put(arr[1], map.get(arr[1]) + num);
			}
			for (int j = 0; j < arr[1].length(); j++) {
				char c = arr[1].charAt(j);
				if (c == '.') {
					String subDomain = arr[1].substring(j + 1);
					if (null != map.putIfAbsent(subDomain, num)) {
						map.put(subDomain, map.get(subDomain) + num);
					}
				}
			}
		}
		List<String> res = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			String val = Integer.toString(entry.getValue());

			StringBuilder str = new StringBuilder(val).append(" ").append(key);

			res.add(str.toString());
		}
		return res;
	}
}
