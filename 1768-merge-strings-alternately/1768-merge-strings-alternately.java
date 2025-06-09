class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();
  
        while (p1 < len1 && p2 < len2) {
            res.append(word1.charAt(p1));
            res.append(word2.charAt(p2));
            p1++;            
            p2++;            
        }
        while (p1 < len1) {
            res.append(word1.charAt(p1));
            p1++;
        }
        while (p2 < len2) {
            res.append(word2.charAt(p2));
            p2++;
        }
        return res.toString();    
    }
}