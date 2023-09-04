package coding_interviews1.second_sprints.sprint7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Important observation:-
// putting complete tree's nodes in an array
// ==> arr[i] has children of arr[i*2+1], arr[i*2+2]

// https://leetcode.com/problems/complete-binary-tree-inserter/description/
public class CompleteBTInserter {
	TreeNode root = null;
	List<TreeNode> l = new ArrayList<>();
	Queue<TreeNode> q = new LinkedList<>();

	public CompleteBTInserter(TreeNode root) {
		this.root = root;
		q.add(root);
		int size = 0;
		TreeNode cur = null;
		while (!q.isEmpty()) {
			size = q.size();
			while (size-- > 0) {
				cur = q.poll();
				l.add(cur);
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
		}

	}

	public int insert(int val) {
		TreeNode cur = new TreeNode(val);
		l.add(cur);
		int t = l.size() - 1;
		if (l.get((t - 1) / 2).left == null)
			l.get((t - 1) / 2).left = cur;
		else
			l.get((t - 1) / 2).right = cur;
		return l.get((t - 1) / 2).val;
	}

	public TreeNode get_root() {
		return root;
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
