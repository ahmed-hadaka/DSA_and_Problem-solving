package coding_interviews1.first_sprints.sprint8;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/path-sum-ii/description/
public class PathSumII {
	List<List<Integer>> ans;

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return new ArrayList<>();
		ans = new ArrayList<>();
		rec(root, targetSum, new ArrayList<>());
		return ans;
	}

	private void rec(TreeNode root, int tar, List<Integer> l) {
		if (root == null)
			return;
		if (root.left == root.right && root.left == null && tar - root.val == 0) {
			List<Integer> list = new ArrayList<>(l);
			list.add(root.val);
			ans.add(list);
			return;
		}

		l.add(root.val);
		rec(root.left, tar - root.val, l);
		rec(root.right, tar - root.val, l);
		l.remove(l.size() - 1);
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}