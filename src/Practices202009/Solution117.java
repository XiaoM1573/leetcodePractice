package Practices202009;

import java.util.LinkedList;
import java.util.Queue;

import utils.Node;

public class Solution117 {

	// 层次遍历的思想，队列
	// java中queue数据结构常用方法
	// poll 获取并移除此队列的头，如果此队列为空，则返回 null
	// offer 将指定的元素插入此队列，插入成功返回 true；否则返回 false
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) { // 层次遍历
			int size = queue.size();
			Node pre = null;
			for (int i = 1; i <= size; ++i) {
				Node node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (i != 1) {
					pre.next = node;
				}
				pre = node;
			}
		}
		return root;
	}
}
