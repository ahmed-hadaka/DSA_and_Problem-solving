package coding_interviews1.second_sprints.sprint5;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-leaves-of-binary-tree/
public class CollectLeavesOfBT {

	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> ansList = new ArrayList<>();
		dfs(root, ansList);

		return ansList;
	}

	private int dfs(TreeNode root, List<List<Integer>> ansList) {
		if (root == null)
			return 0;

		int leftDepth = dfs(root.left, ansList);
		int rightDepth = dfs(root.right, ansList);

		int curDepth = Math.max(leftDepth, rightDepth);

		if (ansList.size() <= curDepth) {
			ansList.add(new ArrayList<>());
		}

		ansList.get(curDepth).add(root.val);
		return curDepth + 1;
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