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
        for (int i = 1; i <= length-k; i++) {
            if (curr == k) {
                return k;
            }
            if (set.contains(s.charAt(i-1))) {
                curr--;
            }
            if (set.contains(s.charAt(i+k-1))) {
                curr++;
            }
            if (curr > result) {
                result = curr;
            }
        }                     
        return result;        
    }
}