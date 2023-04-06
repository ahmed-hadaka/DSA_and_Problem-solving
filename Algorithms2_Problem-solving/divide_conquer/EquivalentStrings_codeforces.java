package algorithms2_DP.divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://codeforces.com/contest/560/problem/D
public class EquivalentStrings_codeforces { // TLE :(
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s1 = reader.readLine();
		String s2 = reader.readLine();
		if (isEquivalentStrings(s1, s2, s1.length()))
			System.out.println("YES");
		else {
			System.out.println("NO");
		}
	}

	public static boolean isEquivalentStrings(String s1, String s2, int length) {
		// base cases
		if (s1.equals(s2))
			return true;
		if (length % 2 != 0)
			return false;

		int mid = length / 2;

		String a1 = s1.substring(0, mid);
		String b1 = s2.substring(0, mid);
		String a2 = s1.substring(mid, length);
		String b2 = s2.substring(mid, length);

		if (isEquivalentStrings(a1, b1, mid) && isEquivalentStrings(a2, b2, mid)) {
			return true;
		}
		if (isEquivalentStrings(a1, b2, mid) && isEquivalentStrings(a2, b1, mid)) {
			return true;
		}
		return false;
	}
}
