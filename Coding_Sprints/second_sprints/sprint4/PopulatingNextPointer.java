package coding_interviews1.second_sprints.sprint4;

// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
public class PopulatingNextPointer {
//recursive o(1) recursive stack is dropped -------------
	public TreeNode connect(TreeNode root) {
		if (!(root == null || root.left == null))
			rec(root);
		return root;

	}

	private void rec(TreeNode root) {
		if (root == null)
			return;
		if (root.left != null) { // or right
			root.left.next = root.right;

			if (root.next != null) {
				root.right.next = root.next.left;
			}
		}

		rec(root.left);
		rec(root.right);
	}

//level order traversal o(n) space-----------

	// public TreeNode connect(TreeNode root) {
	// if(root == null || root.left == null)
	// return root;
	// return levleOrderTrav(root);

	// }
//	private TreeNode levleOrderTrav(TreeNode root) {
//		Queue<TreeNode> q = new LinkedList<>();
//		q.add(root);
//		int size = 0;
//		TreeNode prev = null;
//		while (!q.isEmpty()) {
//			size = q.size();
//			prev = null;
//			while (size-- > 0) {
//				TreeNode cur = q.poll();
//				if (prev != null)
//					prev.next = cur;
//				if (cur.left != null) {
//					q.add(cur.left);
//					q.add(cur.right);
//				}
//				prev = cur;
//			}
//		}
//		return root;
//	}

}

//Definition for a TreeNode.
class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode() {
	}

	public TreeNode(int _val) {
		val = _val;
	}

	public TreeNode(int _val, TreeNode _left, TreeNode _right, TreeNode _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
};
