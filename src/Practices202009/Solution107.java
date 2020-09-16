package Practices202009;

import java.util.List;
import java.util.Queue;

public class Solution107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		return null;

	}

	// 层次遍历构建二叉树, 左孩子节点的序号是父亲节点序号的2倍，即
	// 若某一节点的序号为i，则它的左右节点序号为2i和2i+1
	// 这里的序号指的是数组的下标+1，从1开始计数
	public TreeNode buildATree(int[] array) {
		if (array.length < 1) {
			return null;
		} else {
			for (int i = 1; i <= array.length / 2; i++) {
				TreeNode root = new TreeNode(array[i-1]);
			}
		}
		return null;

	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}
	}

}
