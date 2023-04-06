package algorithms2_DP.graph_Dijkstra;

import java.util.Arrays;

// 1,2,1],[2,3,2],[1,3,2 , 3, 1
//1, 2, 1 }, { 2, 1, 3 } }, 2, 2
// https://leetcode.com/problems/network-delay-time
public class Dijkstra_adjMatrix_NetworkDelayTime {
	int[][] graph;
	boolean[] visited;
	final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Dijkstra_adjMatrix_NetworkDelayTime networkDelayTime = new Dijkstra_adjMatrix_NetworkDelayTime();
		int res = networkDelayTime.networkDelayTime(new int[][] { { 1, 2, 1 }, { 2, 3, 2 }, { 1, 3, 2 } }, 3, 1);
		System.out.println(res);
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		graph = new int[n][n];
		visited = new boolean[n];
		int MinTime = -1;
		int start = k - 1;
		visited[start] = true;
		fillGraph(times);

		// get minDistance
		int minDistNode = getMinDistNode(start);
		// relax the selected node
		while (minDistNode != INF) {
			for (int i = 0; i < graph[minDistNode].length; i++) {
				if (graph[minDistNode][i] != INF) {
					if (visited[i])
						continue;
					int temp = graph[minDistNode][i] + graph[start][minDistNode];
					if (temp <= graph[start][i])
						graph[start][i] = temp;
				}
			}
			// delete (mark as visited)
			visited[minDistNode] = true;
			MinTime = graph[start][minDistNode];
			graph[start][minDistNode] = INF;
			minDistNode = getMinDistNode(start);
		}
		return isAllVisit() ? MinTime : -1;
	}

	private boolean isAllVisit() {
		for (boolean i : visited) {
			if (!i)
				return false;
		}
		return true;
	}

	private int getMinDistNode(int k) {
		int minDistNode = INF;
		int minDist = INF;
		for (int i = 0; i < graph.length; i++) {
			if (graph[k][i] < minDist) {
				minDist = graph[k][i];
				minDistNode = i;
			}
		}
		return minDistNode;
	}

	private void fillGraph(int[][] times) {
		for (int[] is : graph) {
			Arrays.fill(is, INF);
		}
		for (int[] i : times) {
			int src = i[0];
			int dist = i[1];
			int weight = i[2];
			graph[src - 1][dist - 1] = weight;
		}
	}
}
