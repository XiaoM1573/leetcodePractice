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

		int[] left = dfs(root.left);// 覆盖左节点 需要的监控数
		int[] right = dfs(root.right); // 覆盖右节点 需要的监控数

		// 3个index
		// index1: 指的root必须要插入一个监控数
		// index2: 指覆盖全树即可，无论root需不要插入监控
		// index3: 指只要满足左右子树满足全覆盖要求即可
		// 从要求上来看 index1 >= index2 >= index3
		int[] num = new int[3];
		num[0] = left[2] + right[2] + 1;// index1 = index3 + 1 即可
		num[1] = Math.min(num[0], Math.min(left[0] + right[1], left[1] + right[0]));// 要计算index2, 要么插入root，要么左右子节点至少插入一个
		num[2] = Math.min(num[0], left[1] + right[1]);
		return num;
	}
}
