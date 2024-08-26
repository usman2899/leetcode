class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int actual = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            int val = flowerbed[i];
            if (i == 0 && i == len-1) {
                if (val == 0) {
                    actual++;
                }
            } else if (i == 0) {
                if (val == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    actual++;
                }
            } else if (i == len-1) {
                if (val == 0 && flowerbed[i-1] == 0) {
                    flowerbed[i] = 1;
                    actual++;
                }
            } else {
                if (val == 0 && flowerbed[i+1] == 0 && flowerbed[i-1] == 0) {
                    flowerbed[i] = 1;
                    actual++;
                } 
            }
        }
        if (actual >= n) {
            return true;
        } else {
            return false;
        }
    }
}