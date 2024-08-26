class Solution {
    public String mergeAlternately(String word1, String word2) {
        String res = "";
        int beg = 1;
        int p1 = 0;
        int p2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();

        // while (p1 < len1 && p2 < len2) {
        //     if (beg % 2 != 0) {
        //         res += word1.charAt(p1);
        //         p1++;
        //         beg++;
        //     } else {
        //         res += word2.charAt(p2);
        //         p2++;
        //         beg++;
        //     }
        // }
        // while (p1 < len1) {
        //     res += word1.charAt(p1);
        //     p1++;
        // }
        // while (p2 < len2) {
        //     res += word2.charAt(p2);
        //     p2++;
        // }
        // return res;     
        while (p1 < len1 && p2 < len2) {
            res += word1.charAt(p1);
            res += word2.charAt(p2);
            p1++;            
            p2++;            
        }
        while (p1 < len1) {
            res += word1.charAt(p1);
            p1++;
        }
        while (p2 < len2) {
            res += word2.charAt(p2);
            p2++;
        }
        return res;    
    }
}