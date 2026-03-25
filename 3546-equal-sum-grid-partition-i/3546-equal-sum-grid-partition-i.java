class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        long hor[]= new long[n];
        long total1=0;
        for(int i=0;i<n;i++)
        {
            long temp=0;
            for(int j=0;j<m;j++)
            {
                int t=grid[i][j];
                 temp+=t;
                 
            }
            hor[i]=temp+total1;
            total1+=temp;
        }
       
        for(int i=0;i<n;i++)
        {
            if(hor[i]==total1-hor[i])
            return true;
        }

        long ver[]= new long[m];
        long total2=0;
        for(int j=0;j<m;j++)
        {
            long temp=0;
            for(int i=0;i<n;i++)
            {
                temp+=grid[i][j];
            }
            ver[j]=temp+total2;
            total2+=temp;
        }

        for(int i=0;i<m;i++)
        {
            if(ver[i]==total2-ver[i])
            return true;
        }

        return false;

    }
}