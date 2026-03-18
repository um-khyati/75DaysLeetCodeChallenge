class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        int abs = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] + nums[n - 1] + nums[n - 2] < target){
                if(Math.abs(nums[i] + nums[n - 1] + nums[n - 2] - target) < abs){
                    abs = Math.abs(nums[i] + nums[n - 1] + nums[n - 2] - target);
                    res = nums[i] + nums[n - 1] + nums[n - 2];
                }
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] > target){
                if(Math.abs(nums[i] + nums[i + 1] + nums[i + 2] - target) < abs){
                    abs = Math.abs(nums[i] + nums[i + 1] + nums[i + 2] - target);
                    res = nums[i] + nums[i + 1]+ nums[i + 2];
                }
                break;
            }
            int left = i + 1, right = n - 1;
            while(left < right){
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum == target){
                    return target;
                }
                if(Math.abs(currentSum - target) < abs){
                    res = currentSum;
                    abs = Math.abs(currentSum - target);
                }
                if(currentSum > target){
                    right--;
                }else{
                    left++;
                }
            }
            
        }
        return res;
    }
}