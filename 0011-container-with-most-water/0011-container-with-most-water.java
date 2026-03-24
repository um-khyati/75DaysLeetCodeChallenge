class Solution {
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int maxWater = 0;

        while(start < end){

            int width = end - start;

            if(height[start] < height[end]){

                int area = width * height[start];
                maxWater = Math.max(maxWater, area);
                start++;

            } else {

                int area = width * height[end];
                maxWater = Math.max(maxWater, area);
                end--;
            }
        }

        return maxWater;
    }
}