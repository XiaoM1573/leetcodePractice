package Practices202009;

import java.util.LinkedList;
import java.util.Queue;

import utils.Node;

public class Solution117 {

	// ��α�����˼�룬����
	// java��queue���ݽṹ���÷���
	// poll ��ȡ���Ƴ��˶��е�ͷ������˶���Ϊ�գ��򷵻� null
	// offer ��ָ����Ԫ�ز���˶��У�����ɹ����� true�����򷵻� false
	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) { // ��α���
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
