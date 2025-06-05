class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPal = solve(s, i, i);
            String evenPal = solve(s, i, i + 1);
            if (oddPal.length() > evenPal.length() && oddPal.length() > res.length()) {
                res = oddPal;
            } else if (evenPal.length() > res.length()) {
                res = evenPal;
            } else{}
        }
        return res;
    }

    String solve(String s, int i, int j) {
        if (i < 0 || j == s.length() || s.charAt(i) != s.charAt(j)) return s.substring(i+1, j);
        return solve(s, i - 1, j + 1);
    }
}