class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (map.containsKey(num)) {
                int val = map.get(num);
                val++;
                map.put(num, val);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i: map.keySet()) {
            int val = map.get(i);
            if (set.contains(val)) {
                return false;
            }
            set.add(val);
        }
        return true;
    }
}