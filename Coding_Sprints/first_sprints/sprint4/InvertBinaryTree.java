package coding_interviews1.first_sprints.sprint4;

// https://leetcode.com/problems/invert-binary-tree/description/
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root != null) {
			TreeNode cur = root;
			invert(cur);
		}
		return root;
	}

	private void invert(TreeNode root) {
		if (root.left == null && root.right == null)
			return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invert(root.left);
		invert(root.right);
	}
}
