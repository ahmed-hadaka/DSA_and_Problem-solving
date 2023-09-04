package coding_interviews1.second_sprints.sprint5;

import java.util.Arrays;

// https://leetcode.com/problems/rotating-the-box/description/
public class RotateTheBox {
	public static void main(String[] args) {
		RotateTheBox t = new RotateTheBox();
		char[][] res = t.rotateTheBox(new char[][] { { '#', '.', '*', '.' }, { '#', '#', '*', '.' } });
		for (char[] cs : res) {
			System.out.println(Arrays.toString(cs));
		}
	}

	public char[][] rotateTheBox(char[][] box) {
		int rows = box.length, cols = box[0].length;
		if (cols < 2)
			return flip(box, rows, cols);
		for (int r = 0; r < rows; r++) {
			for (int c = cols - 2; c >= 0; c--) {
				if (box[r][c] == '#') {
					int t = c;
					while (t + 1 < cols && box[r][t + 1] == '.')
						t++;
					if (c != t) {
						box[r][t] = box[r][c];
						box[r][c] = '.';
					}
				}
			}
		}
		for (char[] cs : box) {
			System.out.println(Arrays.toString(cs));
		}
		return flip(box, rows, cols);
	}

	private char[][] flip(char[][] box, int rows, int cols) {
		char[][] res = new char[cols][rows];
		int tr = -1;
		for (int r = rows - 1; r >= 0; r--) {
			tr++;
			for (int c = 0; c < cols; c++) {
				res[c][tr] = box[r][c];
			}
		}
		return res;
	}
}
