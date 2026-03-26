class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0.0,c=0.0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        c=sum;
        for(int i=k;i<nums.length;i++){
            c-=nums[i-k];
            c+=nums[i];
            if(c>sum) sum=c;
        }
        return sum/k;
    }
}