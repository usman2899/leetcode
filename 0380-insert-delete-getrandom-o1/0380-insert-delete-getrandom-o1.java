class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        boolean exists = map.containsKey(val);
        if (!exists) {
            list.add(val);
            map.put(val, list.size()-1);
        }
        return !exists;
    }
    
    public boolean remove(int val) {
        boolean exists = map.containsKey(val);
        if (exists) {
            int index = map.get(val);
            int last = list.size() - 1;
            list.set(index, list.get(last));
            map.put(list.get(last), index);
            list.remove(last);
            map.remove(val);
        }
        return exists;
    }
    
    public int getRandom() {
        int random = (int) Math.random();
        random = random % list.size();
        return list.get(random);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */