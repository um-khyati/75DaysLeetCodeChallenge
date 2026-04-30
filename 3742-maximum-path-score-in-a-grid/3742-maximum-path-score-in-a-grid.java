class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] d = dp[i][j];
                Arrays.fill(d, -1);
            }
        }
        int zero = grid[0][0];
        dp[0][0][zero] = grid[0][0];
        int total = grid[0][0] != 0 ? 1 : 0;
        for (int i = 1; i < m; i++) {
            int score = grid[i][0];
            int cost = score != 0 ? 1 : 0;
            if (total+cost >k) break;
            dp[i][0][total+cost] = dp[i-1][0][total] + score;
            total += cost;
        }
        total = grid[0][0];
        for (int j = 1; j < n; j++) {
            int score = grid[0][j];
            int cost = score != 0 ? 1 : 0;
            if (total+cost >k) break;
            dp[0][j][total+cost] = dp[0][j-1][total] + score;
            total += cost;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
               
                int score = grid[i][j];
                int cost = score != 0 ? 1 : 0;
                if (cost > k) break;
                for (int s = k; s >= cost; s--) {
                    if (dp[i][j-1][s-cost] == -1 && 
                    dp[i-1][j][s-cost] == -1) continue;
                    dp[i][j][s] = Math.max(dp[i][j-1][s-cost],  dp[i-1][j][s-cost]) + score; 
                }
            }
        }

        int rets = -1;
        for (int i = 0; i <= k; i++) {
            rets = Math.max(rets, dp[m-1][n-1][i]);
        }
        return rets;
    }
}

