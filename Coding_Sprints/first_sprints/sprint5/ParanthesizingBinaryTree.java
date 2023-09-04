package coding_interviews1.first_sprints.sprint5;

public class ParanthesizingBinaryTree {
	public static void main(String[] args) {
		String string = "(3(4(1()())(2(0()())()))(5()()))";
		String string2 = "(4(1()())(2()()))";
		System.out.println(string.contains(string2));
	}

	public StringBuilder paranthesBT(TreeNode root) {
		if (root == null)
			return new StringBuilder("()");

		StringBuilder left = paranthesBT(root.left);
		StringBuilder right = paranthesBT(root.right);
		return new StringBuilder("(").append(root.val).append(left.toString()).append(right.toString()).append(")");
	}
}
