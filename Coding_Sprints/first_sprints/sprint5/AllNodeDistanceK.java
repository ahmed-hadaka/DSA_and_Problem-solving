package coding_interviews1.first_sprints.sprint5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description
public class AllNodeDistanceK {
	private static TreeNode buildBT(Integer[] nodes, int i, int inc) {
		if (i >= nodes.length || nodes[i] == null) {
			return null;
		}
		TreeNode root = new TreeNode(nodes[i]);
		root.left = buildBT(nodes, i + inc, i + inc + 1);
		root.right = buildBT(nodes, i + inc + 1, i + inc + 2);
		return root;
	}

	private static TreeNode getTar(TreeNode root, int tarVal) {
		if (root == null)
			return null;
		if (root.val == tarVal)
			return root;
		TreeNode roNode = getTar(root.left, tarVal);
		if (roNode.val == tarVal)
			return roNode;
		return getTar(root.right, tarVal);
	}

	public static void main(String[] args) {
		AllNodeDistanceK a = new AllNodeDistanceK();
		TreeNode root = buildBT(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }, 0, 1);
		TreeNode tar = getTar(root, 5);
		System.out.println(a.distanceK(root, tar, 2));
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

// sol 1

		// List<Integer> res = new ArrayList<>();
//		if (k == 0) {
//			res.add(target.val);
//			return res;
//		}
//		getNodes(target, k, res);
//		getNodeBefore(res, root, target, k);
//
//		return res;

// sol 2
		return BFS(root, target, k);
	}

	// solution 1: not trivial = complicated
	private void getNodes(TreeNode target, int k, List<Integer> res) {
		if (target == null)
			return;
		if (k == 0) {
			res.add(target.val);
			return;
		}
		getNodes(target.left, k - 1, res);
		getNodes(target.right, k - 1, res);
	}

	private int[] getNodeBefore(List<Integer> res, TreeNode root, TreeNode target, int k) {
		if (root == null)
			return new int[] { -1, k };

		if (root == target)
			return new int[] { 1, k - 1 };

		int[] t1 = getNodeBefore(res, root.left, target, k);
		if (t1[0] > 0) {
			if (t1[1] == 0)
				res.add(root.val);
			else
				getNodes(root.right, t1[1] - 1, res);
			return new int[] { 1, t1[1] - 1 };
		}
		int[] t2 = getNodeBefore(res, root.right, target, k);
		if (t2[0] > 0) {
			if (t2[1] == 0)
				res.add(root.val);
			else
				getNodes(root.left, t2[1] - 1, res);
			return new int[] { 1, t2[1] - 1 };
		}

		return new int[] { -1, k };
	}

	// solution 2: BFS level traversal = more trivial

	private List<Integer> BFS(TreeNode root, TreeNode tar, int k) {
		Map<Integer, List<Integer>> adjList = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();

		buildGraph(adjList, root);
		queue.add(tar.val);
		visited.add(tar.val);
		for (int level = 0, size = queue.size(); !queue.isEmpty(); level++, size = queue.size()) {
			if (level == k)
				break;
			while (size-- > 0) {
				int node = queue.poll();
				for (int item : adjList.get(node)) {
					if (!visited.contains(item)) {
						queue.add(item);
						visited.add(item);
					}
				}
			}
		}
		return new ArrayList<>(queue);
	}

	private void buildGraph(Map<Integer, List<Integer>> adjList, TreeNode root) {
		if (root == null)
			return;
		addUndirEdg(adjList, root, root.left, root.right);

		buildGraph(adjList, root.left);
		buildGraph(adjList, root.right);

	}

	private void addUndirEdg(Map<Integer, List<Integer>> adjList, TreeNode root, TreeNode left, TreeNode right) {

		if (left != null) {
			if (adjList.containsKey(root.val)) {
				adjList.get(root.val).add(left.val);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(left.val);
				adjList.put(root.val, list);
			}
			if (adjList.containsKey(left.val)) {
				adjList.get(left.val).add(root.val);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(root.val);
				adjList.put(left.val, list);
			}
		}
		if (right != null) {
			if (adjList.containsKey(root.val)) {
				adjList.get(root.val).add(right.val);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(right.val);
				adjList.put(root.val, list);
			}
			if (adjList.containsKey(right.val)) {
				adjList.get(right.val).add(root.val);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(root.val);
				adjList.put(right.val, list);
			}
		}
	}

}
