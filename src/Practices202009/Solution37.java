package Practices202009;

import java.util.ArrayList;
import java.util.List;

public class Solution37 {

	private boolean[][] row = new boolean[9][9];
	private boolean[][] column = new boolean[9][9];
	private boolean[][][] block = new boolean[3][3][9];
	private boolean valid = false; // �ҵ�һ���⣬�����˳�

	private List<int[]> spaces = new ArrayList<>();

	public void solveSudoku(char[][] board) {
		// ͳ��ÿ�����ֳ��ֵ����
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					// �����λ���ǿհף��򽫸�λ����ӵ������У����ں���ĵݹ������
					spaces.add(new int[] { i, j });
				} else {
					// �����λ�������֣���ÿһ��/��/�ӿ��еĶ�Ӧ��������Ϊtrue����ʾ�������Ѿ���ʹ����
					int digit = board[i][j] - '0';
					row[i][digit - 1] = column[j][digit - 1] = block[i / 3][j / 3][digit - 1] = true;
				}
			}
		dfs(0, board);
	}

	public void dfs(int pos, char[][] board) {
		if (pos == spaces.size()) { // ���������һ���������ݹ�
			valid = true;
			return;
		}
		int posRow = spaces.get(pos)[0], posColumn = spaces.get(pos)[1];
		for (int i = 1; i <= 9 && !valid; i++) {
			if (!row[posRow][i - 1] && !column[posColumn][i - 1] && !block[posRow / 3][posColumn / 3][i - 1]) {
				row[posRow][i - 1] = column[posColumn][i - 1] = block[posRow / 3][posColumn / 3][i - 1] = true;
				board[posRow][posColumn] = (char) ('0' + i);
				dfs(pos + 1, board);
				row[posRow][i - 1] = column[posColumn][i - 1] = block[posRow / 3][posColumn / 3][i - 1] = false;// ����			
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(1<<6);
	}
}
