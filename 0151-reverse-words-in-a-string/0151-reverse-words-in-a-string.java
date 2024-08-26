class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        s = s + " ";
        boolean isW = true;
        int start = 0;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (!isW && s.charAt(i) != ' ') {
                start = i;
                isW = true;
            } else if (isW && s.charAt(i) == ' ') {
                result =  s.substring(start, i) + " " + result;
                isW = false;
            } else {
            }
        }
        result = result.substring(0, result.length()-1);
        return result;
    }
}