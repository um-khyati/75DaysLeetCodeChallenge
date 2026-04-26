class Solution {
    boolean visited[][];
    boolean dfs(int r,int c,char grid[][],char curr,int par_r,int par_c)
    {
        visited[r][c]=true;
        int m=grid.length;
        int n=grid[0].length;
        if(r<m-1&&grid[r+1][c]==curr)
        {
            if(!visited[r+1][c])
            {
                if(dfs(r+1,c,grid,curr,r,c))
                return true;
            }
            else if(r+1!=par_r&&c!=par_c)
            return true;
        }
         if(c<n-1&&grid[r][c+1]==curr)
        {
            if(!visited[r][c+1])
            {
                if(dfs(r,c+1,grid,curr,r,c))
                return true;
            }
            else if(r!=par_r&&c+1!=par_c)
            return true;
        }
         if(r>=1&&grid[r-1][c]==curr)
        {
            if(!visited[r-1][c])
            {
                if(dfs(r-1,c,grid,curr,r,c))
                return true;
            }
            else if(r-1!=par_r&&c!=par_c)
            return true;
        }
         if(c>=1&&grid[r][c-1]==curr)
        {
            if(!visited[r][c-1])
            {
                if(dfs(r,c-1,grid,curr,r,c))
                return true;
            }
            else if(r!=par_r&&c-1!=par_c)
            return true;
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        visited=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(!visited[i][j])
                {
                    if(dfs(i,j,grid,grid[i][j],-1,-1))
                    return true;
                }
            }
        }
        return false;
    }
}