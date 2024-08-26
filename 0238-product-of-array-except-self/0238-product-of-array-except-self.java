class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        int product = 1;
        int zero = 0;

        for (int i = 0; i < len; i++) {
            int val = nums[i];
            if (val == 0) {
                zero++;
            } else {
                product *= val;
            }
        }

        for (int i = 0; i < len; i++) {
            int val = nums[i];
           if (zero > 1 || (zero == 1 && val != 0)) {
                result[i] = 0;
            } else if (zero == 1 && val == 0) {
                result[i] = product;
            } else {
                result[i] = product/val;
            }
        }

        return result;

        // for (int i = 0; i < len; i++) {
        //     int res = 1;
        //     for (int j = 0; j < len; j++) {
        //         if (i == j) {
        //             continue;
        //         }
        //         if (res == 0) {
        //             break;
        //         }
        //         res *= nums[j];
        //     }
        //     result[i] = res;
        // }
        // return result;
    }
}