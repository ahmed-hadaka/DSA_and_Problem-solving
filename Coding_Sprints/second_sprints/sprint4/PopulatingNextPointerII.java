package coding_interviews1.second_sprints.sprint4;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/description/
public class PopulatingNextPointerII {
	// we can do it using level order traversal
	// recursive approach o(1)space
	public TreeNode connect(TreeNode root) {
		rec(root);
		return root;
	}

	private void rec(TreeNode root) {
		if (root == null)
			return;

		if (root.left != null) {
			if (root.right != null)
				root.left.next = root.right;
			else {
				root.left.next = getNext(root);
			}
		}
		if (root.right != null) {
			root.right.next = getNext(root);
		}

		rec(root.right);
		rec(root.left);
	}

	private TreeNode getNext(TreeNode root) {
		while (root.next != null) {
			if (root.next.left != null) {
				return root.next.left;
			} else if (root.next.right != null) {
				return root.next.right;
			}
			root = root.next;
		}
		return null;
	}

}
