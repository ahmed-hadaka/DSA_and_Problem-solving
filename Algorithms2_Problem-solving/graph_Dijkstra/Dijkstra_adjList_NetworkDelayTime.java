package algorithms2_DP.graph_Dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/network-delay-time
public class Dijkstra_adjList_NetworkDelayTime {
	List<List<Edge>> adjList;
	Queue<Edge> pq = new PriorityQueue<>();
	int[] dist;

	public static void main(String[] args) {
		Dijkstra_adjList_NetworkDelayTime delayTime = new Dijkstra_adjList_NetworkDelayTime();
		int minDist = delayTime.networkDelayTime(new int[][] { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } }, 4, 2);
		System.out.println(minDist);
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		int start = k - 1;
		adjList = new ArrayList<>(n);
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		fillAdjList(times, n);
		pq.add(new Edge(start, 0)); // initial edge
		Dijkstra();
		return getMax(dist);
	}

	private void Dijkstra() {
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

	private int getMax(int[] dist) {
		int max = 0;
		for (int i : dist) {
			max = Math.max(max, i);
		}
		return max == Integer.MAX_VALUE ? -1 : max;
	}

	private void fillAdjList(int[][] times, int n) {
		// initialize adjList
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] i : times) {
			int src = i[0];
			int dist = i[1];
			int weight = i[2];
			adjList.get(src - 1).add(new Edge(dist - 1, weight));
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
