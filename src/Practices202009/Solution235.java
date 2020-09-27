package Practices202009;

import utils.TreeNode;

public class Solution235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			}else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			}else {
				return root;
			}
		}
	}
}
