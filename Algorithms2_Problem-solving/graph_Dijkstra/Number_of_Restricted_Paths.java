package algorithms2_DP.graph_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/
public class Number_of_Restricted_Paths {
	List<List<Edge>> adjList;
	Queue<Edge> pq = new PriorityQueue<>();
	int[] dist;
	final int MAX = 2 * 10000 + 1;
	long[] memory = new long[MAX];
	final long MOD = 1000000007;

	public static void main(String[] args) {
		Number_of_Restricted_Paths countPaths = new Number_of_Restricted_Paths();
		int cnt = countPaths.countRestrictedPaths(5, new int[][] { { 1, 2, 3 }, { 1, 3, 3 }, { 2, 3, 1 }, { 1, 4, 2 },
				{ 5, 2, 2 }, { 3, 5, 1 }, { 5, 4, 10 } });
		System.out.println(cnt);
	}

	public int countRestrictedPaths(int n, int[][] edges) {
		adjList = new ArrayList<>(n);
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(memory, -1);
		fillAdjList(edges, n);
		Dijkstra(n - 1); // compute dist[] with shortest paths starting from last index

		return (int) numRestrictPaths(n - 1, 0);
	}

	private void Dijkstra(int start) {
		dist[start] = 0;
		pq.add(new Edge(start, 0)); // initial edge
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

	private long numRestrictPaths(int end, int start) {

		/* DP with memoization */
		if (start == end)
			return 1;
		int cnt = 0;
		if (memory[start] != -1)
			return memory[start];
		for (Edge edge : adjList.get(start)) {
			if (dist[start] > dist[edge.to]) {
				cnt += numRestrictPaths(end, edge.to);
				cnt %= MOD;
			}
		}
		memory[start] = cnt;

		/* TLE */

//		if (start == end)
//			return 1;
//		int cnt = 0;
//		for (Edge edge : adjList.get(start)) {
//			if (dist[start] > dist[edge.to]) {
//				cnt += numRestrictPaths(end, edge.to);
//				cnt %= MOD;
//			}
//		}

		/* TLE */

// Queue<Integer> q = new LinkedList<>();
//		q.add(0);
//		long cnt = 0;
//		while (!q.isEmpty()) {
//			int st = q.poll();
//			if (st == n - 1) {
//				cnt++;
//				cnt %= MOD;
//				continue;
//			}
//			for (Edge edge : adjList.get(st)) {
//				if (dist[edge.to] < dist[st])
//					q.add(edge.to);
//			}
//		}

		return cnt;
	}

	private void fillAdjList(int[][] times, int n) {
		// initialize adjList
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		// undirected
		for (int[] i : times) {
			int src = i[0] - 1;
			int dist = i[1] - 1;
			int weight = i[2];
			adjList.get(src).add(new Edge(dist, weight));
			adjList.get(dist).add(new Edge(src, weight));
		}
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
