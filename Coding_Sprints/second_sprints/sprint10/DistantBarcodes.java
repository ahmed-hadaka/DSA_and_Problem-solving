package coding_interviews1.second_sprints.sprint10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//(SAME) https://leetcode.com/problems/reorganize-string/description/

//https://leetcode.com/problems/remove-k-digits/description/
public class DistantBarcodes {
	public int[] rearrangeBarcodes(int[] barcodes) {
		int[] temp = new int[barcodes.length];
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : barcodes) {
			set.add(i);
			if (null != map.putIfAbsent(i, 1)) {
				map.put(i, map.get(i) + 1);
			}
		}

		int[][] pairs = new int[set.size()][2];
		int j = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			pairs[j++] = new int[] { key, val };
		}

		Arrays.sort(pairs, (a, b) -> b[1] - a[1]);
		j = 0;
		for (int[] is : pairs) {
			while (is[1]-- > 0) {
				temp[j++] = is[0];
			}
		}
		j = 0;
		int i = 0;
		boolean firstTime = true;
		while (j < barcodes.length) {
			i %= barcodes.length;
			if (!firstTime && i == 0 && barcodes.length % 2 == 0)
				i++;

			barcodes[i] = temp[j];

			i += 2;
			j++;
			firstTime = false;
		}

		return barcodes;

	}

}
