package coding_interviews1.first_sprints.sprint4;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/balance-a-binary-search-tree/description/
public class BalanceBST {
	public TreeNode balanceBST(TreeNode root) {
		// convert to list
		List<TreeNode> list = new ArrayList<>();
		BST_to_list(list, root);

		// convert list to bbst
		return list_to_BBST(list, 0, list.size() - 1);
	}

	private void BST_to_list(List<TreeNode> l, TreeNode cur) {
		if (cur == null)
			return;

		BST_to_list(l, cur.left);
		l.add(cur);
		BST_to_list(l, cur.right);
	}

	private TreeNode list_to_BBST(List<TreeNode> list, int s, int e) {
		if (s > e)
			return null;

		int mid = (s + e) / 2;

		TreeNode left = list_to_BBST(list, s, mid - 1);
		TreeNode right = list_to_BBST(list, mid + 1, e);

		TreeNode root = list.get(mid);
		root.left = left;
		root.right = right;

		return root;
	}
}
