class Solution {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) return false;
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        
        for (int i = 0; i < len1; i++) {
            char curr = word1.charAt(i);
            if (map1.containsKey(curr)) {
                map1.put(curr, map1.get(curr) + 1);
            } else {
                map1.put(curr, 1);
            }
        }
        for (int i = 0; i < len2; i++) {
            char curr = word2.charAt(i);
            if (map2.containsKey(curr)) {
                map2.put(curr, map2.get(curr) + 1);
            } else {
                map2.put(curr, 1);
            }
        }
        for (Integer count: map2.values()) {
            if (map3.containsKey(count)) {
                map3.put(count, map3.get(count) + 1);
            } else {
                map3.put(count, 1);
            }   
        }
        for (Character c: map1.keySet()) {
            int cCount = map1.get(c);
            if (!map2.containsKey(c)) return false;
            if (!map3.containsKey(cCount)) return false;
            map3.put(cCount, map3.get(cCount) - 1);
            if (map3.get(cCount) == 0) {
                map3.remove(cCount);
            }
        }
        return true;
    }
}