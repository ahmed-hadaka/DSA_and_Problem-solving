package algorithms2_DP.graph_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
public class MinimumCost_to_MakeValidPath {
	Queue<Edge> pq = new PriorityQueue<>();
	int[] dist;
	int[] dirR = { 0, 0, 1, -1 }; // right, left, down, up
	int[] dirC = { 1, -1, 0, 0 };
	List<List<Edge>> adjList;
	int m, n;

	public static void main(String[] args) {
		MinimumCost_to_MakeValidPath makeValidPath = new MinimumCost_to_MakeValidPath();
		System.out.println(makeValidPath.minCost(new int[][] { { 1, 2 }, { 4, 3 } }));
	}

	public int minCost(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		adjList = new ArrayList<>();
		// initialize adjList
		for (int i = 0; i < m * n; i++) {
			adjList.add(new ArrayList<>());
		}
		buildGraph(grid);
		Dijkstra();
		return dist[m * n - 1];
	}

	private void Dijkstra() {
		dist = new int[m * n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		pq.add(new Edge(0, 0)); // initial edge

		while (!pq.isEmpty()) {
			Edge minEdge = pq.poll();
			int minNode = minEdge.to;

			// can't relax more
			if (minEdge.dist > dist[minNode])
				continue;

			for (Edge edge : adjList.get(minNode)) {
				int to = edge.to;
				int weight = edge.dist;

				if (dist[to] > weight + dist[minNode]) {
					dist[to] = weight + dist[minNode];
					pq.add(new Edge(to, dist[to]));
				}
			}
		}
	}

	private void buildGraph(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				for (int k = 0; k < 4; k++) {
					int i_ = i + dirR[k];
					int j_ = j + dirC[k];
					if (isValid(grid, i_, j_)) {
						int weight = 1;
						if (grid[i][j] == k + 1)
							weight = 0;
						addDirectEdge(i, j, i_, j_, weight);
					}
				}
			}
		}
	}

	private void addDirectEdge(int i, int j, int i_, int j_, int weight) {
		int from = j + i * n;
		int to = j_ + i_ * n;
		adjList.get(from).add(new Edge(to, weight));
	}

	private boolean isValid(int[][] grid, int r, int c) {
		if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)
			return true;
		return false;
	}

	private class Edge implements Comparable<Edge> {
		int to;
		int dist;

		public Edge(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			return this.dist - o.dist;
		}
	}

}
