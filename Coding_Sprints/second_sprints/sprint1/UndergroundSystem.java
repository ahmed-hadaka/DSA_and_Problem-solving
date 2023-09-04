package coding_interviews1.second_sprints.sprint1;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-underground-system/description/
public class UndergroundSystem {
	Map<Integer, Customer> customerDataMap;
	Map<String, int[]> fromToMap;

	public UndergroundSystem() {
		customerDataMap = new HashMap<>();
		fromToMap = new HashMap<>();
	}

	public void checkIn(int id, String stationName, int t) {
		Customer cutomer = new Customer(id, stationName, t);
		customerDataMap.put(id, cutomer);
	}

	public void checkOut(int id, String stationName, int t) {
		if (customerDataMap.containsKey(id)) {
			Customer tempCustomer = customerDataMap.get(id);
			String fromToString = tempCustomer.startStation + "," + stationName;
			int travelTime = t - tempCustomer.startTime;
			if (fromToMap.containsKey(fromToString)) {
				fromToMap.get(fromToString)[0] += travelTime;
				fromToMap.get(fromToString)[1]++;
			} else {
				fromToMap.put(fromToString, new int[] { travelTime, 1 });
			}
			customerDataMap.remove(id);
		}
	}

	public double getAverageTime(String startStation, String endStation) {
		int[] tempArr = fromToMap.get(startStation + "," + endStation);
		return tempArr[0] / (double) tempArr[1];
	}
}

class Customer {
	int id, startTime;
	String startStation;

	public Customer(int id, String startStation, int startTime) {
		this.id = id;
		this.startStation = startStation;
		this.startTime = startTime;
	}
}
