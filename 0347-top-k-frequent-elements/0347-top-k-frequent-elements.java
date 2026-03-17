class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
} 