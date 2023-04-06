package algorithms2_DP.backtracking;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {

	public static void main(String[] args) {
		ValidSudoku validSudoku = new ValidSudoku();
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(validSudoku.isValidSudoku(board));
		validSudoku.print(board);
	}

	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (!isDistinct(i, j, board[i][j], board))
						return false;
				}
			}
		}

		return true;
	}

	private boolean isDistinct(int r, int c, char i, char[][] board) {
		// validate column
		for (int j = 0; j < 9; j++) {
			if (j == r)
				continue;
			if (board[j][c] == i)
				return false;
		}

		// validate row
		for (int j = 0; j < 9; j++) {
			if (j == c)
				continue;
			if (board[r][j] == i)
				return false;
		}

		// check square
		int nr = (r / 3) * 3;
		int nc = (c / 3) * 3;
		for (int j = nr; j < (nr + 3); j++) {
			for (int j2 = nc; j2 < (nc + 3); j2++) {
				if (j == r && j2 == c)
					continue;
				if (board[j][j2] == i)
					return false;
			}
		}
		return true;
	}

	private void print(char[][] board) {
		for (char[] cs : board) {
			for (char c : cs) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}
