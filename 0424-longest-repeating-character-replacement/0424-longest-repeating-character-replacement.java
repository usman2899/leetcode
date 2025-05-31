class Solution {
    public int characterReplacement(String s, int k) {
        int nP = 0;
        int start = 0;
        int end = 1;
        int res = 1;
        int rem = k;

        while (end < s.length()) {
            if (s.charAt(end) == s.charAt(start)) {
                end++;
                res = Math.max(end - start, res);
            } else {
                if (nP == start) {
                    nP = end;
                }
                if (rem > 0) {
                    rem--;
                    end++;
                    res = Math.max(end - start, res);
                } else {
                    start = nP;
                    end = nP + 1;
                    rem = k;
                }
            }
        }
        return res;
    }
}