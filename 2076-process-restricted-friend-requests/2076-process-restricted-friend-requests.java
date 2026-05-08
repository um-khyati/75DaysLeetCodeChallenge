class Solution {
    int[] parent;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];

            int pu = find(u);
            int pv = find(v);

            boolean possible = true;

            for (int[] r : restrictions) {
                int x = find(r[0]);
                int y = find(r[1]);

                if ((x == pu && y == pv) || (x == pv && y == pu)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                union(pu, pv);
                result[i] = true;
            }
        }

        return result;
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa != pb) {
            parent[pa] = pb;
        }
    }
}