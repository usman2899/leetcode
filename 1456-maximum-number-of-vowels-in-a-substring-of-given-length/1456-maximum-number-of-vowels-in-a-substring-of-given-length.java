class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int length = s.length();
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                result++;
            }
        }
        int curr = result;
        for (int i = k; i < length; i++) {
            if (curr == k) {
                return k;
            }
            if (set.contains(s.charAt(i-k))) {
                curr--;
            }
            if (set.contains(s.charAt(i))) {
                curr++;
            }
            result = Math.max(curr, result);
        }                     
        return result;        
    }
}