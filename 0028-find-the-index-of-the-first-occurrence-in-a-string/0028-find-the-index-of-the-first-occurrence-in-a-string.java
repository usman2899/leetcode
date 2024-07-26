class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()){
            return -1;
        }
        for (int i = 0; i < haystack.length(); i++){
            for (int j = 0; j < needle.length(); j++){
                if ( (i+j) >=  haystack.length()){
                    return -1;
                } 
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                if (j == needle.length()-1){
                    return i;
                }
            }
        }
        return -1;
    }
}