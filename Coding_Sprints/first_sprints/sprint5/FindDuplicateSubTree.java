package coding_interviews1.first_sprints.sprint5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-duplicate-subtrees/description/
public class FindDuplicateSubTree {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		Set<String> tempSet = new HashSet<>();
		Set<String> tempSet2 = new HashSet<>();
		List<TreeNode> res = new ArrayList<>();

		findDup(root.left, tempSet, tempSet2, res);
		findDup(root.right, tempSet, tempSet2, res);

		return res;
	}

	private void findDup(TreeNode root, Set<String> tempSet, Set<String> tempSet2, List<TreeNode> res) {
		// base case
		if (root == null)
			return;

		// process
		String s = getUniqueRep(root);
		if (tempSet.isEmpty() || !tempSet.contains(s)) {
			tempSet.add(s);
		} else { // duplicated
			if (!tempSet2.contains(s)) {
				res.add(root);
				tempSet2.add(s);
			}
		}

		findDup(root.left, tempSet, tempSet2, res);
		findDup(root.right, tempSet, tempSet2, res);
	}

	private String getUniqueRep(TreeNode root) {
		if (root == null)
			return "()";

		String leftRep = getUniqueRep(root.left);
		String rightRep = getUniqueRep(root.right);

		return "(" + Integer.toString(root.val) + leftRep + rightRep + ")";
	}
}
