package Practices202009;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

	List<List<Integer>> rs = new ArrayList<List<Integer>>();
	List<Integer> group = new ArrayList<Integer>();

	public List<List<Integer>> subsets(int[] nums) {
		dfs(0, nums);
		return rs;

	}

	public void dfs(int pos, int[] nums) {
		if (pos == nums.length) {
			rs.add(new ArrayList<Integer>(group));// ��һ��ע��ע��
			return;
		}
		dfs(pos + 1, nums);// ��ѡ��ǰ����

		// ѡ��ǰ��
		group.add(nums[pos]);
		dfs(pos + 1, nums);
		// ����
		group.remove(group.size() - 1);
	}

}
