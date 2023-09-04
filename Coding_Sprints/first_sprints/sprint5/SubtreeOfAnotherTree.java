package coding_interviews1.first_sprints.sprint5;

// https://leetcode.com/problems/subtree-of-another-tree/
public class SubtreeOfAnotherTree {
// another easier approach based on string representation of a tree
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		return traverse(root, subRoot);
	}

	private boolean traverse(TreeNode r1, TreeNode r2) {
		if (r1 == null)
			return false;

		if (r1.val == r2.val)
			if (checkIdentity(r1, r2))
				return true;

		if (traverse(r1.left, r2))
			return true;

		return traverse(r1.right, r2);
	}

	private boolean checkIdentity(TreeNode r1, TreeNode r2) {
		if (r1 == r2 && r1 == null)
			return true;

		if (r1 == null || r2 == null || r1.val != r2.val)
			return false;

		return checkIdentity(r1.left, r2.left) && checkIdentity(r1.right, r2.right);
	}

}
