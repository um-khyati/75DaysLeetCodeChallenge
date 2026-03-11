class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : arr){
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        boolean[] nums = new boolean[max - min + 1];

        for(int n : arr){
            nums[n - min] = true;
        }

        int[] newArr = new int[arr.length];
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] ){
                newArr[j] = i + min;
                j++;
            }
        }

        int absMin = Integer.MAX_VALUE;
        for(int i = 0; i < newArr.length - 1; i++){
            int temp = newArr[i+1] - newArr[i];
            if(temp < absMin){
                absMin = temp;
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < newArr.length - 1; i++){
            int temp = newArr[i+1] - newArr[i];
            if(temp == absMin){
                res.add(List.of(newArr[i], newArr[i+1]));
            }
        }

        return res;
    }
}