package coding_interviews1.second_sprints.sprint1;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomII {
	public static void main(String[] args) {
		int[][] ess = new int[][] { { 1, 3 }, { 5, 8 }, { 10, 19 }, { 15, 20 }, { 9, 9 } };
		System.out.println(meetingRooms(ess));

	}

	public static int meetingRooms(int intervals[][]) {
		int minRooms = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
		pq.add(intervals[0][1]);
		for (int i = 1; i < intervals.length; i++) {
			int[] interv = intervals[i];
			if (pq.peek() <= interv[0])
				pq.poll();
			else
				minRooms++;
			pq.add(interv[1]);
		}
		return minRooms;
	}
}
