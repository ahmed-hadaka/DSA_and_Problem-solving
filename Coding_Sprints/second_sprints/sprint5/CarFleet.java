package coding_interviews1.second_sprints.sprint5;

import java.util.Arrays;

// 12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 }
// 0,2,4], speed = [4,2,1]
public class CarFleet {
	public static void main(String[] args) {
		CarFleet carFleet = new CarFleet();
		int res = carFleet.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4, 1, 1, 3 });
		System.out.println(res);
	}

	public int carFleet(int target, int[] position, int[] speed) {
		if (position.length == 1)
			return 1;
		int[][] pairArr = new int[position.length][2];
		for (int i = 0; i < position.length; i++) {
			pairArr[i] = new int[] { position[i], speed[i] };
		}
		Arrays.sort(pairArr, (a, b) -> a[0] - b[0]);
		double[] time = new double[position.length];
		for (int i = 0; i < pairArr.length; i++) {
			time[i] = getTime(pairArr[i][0], pairArr[i][1], target);
		}
		System.out.println(Arrays.toString(time));
		return getCarFleet(time);
	}

	private int getCarFleet(double[] time) {
		int j = 0, c = 0;
		for (int i = 0; i < time.length - 1;) {
			j = i + 1;
			while (j < time.length && Double.compare(time[i], time[j]) <= 0)
				j++;
			i = j;
			c++;
		}
		if (j == time.length - 1)
			c++;
		return c;
	}

	private double getTime(int pos, int spe, int tar) {
		return (tar - pos) / (double) spe;
	}
}
