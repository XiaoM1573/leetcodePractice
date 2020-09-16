package Practices202009;

import java.util.ArrayList;
import java.util.List;

public class Solution37 {

	private boolean[][] row = new boolean[9][9];
	private boolean[][] column = new boolean[9][9];
	private boolean[][][] block = new boolean[3][3][9];
	private boolean valid = false; // 找到一个解，即可退出

	private List<int[]> spaces = new ArrayList<>();

	public void solveSudoku(char[][] board) {
		// 统计每个数字出现的情况
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					// 如果该位置是空白，则将该位置添加到链表中，便于后面的递归与回溯
					spaces.add(new int[] { i, j });
				} else {
					// 如果该位置是数字，则将每一行/列/子块中的对应的数字置为true，表示该数字已经被使用了
					int digit = board[i][j] - '0';
					row[i][digit - 1] = column[j][digit - 1] = block[i / 3][j / 3][digit - 1] = true;
				}
			}
		dfs(0, board);
	}

	public void dfs(int pos, char[][] board) {
		if (pos == spaces.size()) { // 遍历到最后一个，跳出递归
			valid = true;
			return;
		}
		int posRow = spaces.get(pos)[0], posColumn = spaces.get(pos)[1];
		for (int i = 1; i <= 9 && !valid; i++) {
			if (!row[posRow][i - 1] && !column[posColumn][i - 1] && !block[posRow / 3][posColumn / 3][i - 1]) {
				row[posRow][i - 1] = column[posColumn][i - 1] = block[posRow / 3][posColumn / 3][i - 1] = true;
				board[posRow][posColumn] = (char) ('0' + i);
				dfs(pos + 1, board);
				row[posRow][i - 1] = column[posColumn][i - 1] = block[posRow / 3][posColumn / 3][i - 1] = false;// 回溯			
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(1<<6);
	}
}
