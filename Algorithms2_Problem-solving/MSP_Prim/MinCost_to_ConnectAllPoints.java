package algorithms2_DP.MSP_Prim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/min-cost-to-connect-all-points/description/
public class MinCost_to_ConnectAllPoints {
	List<List<Edge>> adjList = new ArrayList<>();
	Queue<Edge> pq = new PriorityQueue<>();
	int[] dist;
	boolean[] visited;
	int[][] coordinates;

// 3,12],[-2,5],[-4,1
	// 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0
	public static void main(String[] args) {
		MinCost_to_ConnectAllPoints minCost = new MinCost_to_ConnectAllPoints();
		System.out.println(minCost.minCostConnectPoints(new int[][] { { 3, 12 }, { -2, 5 }, { -4, 1 } }));
	}

	public int minCostConnectPoints(int[][] points) {
		coordinates = points;

		for (int i = 0; i < coordinates.length; i++) {
			adjList.add(new ArrayList<>());
		}
		// build graph
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				int weight = getDist(i, j);
				addUndirectedEdge(i, j, weight);
			}
		}

		// get min dist
		return MST();
	}

	private int MST() {
		dist = new int[coordinates.length];
		visited = new boolean[coordinates.length];
		dist[0] = 0;
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.add(new Edge(0, 0));
		int minCost = 0;
		while (!pq.isEmpty()) {
			Edge minEdge = pq.poll();
			int minNode = minEdge.to;

			// can't relax more
			if (visited[minNode])
				continue;
			minCost += minEdge.dist;
			// find the
			for (Edge edge : adjList.get(minNode)) {
				int to = edge.to;
				int weight = edge.dist;

				if (dist[to] > weight) {
					dist[to] = weight;
					pq.add(new Edge(to, dist[to]));
				}
			}
			visited[minNode] = true;
		}
		return minCost;
	}

	private void addUndirectedEdge(int i, int j, int weight) {
		adjList.get(i).add(new Edge(j, weight));
		adjList.get(j).add(new Edge(i, weight));
	}

	private int getDist(int i, int j) {
		int xi = coordinates[i][0];
		int yi = coordinates[i][1];
		int xj = coordinates[j][0];
		int yj = coordinates[j][1];
		int wieght = Math.abs(xi - xj) + Math.abs(yi - yj);
		return wieght;
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
