package algorithms2_DP.backtracking;

public class SudokuSolver {

	public static void main(String[] args) {
		SudokuSolver solver = new SudokuSolver();
		solver.solveSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } });
	}

	public void solveSudoku(char[][] board) {
		getSolution(0, 0, board);
		print(board);
	}

	private boolean getSolution(int r, int c, char[][] board) {
		if (r >= 9 || c >= 9)
			return true;

		if (board[r][c] != '.') {
			if (c == 8)
				return getSolution(r + 1, 0, board);
			return getSolution(r, c + 1, board);
		}

		for (int i = 1; i < 10; i++) {
			if (isDistinct(r, c, i, board)) {
				board[r][c] = (char) (i + '0');

				boolean tempAns = false;
				if (c == 8)
					tempAns = getSolution(r + 1, 0, board);
				else
					tempAns = getSolution(r, c + 1, board);
				if (tempAns)
					return true;

				board[r][c] = '.';// backtrack
			}
		}
		return false;
	}

	private boolean isDistinct(int r, int c, int i, char[][] board) {
		// check row & column
		for (int j = 0; j < 9; j++) {
			if (board[j][c] == (char) (i + '0') || board[r][j] == (char) (i + '0'))
				return false;
		}
		// check square
		r = (r / 3) * 3;
		c = (c / 3) * 3;
		for (int j = r; j < (r + 3); j++) {
			for (int j2 = c; j2 < (c + 3); j2++) {
				if (board[j][j2] == (char) (i + '0'))
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
