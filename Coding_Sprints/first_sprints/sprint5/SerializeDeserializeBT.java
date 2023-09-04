package coding_interviews1.first_sprints.sprint5;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class SerializeDeserializeBT {
	private static TreeNode buildBT(Integer[] nodes, int i, int inc) {
		if (i > nodes.length || nodes[i] == null) {
			return null;
		}
		TreeNode root = new TreeNode(nodes[i]);
		root.left = buildBT(nodes, i + inc, i + inc + 1);
		root.right = buildBT(nodes, i + inc + 1, i + inc + 2);
		return root;
	}

	public static void main(String[] args) {
		SerializeDeserializeBT sBt = new SerializeDeserializeBT();
		TreeNode root = buildBT(new Integer[] { 1, 2, 3, null, null, 4, 5 }, 0, 1);
		System.out.println(sBt.serialize(root));
	}

//	StringBuilder str;

	private void ourSerialize(TreeNode root, StringBuilder str) {
		if (root == null)
			str.append("x,");
		else {
			str.append(Integer.toString(root.val)).append(",");
			ourSerialize(root.left, str);
			ourSerialize(root.right, str);
		}

	}

// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder str = new StringBuilder("");
		ourSerialize(root, str);
		return str.substring(0, str.length() - 1).toString();
	}

	private TreeNode ourDeserialize(Queue<String> s) {
		if (s.peek().equals("x")) {
			s.poll();
			return null;
		}
		String k = s.poll();
		int val = Integer.valueOf(k);
		TreeNode temp = new TreeNode(val);
		temp.left = ourDeserialize(s);
		temp.right = ourDeserialize(s);

		return temp;
	}

// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> q = new LinkedList<>();
		String[] nodes = data.split(",");
		for (int i = 0; i < nodes.length; i++) {
			q.offer(nodes[i]);
		}
		return ourDeserialize(q);
	}
}
