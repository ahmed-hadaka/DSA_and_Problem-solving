package coding_interviews1.first_sprints.sprint7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST { // o(n) space
	public void recoverTree(TreeNode root) {
		List<Integer> inorderList = new ArrayList<>();
		inorderList = getInorderTrav(root, inorderList);
		List<Integer> temp = new ArrayList<>(inorderList);
		Collections.sort(temp);
		int first = 0, second = 0;
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i) != inorderList.get(i)) {
				first = temp.get(i);
				second = inorderList.get(i);
				break;
			}
		}

		TreeNode firstNode = getNode(root, first);
		TreeNode secondNode = getNode(root, second);

		firstNode.val = second;
		secondNode.val = first;

	}

	private List<Integer> getInorderTrav(TreeNode root, List<Integer> list) {
		if (root == null)
			return null;
		getInorderTrav(root.left, list);
		list.add(root.val);
		getInorderTrav(root.right, list);
		return list;
	}

	private TreeNode getNode(TreeNode root, int val) {
		if (root == null)
			return null;
		if (root.val == val)
			return root;
		TreeNode l = getNode(root.left, val);
		if (l != null)
			return l;
		return getNode(root.right, val);
	}
}
