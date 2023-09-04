package coding_interviews1.first_sprints.sprint2;

import java.util.Arrays;

// https://leetcode.com/problems/shortest-distance-to-a-character/description/
public class ShortestDistToChar {
	public int[] shortestToChar(String s, char c) {
		int[] shortestDistLeft = new int[s.length()];
		int[] shortestDistRight = new int[s.length()];
		Arrays.fill(shortestDistLeft, Integer.MAX_VALUE);
		Arrays.fill(shortestDistRight, Integer.MAX_VALUE);
		int[] shortestDist = new int[s.length()];

		// shortest dist from right
		for (int i = s.length() - 1; i >= 0; i--) {
			char ch = s.charAt(i);
			if (ch == c)
				shortestDistRight[i] = 0;
			else if (i != s.length() - 1 && shortestDistRight[i + 1] != Integer.MAX_VALUE)
				shortestDistRight[i] = shortestDistRight[i + 1] + 1;
		}

		// shortest dist from right then, get the minimum
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == c)
				shortestDistLeft[i] = 0;
			else if (i != 0 && shortestDistLeft[i - 1] != Integer.MAX_VALUE)
				shortestDistLeft[i] = shortestDistLeft[i - 1] + 1;
			shortestDist[i] = Math.min(shortestDistLeft[i], shortestDistRight[i]);
		}
		return shortestDist;
	}
}
