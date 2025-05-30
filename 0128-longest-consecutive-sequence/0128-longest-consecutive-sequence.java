class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        for (int num: nums) {
            minHeap.add(num);
        }
        
        int maxConsecutive = 1;
        int currentConsecutive = 1;
        int prevNum = minHeap.poll();
        while(!minHeap.isEmpty()) {
            int currentNum = minHeap.poll();
            if (prevNum == currentNum) continue;
            if (prevNum + 1 == currentNum) {
                currentConsecutive++;
            } else {
                maxConsecutive = Math.max(maxConsecutive, currentConsecutive);
                currentConsecutive = 1;
            }
            prevNum = currentNum;
        }
        return Math.max(maxConsecutive, currentConsecutive);
    }
}