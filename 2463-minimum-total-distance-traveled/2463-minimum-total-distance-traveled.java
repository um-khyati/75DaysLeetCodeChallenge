class Solution {
    int[] robopos;
    Long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        this.robopos = new int[robot.size()];
        dp = new Long[robot.size()][factory.length];
        for(int i=0;i<robot.size();i++) robopos[i] = robot.get(i);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        return dfs(robot.size()-1,factory.length-1,factory);
    }
    public long dfs(int m, int n,int[][] factory){
        if(m<0) return 0;
        if(n<0) return Long.MAX_VALUE/200;
        if(dp[m][n]!=null) return dp[m][n];
        long res = dfs(m,n-1,factory);
        long dist = 0;
        for(int k=0;k<factory[n][1] && m-k>=0;k++){
            dist+=Math.abs(factory[n][0]-robopos[m-k]);
            res = Math.min(res,dist+dfs(m-k-1,n-1,factory));
        }
        return dp[m][n] = res;
    }
}