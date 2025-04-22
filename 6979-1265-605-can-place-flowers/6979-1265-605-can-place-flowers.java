class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        boolean prev = false;
        int plots = flowerbed.length;

        for (int i = 0; i < plots; i++) {
            if (flowerbed[i] == 0 && !prev && 
                (i == plots-1 ||
                i+1 < plots && flowerbed[i+1] == 0)) {
                n--;
                prev = true;
            } else if (flowerbed[i] == 0 && prev) {
                prev = false;
            } else {
                prev = true;
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }
}