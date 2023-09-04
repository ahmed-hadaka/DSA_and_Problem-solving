package coding_interviews1.first_sprints.sprint3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-right-side-view/description/
public class BinaryTreeRightView {
	int lastLevel = 0;

	public List<Integer> rightSideView(TreeNode root) {
		// bfs solution o(n)
		List<Integer> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		for (int size = 1; !queue.isEmpty(); size = queue.size()) {

			while (size-- > 0) {
				TreeNode tempNode = queue.poll();
				if (size == 0)
					res.add(tempNode.val);
				if (tempNode.left != null)
					queue.add(tempNode.left);
				if (tempNode.right != null)
					queue.add(tempNode.right);
			}
		}

		return res;
		// recursive solution ~ o(n)
//		List<Integer> ans = new ArrayList<>();
//		if (root == null)
//			return ans;
//		ans.add(root.val);
//		return f(root, 1, ans);
	}

	private List<Integer> f(TreeNode root, int level, List<Integer> ans) {
		if (root.right != null) {
			if (level > lastLevel) {
				lastLevel++;
				ans.add(root.right.val);
			}
			f(root.right, level + 1, ans);
			if (root.left != null) {
				f(root.left, level + 1, ans);
			}
		} else if (root.left != null) {
			if (level > lastLevel) {
				lastLevel++;
				ans.add(root.left.val);
			}
			f(root.left, level + 1, ans);
		}
		return ans;
	}

}

// Definition for a binary tree node.
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
