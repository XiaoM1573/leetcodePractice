package Practices202009;

import java.util.List;
import java.util.Queue;

public class Solution107 {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		return null;

	}

	// ��α�������������, ���ӽڵ������Ǹ��׽ڵ���ŵ�2������
	// ��ĳһ�ڵ�����Ϊi�����������ҽڵ����Ϊ2i��2i+1
	// ��������ָ����������±�+1����1��ʼ����
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
