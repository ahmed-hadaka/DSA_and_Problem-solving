package coding_interviews1.first_sprints.sprint8;

public class SmallestStringStartFromLeaf {
	StringBuilder smallest;
	StringBuilder s = new StringBuilder("");

	public String smallestFromLeaf(TreeNode root) {
		getSmallestString(root);
		return smallest.toString();
	}

	private void getSmallestString(TreeNode root) {
		if (root == null)
			return;
		if (root.left == root.right && root.left == null) {
			s.append((char) (root.val + 97));
			s.reverse();
			if (smallest == null || s.compareTo(smallest) < 0)
				smallest = new StringBuilder(s);
			s.reverse();
			s.deleteCharAt(s.length() - 1);
			return;
		}

		s.append((char) (root.val + 97));
		getSmallestString(root.left);
		getSmallestString(root.right);
		s.deleteCharAt(s.length() - 1);
	}
}
