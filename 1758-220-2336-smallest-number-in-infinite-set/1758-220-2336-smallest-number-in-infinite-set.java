class SmallestInfiniteSet {

    private Integer minNum;
    private PriorityQueue<Integer> pq;

    public SmallestInfiniteSet() {
        minNum = 1;
        pq = new PriorityQueue<>();
    }
    
   public int popSmallest() {
        if (!pq.isEmpty()) {
            return pq.poll();
        }
        return minNum++;
    }

    public void addBack(int num) {
        if (minNum > num && !pq.contains(num)) {
            pq.offer(num);
        }
    }
}