class Solution {
    public int findComplement(int num) {
        int len = 0;
        while (len > -1) {
            if (Math.pow(2,len) > num) {
                break;
            }
            len++;
        }
        int[] bin = new int[len];
        
        for (int i = len - 1; i >= 0; i--) {
            int curr = (int) Math.pow(2,i);
            if (curr <= num) {
                bin[i] = 0;
                num = num - curr;
            } else {
                bin[i] = 1;
            }
        }
        
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (bin[i] == 1) {
                res += (int) Math.pow(2,i);
            }   
        }
        return res;
    }
}