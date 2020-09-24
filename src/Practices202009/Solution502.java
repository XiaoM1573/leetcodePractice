package Practices202009;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class Solution502 {
	int base, count, maxCount;
	List<Integer> ans = new ArrayList<>();
	TreeNode pre = null; // 中序遍历时，添加一个临时指针，指向上一个节点

	public int[] findMode(TreeNode root) {
		searchBTS(root);
		int[] mode = new int[ans.size()];
		for (int i = 0; i < mode.length; i++) {
			mode[i] = ans.get(i);
		}

		return mode;
	}

	// 中序遍历
	public void searchBTS(TreeNode root) {
		if (root == null) {
			return;
		}
		searchBTS(root.left);

		if (pre == null) { // 遍历到中序遍历的第一个节点
			count = 1;
		} else if (pre.val == root.val) { // 和前面得节的值相同
			count++;
		} else { // 遍历到新值的节点
			count = 1;
		}

		if (count == maxCount) {
			ans.add(root.val);
		}

		if (count > maxCount) {
			maxCount = count;
			ans.clear();
			ans.add(root.val);
		}
		
		pre = root; // 将本节点作为上一个节点

		searchBTS(root.right);
	}
}
