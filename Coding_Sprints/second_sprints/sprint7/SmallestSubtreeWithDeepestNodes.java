package coding_interviews1.second_sprints.sprint7;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/description/
public class SmallestSubtreeWithDeepestNodes {

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		Map<Integer, int[]> depthMap = new HashMap<>();
		dfs(depthMap, root);
		return getSmallestSubtree(depthMap, root);
	}

	private int dfs(Map<Integer, int[]> depthMap, TreeNode root) {
		if (root == null)
			return 0;

		int leftDepth = dfs(depthMap, root.left);
		int rightDepth = dfs(depthMap, root.right);

		depthMap.put(root.val, new int[] { leftDepth, rightDepth });

		return Math.max(leftDepth, rightDepth) + 1;
	}

	private TreeNode getSmallestSubtree(Map<Integer, int[]> depthMap, TreeNode root) {
		int leftDepth = depthMap.get(root.val)[0];
		int rightDepth = depthMap.get(root.val)[1];

		if (leftDepth == rightDepth)
			return root;

		if (leftDepth > rightDepth)
			return getSmallestSubtree(depthMap, root.left);

		if (leftDepth < rightDepth)
			return getSmallestSubtree(depthMap, root.right);

		return null;
	}

}
