package coding_interviews1.first_sprints.sprint6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
public class LCAofBinaryTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// --- recursive sol ~ o(n/2)! TLE ----

		// return rec(root, p, q);

		// -- track parents ----
//		Set<TreeNode> set1 = new HashSet<>();
//		Set<TreeNode> set2 = new HashSet<>();
//		// edge case
//		if (root.val == p.val || root.val == q.val)
//			set1.add(root);
//
//		find(root.left, p, q, set1);
//		find(root.right, p, q, set2);
//
//		return getIntersection(set1, set2);

		// ----- tracking parents (another technique) ------
		Map<Integer, TreeNode> childToParentMap = new HashMap<>();
		childToParentMap.put(root.val, null);
		traverse(root, childToParentMap);

		Set<Integer> set = new HashSet<>();
		while (p != null) {
			set.add(p.val);
			p = childToParentMap.get(p.val);
		}

		while (q != null) {
			if (set.contains(q.val))
				break;
			q = childToParentMap.get(q.val);
		}
		return q;
	}

	// ----- tracking parents (another technique) ------
	private void traverse(TreeNode root, Map<Integer, TreeNode> childToParentMap) {
		if (root.left != null) {
			childToParentMap.put(root.left.val, root);
			traverse(root.left, childToParentMap);
		}
		if (root.right != null) {
			childToParentMap.put(root.right.val, root);
			traverse(root.right, childToParentMap);
		}
	}

	private TreeNode getIntersection(Set<TreeNode> set1, Set<TreeNode> set2) {
		TreeNode resNode = null;
		for (TreeNode treeNode : set2) {
			if (set1.contains(treeNode))
				resNode = treeNode;
		}
		return resNode;
	}

	// -- track parents ----
	private boolean find(TreeNode root, TreeNode p, TreeNode q, Set<TreeNode> set1) {
		if (root == null)
			return false;
		if (root.val == p.val || root.val == q.val)
			return true;

		set1.add(root);

		if (find(root.left, p, q, set1))
			return true;
		if (find(root.right, p, q, set1))
			return true;
		set1.remove(root);
		return false;
	}

	// --- recursive sol ~ o(n/2)! TLE ----
	private TreeNode rec(TreeNode root, TreeNode p, TreeNode q) {
		// left part
		boolean[] a = find(root.left, p, q);
		if ((a[0] && !a[1]) || (a[1] && !a[0]))
			return root;
		if (a[0] && a[1])
			return rec(root.left, p, q);

		// right part
		a = find(root.right, p, q);
		if ((a[0] && !a[1]) || (a[1] && !a[0]))
			return root;
		if (a[0] && a[1])
			return rec(root.right, p, q);

		return null;
	}

	private boolean[] find(TreeNode root, TreeNode p, TreeNode q) {
		boolean[] arr = new boolean[2];
		if (root != null) {
			if (root.val == p.val)
				arr[0] = true;
			if (root.val == q.val)
				arr[1] = true;
			boolean[] temp1 = find(root.left, p, q);
			boolean[] temp2 = find(root.right, p, q);

			arr[0] = temp1[0] || temp2[0] || arr[0];
			arr[1] = temp1[1] || temp2[1] || arr[1];
		}
		return arr;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	@Override
	public int hashCode() {
		return Objects.hash(val);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		return val == other.val;
	}

}
