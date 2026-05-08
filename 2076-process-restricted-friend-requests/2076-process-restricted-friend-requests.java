class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        
        int[] parent = new int[n];
        int[] size = new int[n]; 
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        List<Set<Integer>> forbidden = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            forbidden.add(new HashSet<>());
        }
        for (int[] r : restrictions) {
            int a = r[0];
            int b = r[1];
            forbidden.get(a).add(b);
            forbidden.get(b).add(a);
        }

        boolean[] res = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int a = requests[i][0];
            int b = requests[i][1];

            int rootA = find(parent, a);
            int rootB = find(parent, b);

            if (rootA == rootB) {
                res[i] = true;
                continue;
            }
            if (forbidden.get(rootA).contains(rootB) ||
                forbidden.get(rootB).contains(rootA)) {
                res[i] = false;
                continue;
            }
            if (size[rootA] < size[rootB]) {
                int tmp = rootA;
                rootA = rootB;
                rootB = tmp;
            }
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
            for (int x : forbidden.get(rootB)) {
                forbidden.get(rootA).add(x);
                forbidden.get(x).add(rootA);
            }
            res[i] = true;
        }
        return res;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}