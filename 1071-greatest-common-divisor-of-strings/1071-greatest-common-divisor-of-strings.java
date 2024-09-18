class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int len1 = str1.length();
        int len2 = str2.length();
        String larger = "";
        String smaller = "";
        
        if (len1 == len2) {
            if (str1.equals(str2)) {
                return str1;
            } else {
                return "";
            }
        } else if (len1 > len2) {
            larger = str1;
            smaller = str2;
        } else {
            larger = str2;
            smaller = str1;
        }
        
        int high = smaller.length();
        int sLen = high;
        int lLen = larger.length();
        
        while (high > 0) {
            String divisor = str2.substring(0, high);
            int divLen = divisor.length();
            
            if (lLen % divLen != 0 || sLen % divLen != 0) {
                high--;
                continue;
            }
            
            for (int i = 0; i < lLen; i++) {
                if ((larger.charAt(i) != divisor.charAt(i%divLen))
                    || (smaller.charAt(i%sLen) != divisor.charAt(i%divLen))) {
                    break;
                }
                if (i == lLen - 1) {
                    return divisor;
                }
            }
            high--;
        }
        return "";
    }
}