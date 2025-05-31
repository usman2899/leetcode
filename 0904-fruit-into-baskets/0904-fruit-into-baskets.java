class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0 , end = 0, result = 0;

        while (end < fruits.length) {
            if (map.size() == 2 && !map.containsKey(fruits[end])) {
                int toRemove = fruits[start];
                start = map.get(toRemove);
                start++;
                map.remove(toRemove);
            }
            map.put(fruits[end], end++);
            result = Math.max(result, end - start);
        }
        return result;
    }
}