package coding_interviews1.first_sprints.sprint4;

// https://leetcode.ca/all/426.html
public class BST_to_DLL {
	TreeNode head, prev;

	public TreeNode treeToDoublyList(TreeNode root) {
		head = root;
		prev = null;

		convert(root);

		head.left = prev;
		prev.right = head;

		return head;
	}

	private void convert(TreeNode root) {

		if (root == null)
			return;
		convert(root.left);

		if (prev == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;

		convert(root.right);
	}
}
