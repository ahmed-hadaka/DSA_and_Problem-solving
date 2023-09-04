package coding_interviews1.first_sprints.sprint7;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-search-tree-iterator/description/
public class BSTIterator {
	List<Integer> list;
	int pointer;

	public BSTIterator(TreeNode root) {
		list = new ArrayList<>();
		pointer = -1;
		doInorderTrav(root);
	}

	public int next() {
		pointer++;
		return list.get(pointer);
	}

	public boolean hasNext() {
		if (pointer >= list.size() - 1)
			return false;
		return true;
	}

	private void doInorderTrav(TreeNode root) {
		if (root == null)
			return;
		doInorderTrav(root.left);
		list.add(root.val);
		doInorderTrav(root.right);
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