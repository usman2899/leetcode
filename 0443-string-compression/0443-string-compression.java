class Solution {
    public int compress(char[] chars) {
        int startingPointer = 0;
        int currPointer = 1;
        char currChar = chars[0];
        int count = 1;

        while (currPointer <= chars.length) {
            if (currPointer == chars.length || chars[currPointer] != currChar) {
                chars[startingPointer++] = currChar;
                if (count > 1) {
                    char[] countArray = String.valueOf(count).toCharArray();
                    for (char c: countArray) {
                        chars[startingPointer++] = c;
                    }
                }
                if (currPointer == chars.length) break;
                currChar = chars[currPointer];
                count = 1;
            } else {
                count++;
            }
            currPointer++;
        }
        return startingPointer;
    }

}