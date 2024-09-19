class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        //Priority queue of array to hold both index and val of arr
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);  // Sort by value (a[1], b[1])
            } else {
                return Integer.compare(a[0], b[0]);  // If values are the same, sort by index (a[0], b[0])
            }
        });
        int len = costs.length;
        int halfLen = len/2;
        int low = 0;
        int high = len - 1;
        
        if (len == 1) {
            return costs[0];
        }
        
        //Add till candidates reached or list midway reached
        for (int i = 0; i < candidates && i < halfLen; i++) {
            int[] first = new int[]{low, costs[low]};
            queue.offer(first);
            low++;
            
            int[] last = new int[]{high, costs[high]};
            queue.offer(last);
            high--;
            
            //add middle of odd list
            if(i == halfLen-1 && i+1 < candidates && len % 2 != 0) {
                int[] middle = new int[]{low, costs[low]};
                queue.offer(middle);
                low++;
            }
    
        }
        
        long res = 0;
        for (int i = 0; i < k; i++) {
            int[] curr = queue.poll();
            res += curr[1];
            int index = curr[0];
            
            //Add if entire list not added yet
            if (low <= high) {
                if (index < low) {
                    int[] first = new int[]{low, costs[low]};
                    queue.offer(first);
                    low++;
                } else {
                    int[] last = new int[]{high, costs[high]};
                    queue.offer(last);
                    high--;
                }
            }
        }
        return res;
    }
}