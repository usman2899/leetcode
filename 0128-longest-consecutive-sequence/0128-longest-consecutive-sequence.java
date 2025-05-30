class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int num: nums) set.add(num);
        
        int result = 1;
        for (Integer num: set) {
            if (visited.contains(num)) continue;
            int curr = num;
            int count = 1;
            while(set.contains(curr+1)) {
                count++;
                visited.add(curr);
                curr = curr+1;
            }
            visited.add(curr);
            result = Math.max(count, result);
        }
        return result;
        // if (nums.length == 0) return 0;

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        // for (int num: nums) {
        //     minHeap.add(num);
        // }
        
        // int maxConsecutive = 1;
        // int currentConsecutive = 1;
        // int prevNum = minHeap.poll();
        // while(!minHeap.isEmpty()) {
        //     int currentNum = minHeap.poll();
        //     if (prevNum == currentNum) continue;
        //     if (prevNum + 1 == currentNum) {
        //         currentConsecutive++;
        //     } else {
        //         maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
        //         currentConsecutive = 1;
        //     }
        //     prevNum = currentNum;
        // }
        // return Math.max(maxConsecutive, currentConsecutive);
    }
}