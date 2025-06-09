class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            while (set.contains(curr)) {
                set.remove(s.charAt(left++));
            }
            set.add(curr);
            result = Math.max(result, right - left +1);
        }
        return result;        
    }
}