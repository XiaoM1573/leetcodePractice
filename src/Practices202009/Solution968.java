package Practices202009;

import utils.TreeNode;

public class Solution968 {
	public int minCameraCover(TreeNode root) {
		int[] minNum = dfs(root);
		return minNum[1];
	}

	public int[] dfs(TreeNode root) {

		if (root == null) {
			return new int[] { Integer.MAX_VALUE / 2, 0, 0 };
		}

		int[] left = dfs(root.left);// ������ڵ� ��Ҫ�ļ����
		int[] right = dfs(root.right); // �����ҽڵ� ��Ҫ�ļ����

		// 3��index
		// index1: ָ��root����Ҫ����һ�������
		// index2: ָ����ȫ�����ɣ�����root�費Ҫ������
		// index3: ָֻҪ����������������ȫ����Ҫ�󼴿�
		// ��Ҫ�������� index1 >= index2 >= index3
		int[] num = new int[3];
		num[0] = left[2] + right[2] + 1;// index1 = index3 + 1 ����
		num[1] = Math.min(num[0], Math.min(left[0] + right[1], left[1] + right[0]));// Ҫ����index2, Ҫô����root��Ҫô�����ӽڵ����ٲ���һ��
		num[2] = Math.min(num[0], left[1] + right[1]);
		return num;
	}
}
