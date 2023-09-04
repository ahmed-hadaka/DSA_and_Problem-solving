package coding_interviews1.first_sprints.sprint5;

// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class BinaryTreeDiameter {
	int ans = 0;

	public int height(TreeNode root) {
		if (root == null)
			return -1;

		int lH = height(root.left) + 1;
		int rH = height(root.right) + 1;

		ans = Math.max(ans, lH + rH);
		return Math.max(lH, rH);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		height(root);
		return ans;
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
