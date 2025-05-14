class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; ++i) {
            pairs[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long sum = 0, res = 0;

        for (int[] pair : pairs) {
            int currNum1 = pair[1];  
            int currNum2 = pair[0];  

            pq.add(currNum1);    
            sum += currNum1;     

            if (pq.size() > k) {
                sum -= pq.poll();   
            }

            if (pq.size() == k) {
                res = Math.max(res, sum * currNum2);  
            }
        }

        return res;  
    }
}


//Terrible approach
// class Solution {
//     public long maxScore(int[] nums1, int[] nums2, int k) {
//         int len = nums1.length;
//         long[] product = new long[len];

//         for (int i = 0; i < len; i++) {
//             product[i] = nums1[i]*nums2[i];
//         }

//         PriorityQueue<Integer> pq = new PriorityQueue<>
//         ((a,b) -> Long.compare(product[b], product[a]));
//         for (int i = 0; i < len; i++) {
//             pq.offer(i);
//         }

//         int multipleNum1 = 0;
//         int multipleNum2 = Integer.MAX_VALUE;

//         for (int i = 0; i < k; i++) {
//             int index = pq.poll();
//             multipleNum1 += nums1[index];
//             multipleNum2 = Math.min(multipleNum2, nums2[index]);

//         }
//         return multipleNum1*multipleNum2;

//     }
// }