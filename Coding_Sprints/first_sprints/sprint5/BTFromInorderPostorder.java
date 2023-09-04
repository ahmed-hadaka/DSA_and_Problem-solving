package coding_interviews1.first_sprints.sprint5;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
public class BTFromInorderPostorder {
	int rootInd;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> mapIndex = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			mapIndex.put(inorder[i], i);
		}
		rootInd = postorder.length - 1;
		return build(0, inorder.length - 1, postorder, mapIndex);
	}

	private TreeNode build(int inStart, int inEnd, int[] post, Map<Integer, Integer> mapIndex) {
		if (inStart > inEnd)
			return null;

		int rootVal = post[rootInd--];
		TreeNode root = new TreeNode(rootVal);

		int newInStart = mapIndex.get(rootVal);

		root.right = build(newInStart + 1, inEnd, post, mapIndex);

		root.left = build(inStart, newInStart - 1, post, mapIndex);

		return root;
	}

}
