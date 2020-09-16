package Practices202009;

import utils.TreeNode;

public class Solution226 {
	public TreeNode invertTree(TreeNode root) {
		dfs(root);
		return root;
	}

	public void dfs(TreeNode root) {
		if (root == null)
			return;
		TreeNode left = root.left;
		TreeNode right = root.right;
		root.left = right;
		root.right = left;
		dfs(left);
		dfs(right);
	}
}
