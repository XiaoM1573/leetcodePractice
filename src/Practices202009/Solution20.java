package Practices202009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution20 {

//	Map<Integer, Integer> freq = new HashMap<>(); 这里用map确定感觉不太好，可以在下面的dfs感受到
	List<int[]> freq = new ArrayList<int[]>();
	List<Integer> group = new ArrayList<Integer>();
	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates); // 事先排个序，后面好统计些
		for (int num : candidates) {
			if (freq.isEmpty() || num != freq.get(freq.size() - 1)[0]) {
				freq.add(new int[] { num, 1 });
			} else {
				freq.get(freq.size() - 1)[1]++;
			}
		}
		dfs(0, target);
		return ans;
	}

	public void dfs(int pos, int rest) {

		if (rest == 0) {
			ans.add(new ArrayList<Integer>(group));
			return;
		}

		if (pos == freq.size() || rest < freq.get(pos)[0]) {
			return;
		}

		// 不选择当前的数
		dfs(pos + 1, rest);

		// 若选择当前的数,根据该数的频率来决定选多少；
		// 隐藏的一个条件就是，最多选多少是确定的，感受一下下面这个限制条件，有点帅的
		int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
		for (int i = 1; i <= most; i++) {
			group.add(freq.get(pos)[0]);
			// 这里的i指的是选取多少个当前的数
			dfs(pos + 1, rest - i * freq.get(pos)[0]);
		}
		// 回溯，去除我们的选择，很重要
		for (int i = 1; i <= most; i++) {
			group.remove(group.size() - 1);
		}
	}
}
