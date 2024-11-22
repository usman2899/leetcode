class Solution {
    public boolean isSubsequence(String s, String t) {
        int sInd = 0;
        int tInd = 0;
        int sLen = s.length();
        int tLen = t.length();
        
        if (sLen > tLen) return false;
        
        while (sInd < sLen) {
            if (tInd == tLen) return false;
            
            if (s.charAt(sInd) == t.charAt(tInd)) {
                sInd++;
                tInd++;
            } else {
                tInd++;
            }
        }
        return true;
    }
}