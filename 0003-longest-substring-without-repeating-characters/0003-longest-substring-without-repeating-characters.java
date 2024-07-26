class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        } 
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (!(s.length() - i > count)) {
                return count;
            }
            int temp = 1;
            Set<Character> letters = new HashSet<Character>();
            letters.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (!letters.contains(s.charAt(j))) {
                    letters.add(s.charAt(j));
                    temp++;
                    if (temp > count) {
                        count = temp;
                    }
                } else {
                    if (temp > count) {
                        count = temp;
                    }
                    break;
                }
            }
        }
        return count;
    }
}