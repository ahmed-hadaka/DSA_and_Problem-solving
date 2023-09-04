package coding_interviews1.first_sprints.sprint4;

// https://leetcode.ca/all/1120.html
public class MaximumAverageSubtree {
	double max = Double.MIN_VALUE;

	public double maximumAverageSubtree(TreeNode root) {
		maxAvg(root);
		return max;
	}

	private double[] maxAvg(TreeNode root) {
		if (root == null)
			return new double[] { 0, 0 };

		double[] left = maxAvg(root.left);
		double[] right = maxAvg(root.right);

		double sum = left[0] + right[0] + root.val;
		double count = left[1] + right[1] + 1;

		max = Math.max(max, sum / count);

		return new double[] { sum, count };
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
