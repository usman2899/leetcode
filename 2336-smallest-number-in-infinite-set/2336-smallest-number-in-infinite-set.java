class SmallestInfiniteSet {

    PriorityQueue<Integer> queue;
    Set<Integer> removed;

    public SmallestInfiniteSet() {
        this.queue = new PriorityQueue<>();
        queue.add(1);
        this.removed = new HashSet<>();
    }
    
    public int popSmallest() {
        int curr = queue.poll();
        if (queue.isEmpty()) {
            queue.add(curr+1);
        }
        removed.add(curr);
        return curr;
    }
    
    public void addBack(int num) {
        if (removed.contains(num)) {
            queue.add(num);
            removed.remove(num);
        }        
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */