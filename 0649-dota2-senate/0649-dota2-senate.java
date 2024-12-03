class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        int n = senate.length();
        
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            if (rQueue.peek() < dQueue.peek()) {
                rQueue.offer(n++);
            } else {
                dQueue.offer(n++);
            }
            dQueue.poll();
            rQueue.poll();
        }
        
        // Set<Integer> voted = new HashSet<>();
        // while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
        //     if (voted.contains(rQueue.peek()) && voted.contains(dQueue.peek())) {
        //         voted.clear();
        //     }
        //     if (voted.contains(dQueue.peek()) || (rQueue.peek() < dQueue.peek() &&                          !voted.contains(rQueue.peek()))) {
        //         dQueue.poll();
        //         int curr = rQueue.poll();
        //         voted.add(curr);
        //         rQueue.offer(curr);
        //     } else {
        //         rQueue.poll();
        //         int curr = dQueue.poll();
        //         voted.add(curr);
        //         dQueue.offer(curr);
        //     }  
        // }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}