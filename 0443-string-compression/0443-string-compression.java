class Solution {
    public int compress(char[] chars) {
        int len = chars.length;

        int count = 1;
        char curr = chars[0];
        int firstOccurenceOfCurr = 0;

        if (len == 1) {
            chars[firstOccurenceOfCurr] = curr;
            return count;
        }

        for (int i = 1; i < len; i++) {
            if (chars[i] == curr) {
                count++;
            } else {
                chars[firstOccurenceOfCurr++] = curr;
                curr = chars[i];
                if (count > 1) {
                    for (char num: String.valueOf(count).toCharArray()) {
                        chars[firstOccurenceOfCurr++] = num;
                    }
                    count = 1;
                }
            }

            if (i == len-1) {
                chars[firstOccurenceOfCurr++] = curr;
                curr = chars[i];
                if (count > 1) {
                    for (char num: String.valueOf(count).toCharArray()) {
                        chars[firstOccurenceOfCurr++] = num;
                    }
                    count = 1;
                }
            }
        }
        return firstOccurenceOfCurr;
    }
}