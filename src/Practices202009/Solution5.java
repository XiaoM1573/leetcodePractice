package Practices202009;

public class Solution5 {
	public String longestPalindrome(String s) {
		int n = s.length();
		int[][] dp = new int[n + 1][n + 1];

		int maxLength = 0;
		String ans = "";

		// ����Ҫ�����ȱ���
		for (int j = 1; j <= n; j++)// j �����ַ����Ľ���λ��
			for (int i = 1; i <= j; i++) { // i �ʹ����ַ�������ʼλ��
				if (i == j) {
					dp[i][j] = 1;
					if (maxLength == 0) {
						maxLength = 1;
						ans = String.valueOf((s.charAt(i - 1)));
					}
					continue;
				}

				if (s.charAt(i - 1) == s.charAt(j - 1)) {
					if (dp[i + 1][j - 1] == 1 && j - 1 >= i + 1) {
						dp[i][j] = 1;
						if (j - i + 1 > maxLength) {
							maxLength = j - i + 1;
							ans = s.substring(i - 1, j);
						}
					} else if (j - 1 < i + 1) {
						dp[i][j] = 1;
						if (j - i + 1 > maxLength) {
							maxLength = j - i + 1;
							ans = s.substring(i - 1, j);
						}
					}
				}
			}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(new Solution5().longestPalindrome("cbbd"));
	}
}
