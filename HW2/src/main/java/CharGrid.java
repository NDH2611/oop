
public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int minRow = grid.length, maxRow = -1;
		int minCol = grid[0].length, maxCol = -1;
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j] == ch) {
					if (i < minRow) minRow = i;
					if (i > maxRow) maxRow = i;
					if (j < minCol) minCol = j;
					if (j > maxCol) maxCol = j;
				}
			}
		}
		if (maxRow = -1) {
			return 0;
		}
		return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	private int armlength (char[][] board, int i, int j, int dx, int dy) {
		int count = 0;
		int ch = board[i][j];
		int x = i + dx;
		int y = j + dy;
		while (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] = ch) {
			count ++;
			x += dx;
			y += dy;
		}
		return count;
	}
	public int countPlus() {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				int up = armlength(grid, i, j, -1, 0);
				int down = armlength(grid, i, j, 1, 0);
				int left = armlength(grid, i, j, 0, -1);
				int right = armlength(grid, i, j, 0, 1);
				int len = Math.min(Math.min(up, down), Math.min(left, right));
				if (len >= 2) {
					count ++;
				}
			}
		}
		return count;
	}

}
