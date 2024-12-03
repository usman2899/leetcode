class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();
        Set<Integer> voted = new HashSet<>();
        
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            if (voted.contains(rQueue.peek()) && voted.contains(dQueue.peek())) {
                voted.clear();
            }
            if (voted.contains(dQueue.peek()) || (rQueue.peek() < dQueue.peek() &&                          !voted.contains(rQueue.peek()))) {
                dQueue.poll();
                int curr = rQueue.poll();
                voted.add(curr);
                rQueue.offer(curr);
            } else {
                rQueue.poll();
                int curr = dQueue.poll();
                voted.add(curr);
                dQueue.offer(curr);
            }  
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}