package Practices202009;

import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class Solution502 {
	int base, count, maxCount;
	List<Integer> ans = new ArrayList<>();
	TreeNode pre = null; // �������ʱ�����һ����ʱָ�룬ָ����һ���ڵ�

	public int[] findMode(TreeNode root) {
		searchBTS(root);
		int[] mode = new int[ans.size()];
		for (int i = 0; i < mode.length; i++) {
			mode[i] = ans.get(i);
		}

		return mode;
	}

	// �������
	public void searchBTS(TreeNode root) {
		if (root == null) {
			return;
		}
		searchBTS(root.left);

		if (pre == null) { // ��������������ĵ�һ���ڵ�
			count = 1;
		} else if (pre.val == root.val) { // ��ǰ��ýڵ�ֵ��ͬ
			count++;
		} else { // ��������ֵ�Ľڵ�
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
		
		pre = root; // �����ڵ���Ϊ��һ���ڵ�

		searchBTS(root.right);
	}
}
