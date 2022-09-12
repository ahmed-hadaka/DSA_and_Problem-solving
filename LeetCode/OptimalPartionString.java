package problems_java_DS;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartionString {
	public static void main(String[] args) {
		System.out.println(partitionString("sss"));
	}

	public static int partitionString(String s) {
		if (s.length() == 1)
			return 1;
		Set<Character> set = new HashSet<>();
		int count = 0;
		for (Character c : s.toCharArray()) {
			if (set.contains(c)) {
				count++;
				set.clear();
			}
			set.add(c);
		}
		if (!set.isEmpty())
			count++;
		return count;
	}
}
