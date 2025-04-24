class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int h = arr.length - 1;

        while (l <= h) {
            int m = l + ((h-l)/2);

            if (arr[m] - (m+1) < k) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l + k;
        


    //     int i = 1;
    //     for (int num: arr) {
    //         while (num != i) {
    //             k--;
    //             if (k == 0) {
    //                 return i;
    //             }
    //             i++;
    //         }
    //         i++;
    //     }

    //     return i+k-1;


        // for (int num: arr) {
        //     if (num <= k) {
        //         k++;
        //     } else {
        //         break;
        //     }
        // }
        // return k;


    }
}