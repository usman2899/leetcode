class Solution {
    int result = 0;
    public int countSubstrings(String s) {
        backtrack(s);
        return result;
    }

    void backtrack(String s) {
        if (s.length() == 0) return;
        for (int i = 1; i <= s.length(); i++) {
            String curr = s.substring(0, i);
            if (isPal(curr)) result++;
        }
        backtrack(s.substring(1));
    }

    boolean isPal(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}