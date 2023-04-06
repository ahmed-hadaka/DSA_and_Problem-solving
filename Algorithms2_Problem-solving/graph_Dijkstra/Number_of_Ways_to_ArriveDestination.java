package algorithms2_DP.graph_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
public class Number_of_Ways_to_ArriveDestination {
	List<List<Edge>> adjList;
	Queue<Edge> pq = new PriorityQueue<>();
	int[] dist;
	long[] cntPathes;
	final long MOD = 1_000_000_007;

	public static void main(String[] args) {
		Number_of_Ways_to_ArriveDestination ways = new Number_of_Ways_to_ArriveDestination();
		int cnt = ways.countPaths(5, new int[][] { { 0, 1, 1 }, { 1, 2, 4 }, { 0, 4, 3 }, { 3, 2, 5 }, { 3, 4, 1 },
				{ 3, 0, 5 }, { 1, 3, 1 } });
		System.out.println(cnt);
	}

	public int countPaths(int n, int[][] roads) {
		if (n == 1)
			return 1;

		adjList = new ArrayList<>(n);
		dist = new int[n];
		cntPathes = new long[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		cntPathes[0] = 1;

		fillAdjList(roads, n);
		pq.add(new Edge(0, 0)); // initial edge

		Dijkstra(n);
		return (int) cntPathes[n - 1] % 1_000_000_007;
	}

	private void Dijkstra(int n) {

		while (!pq.isEmpty()) {
			Edge minEdge = pq.poll();
			int minNode = minEdge.to;

			// Can't relax more.
			if (minEdge.dist > dist[minNode])
				continue;

			for (Edge edge : adjList.get(minNode)) {
				int to = edge.to;
				int weight = edge.dist;

				if (dist[to] > weight + dist[minNode]) {
					dist[to] = weight + dist[minNode];
					cntPathes[to] = cntPathes[minNode];
					pq.add(new Edge(to, dist[to]));
				} else if (dist[to] == weight + dist[minNode]) {
					cntPathes[to] += cntPathes[minNode];
					cntPathes[to] %= MOD;
				}
			}
		}
	}

	private void fillAdjList(int[][] times, int n) {
		// initialize adjList
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		// undirected
		for (int[] i : times) {
			int src = i[0];
			int dist = i[1];
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
