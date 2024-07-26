class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for (int i = 0; i < nums2.length; i++) {
        //     nums1[m + i] = nums2[i]; 
        // }
        // Arrays.sort(nums1);

        // int[] copy1 = Arrays.copyOf(nums1, m+n);
        int[] copy1 = nums1.clone();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (copy1[i] <= nums2[j]) {
                nums1[k] = copy1[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < m) {
            nums1[k] = copy1[i];
            i++;
            k++;
        }
        while (j < n) {
            nums1[k] = nums2[j];
            j++;
            k++;
        }
    }
}