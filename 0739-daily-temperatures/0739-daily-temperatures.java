class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        for(int i=n-2; i>=0; i--){
            int j = i+1;
            while(j<n){
                if(temperatures[j]>temperatures[i]){
                    ans[i] = j-i;
                    break;
                }   
                else if(ans[j]==0){
                    break;
                }
                else{
                    j = j+ans[j];
                }
            }
        }
        return ans;
    }
}