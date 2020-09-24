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
			rs.add(new ArrayList<Integer>(group));// 这一步注意注意
			return;
		}
		dfs(pos + 1, nums);// 不选当前的数

		// 选当前数
		group.add(nums[pos]);
		dfs(pos + 1, nums);
		// 回溯
		group.remove(group.size() - 1);
	}

}
