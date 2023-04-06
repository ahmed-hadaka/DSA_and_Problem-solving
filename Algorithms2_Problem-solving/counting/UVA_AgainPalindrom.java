package algorithms2_DP.counting;
//https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1558

import java.util.Arrays;

public class UVA_AgainPalindrom {
	public static void main(String[] args) {
		UVA_AgainPalindrom uva_AgainPalindrom = new UVA_AgainPalindrom();

		System.out.println(uva_AgainPalindrom.numRemoves("BAOBAB"));
	}

	static char[] chars;
	static final int MAX = 60 + 1;
	static int[][] memory = new int[MAX][MAX];

	public int numRemoves(String s) {
		chars = s.toCharArray();
		for (int[] c : memory) {
			Arrays.fill(c, -1);
		}

		return getNumRemoves(0, chars.length - 1);
	}

	private int getNumRemoves(int s, int e) {
		// base case
		if (s > e)
			return 0;
		if (s == e)
			return 1;

		// momoization
		if (memory[s][e] != -1)
			return memory[s][e];

		// transition
		int res = 0;
		if (chars[s] == chars[e])
			res += (1 + getNumRemoves(s + 1, e - 1));

		res += getNumRemoves(s, e - 1);
		res += getNumRemoves(s + 1, e);

		// remove duplicates
		res -= getNumRemoves(s + 1, e - 1);
		return res;
	}

}
