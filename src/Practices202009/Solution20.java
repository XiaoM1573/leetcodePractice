package Practices202009;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution20 {

//	Map<Integer, Integer> freq = new HashMap<>(); ������mapȷ���о���̫�ã������������dfs���ܵ�
	List<int[]> freq = new ArrayList<int[]>();
	List<Integer> group = new ArrayList<Integer>();
	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates); // �����Ÿ��򣬺����ͳ��Щ
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

		// ��ѡ��ǰ����
		dfs(pos + 1, rest);

		// ��ѡ��ǰ����,���ݸ�����Ƶ��������ѡ���٣�
		// ���ص�һ���������ǣ����ѡ������ȷ���ģ�����һ��������������������е�˧��
		int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
		for (int i = 1; i <= most; i++) {
			group.add(freq.get(pos)[0]);
			// �����iָ����ѡȡ���ٸ���ǰ����
			dfs(pos + 1, rest - i * freq.get(pos)[0]);
		}
		// ���ݣ�ȥ�����ǵ�ѡ�񣬺���Ҫ
		for (int i = 1; i <= most; i++) {
			group.remove(group.size() - 1);
		}
	}
}
