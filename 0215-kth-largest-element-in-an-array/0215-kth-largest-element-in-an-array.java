class Solution {
    public int findKthLargest(int[] nums, int k) {
        // int len = nums.length;
        // if (len == 1) {
        //     return nums[0];
        // }
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for (int i = 0; i < len; i++) {
        //     pq.offer(nums[i]);
        // }
        // int res = 0;
        // for (int i = 0; i < k; i++) {
        //     res = pq.poll();
        // }
        // return res;        

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}