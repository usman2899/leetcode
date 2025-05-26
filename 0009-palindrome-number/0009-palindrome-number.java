class Solution {
    public boolean isPalindrome(int x) {
        char[] numChar = String.valueOf(x).toCharArray();

        int s = 0;
        int e = numChar.length - 1;

        while (s < e) {
            if (numChar[s] != numChar[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}