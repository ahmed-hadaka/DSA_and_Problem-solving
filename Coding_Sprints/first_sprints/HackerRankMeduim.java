package coding_interviews1.first_sprints;

import java.util.ArrayList;
import java.util.List;

public class HackerRankMeduim {
	public static void main(String[] args) {
		List<Long> list = new ArrayList<>();
		list.add((long) 0);
		list.add((long) 5);
		list.add((long) 4);
		list.add((long) 3);
		System.out.println(taskOfPairing(list));
	}

	public static long taskOfPairing(List<Long> freq) {
		System.out.println(freq);
		long count = 0;
		for (int i = 0; i < freq.size(); i++) {
			if (freq.get(i) != 0) {
				if (freq.get(i) % 2 == 0) { // even
					if (i != 0 && freq.get(i) != 0 && freq.get(i - 1) == (long) 1) {
						count += 1;
						long t = freq.get(i);
						freq.set(i, t - 1);
						i--;
					} else {
						count += (freq.get(i) / 2);
						freq.set(i, (long) 0);
					}
				} else {
					count += ((freq.get(i) - 1) / 2);
					freq.set(i, (long) 1);
					if (i != 0 && freq.get(i - 1) == (long) 1) {
						count = count + 1;
						freq.set(i - 1, (long) 0);
						freq.set(i, (long) 0);
					}
				}
			}
		}
		return count;

	}
}
