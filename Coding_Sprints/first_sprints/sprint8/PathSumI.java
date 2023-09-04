package coding_interviews1.first_sprints.sprint8;

// https://leetcode.com/problems/path-sum/description/
public class PathSumI {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null)
			return false;
		return rec(root, targetSum);
	}

	private boolean rec(TreeNode root, int tar) {
		if (root == null)
			return false;
		if (root.left == root.right && root.left == null && tar - root.val == 0)
			return true;

		if (rec(root.left, tar - root.val))
			return true;
		return rec(root.right, tar - root.val);
	}
}
