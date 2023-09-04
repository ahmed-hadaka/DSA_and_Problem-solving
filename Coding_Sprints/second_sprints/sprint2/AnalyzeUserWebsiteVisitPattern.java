package coding_interviews1.second_sprints.sprint2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.ca/all/1152.html
public class AnalyzeUserWebsiteVisitPattern {

	public static void main(String[] args) {
		AnalyzeUserWebsiteVisitPattern obj = new AnalyzeUserWebsiteVisitPattern();
		String[] name = new String[] { "ua", "ua", "ua", "ub", "ub", "ub" };
		int[] timestamp = new int[] { 1, 2, 3, 4, 5, 6 };
		String[] website = new String[] { "a", "b", "a", "a", "b", "c" };
		System.out.println(obj.mostVisitedPattern(name, timestamp, website).toString());
	}

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, List<Pair>> userMap = new HashMap<>();
		Map<String, Integer> siteMap = new HashMap<>();
		for (int i = 0; i < website.length; i++) {
			userMap.computeIfAbsent(username[i], k -> new ArrayList()).add(new Pair(timestamp[i], website[i]));
		}
		for (Map.Entry<String, List<Pair>> entry : userMap.entrySet()) {
			List<Pair> val = entry.getValue();
			Collections.sort(val, (a, b) -> a.time - b.time);
		}

		int maxUsers = 0;
		String mostVisitedSite = "";
		for (Map.Entry<String, List<Pair>> entry : userMap.entrySet()) {
			List<Pair> val = entry.getValue();
			for (int i = 0; i < val.size() - 2; i++) {
				for (int j = i + 1; j < val.size() - 1; j++) {
					for (int k = j + 1; k < val.size(); k++) {
						String str = new StringBuilder(val.get(i).site).append(",").append(val.get(j).site).append(",")
								.append(val.get(k).site).toString();
						if (null != siteMap.putIfAbsent(str, 1)) {
							siteMap.put(str, siteMap.get(str) + 1);
						}
						if (siteMap.get(str) > maxUsers) {
							maxUsers = siteMap.get(str);
							mostVisitedSite = str;
						} else if (siteMap.get(str) == maxUsers) {
							mostVisitedSite = mostVisitedSite.compareTo(str) < 0 ? mostVisitedSite : str;
						}
					}
				}
			}
		}
		return Arrays.asList(mostVisitedSite.split(","));
	}
}

class Pair {
	int time;
	String site;

	public Pair(int time, String site) {
		this.time = time;
		this.site = site;
	}
}
