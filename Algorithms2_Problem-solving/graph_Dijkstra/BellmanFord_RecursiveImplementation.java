package algorithms2_DP.graph_Dijkstra;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord_RecursiveImplementation {
	int[][] cost = new int[6][6];
	final int INF = 100 * cost[0].length + 1;
	final int MAX_COST = 100;
	int src = 0;

	public static void main(String[] args) {
		BellmanFord_RecursiveImplementation b = new BellmanFord_RecursiveImplementation();
		b.cost = new int[][] { { b.INF, 1, b.INF, b.INF, b.INF, b.INF }, { b.INF, b.INF, 99, b.INF, 1, b.INF },
				{ b.INF, b.INF, b.INF, 5, b.INF, b.INF }, { b.INF, b.INF, b.INF, b.INF, b.INF, b.INF },
				{ b.INF, b.INF, 3, b.INF, b.INF, 6 }, { b.INF, b.INF, b.INF, 7, b.INF, b.INF } };
		System.out.println(b.getShortestPath_bellman(3, 7));
	}

	private int getShortestPath_bellman(int dist, int maxEdges) {
		if (maxEdges == 1)
			return cost[src][dist];
		int ans = getShortestPath_bellman(dist, maxEdges - 1);
		List<Integer> nodesGoToDistIntegers = getNeighbor(dist);
		for (int node : nodesGoToDistIntegers) {
			int temp = getShortestPath_bellman(node, maxEdges - 1) + cost[node][dist];
			ans = Math.min(temp, ans);
		}
		return ans;
	}

	private List<Integer> getNeighbor(int dist) {
		List<Integer> neighbors = new ArrayList<>();
		for (int i = 0; i < cost.length; i++) {
			if (cost[i][dist] != INF)
				neighbors.add(i);
		}
		return neighbors;
	}
}
