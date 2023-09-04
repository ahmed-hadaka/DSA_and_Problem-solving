package coding_interviews1.second_sprints.sprint3;

// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
public class FlattenBT_to_LinkedList {
	public void flatten(TreeNode root) {
		dfs(root);
	}

	private TreeNode dfs(TreeNode root) {
		if (root == null)
			return null;

		TreeNode endLeft = dfs(root.left);
		TreeNode endRight = dfs(root.right);
		if (endLeft != null) {
			endLeft.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		return endRight != null ? endRight : endLeft != null ? endLeft : root;
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
