class Solution {
    public int appendCharacters(String s, String t) {
        // int result = 0;
        // int jT = 0;
        // boolean match = false;
        // for (int i = 0; i< t.length(); i++) {
        //     for (int j = jT; j<s.length(); j++) {
        //         if (t.charAt(i) == s.charAt(j)) {
        //             jT = ++j;
        //             match = true;
        //             break;
        //         } 
        //         if (j == s.length()-1) {
        //             jT = ++j;
        //             match=false;
        //         }
        //     }
        //     if (jT== s.length()) {
        //         if (match) {
        //         result = t.length()-1-i;
        //         return result;
        //         }
        //         else {
        //             result = t.length()-i;
        //         return result;
        //         }
        //     }
        // }
        // return result;

        int sIndex = 0, tIndex = 0;
        int sLength = s.length(), tLength = t.length();

        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }
        return tLength-tIndex;
    }
}