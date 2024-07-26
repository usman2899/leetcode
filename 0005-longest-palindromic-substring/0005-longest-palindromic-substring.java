class Solution {
    public String longestPalindrome(String s) {
        String result = s.substring(0,1);
        for (int i =0; i< s.length(); i++) {
            for (int j = s.length()-1; j > i; j--) {
                if ( isPal(s.substring(i,j+1)) && s.substring(i,j+1).length() > result.length() ) {
                    result = s.substring(i,j+1);
                    break;
                }
            }
            if (result.length() > s.length()-i) {
                break;
            }
        }
        return result;
    }

    public Boolean isPal(String string) {
        Boolean flag = true;
        for(int i = 0; i < string.length()/2; i++){    
            if(string.charAt(i) != string.charAt(string.length()-i-1)){    
                flag = false;    
                break;    
            }    
        }    
        return flag;
    }
}