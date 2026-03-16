import java.util.*;

class Solution {
    List<int[]>[] graph;
    int[] ans;

    public int[] minEdgeReversals(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(new int[]{v, 0});
            graph[v].add(new int[]{u, 1});
        }

        ans = new int[n];

        ans[0] = dfs1(0, -1);
        dfs2(0, -1);

        return ans;
    }

    private int dfs1(int node, int parent) {
        int cost = 0;

        for (int[] nei : graph[node]) {
            int next = nei[0];
            int w = nei[1];

            if (next == parent) continue;

            cost += w + dfs1(next, node);
        }

        return cost;
    }

    private void dfs2(int node, int parent) {
        for (int[] nei : graph[node]) {
            int next = nei[0];
            int w = nei[1];

            if (next == parent) continue;

            if (w == 0) ans[next] = ans[node] + 1;
            else ans[next] = ans[node] - 1;

            dfs2(next, node);
        }
    }
}