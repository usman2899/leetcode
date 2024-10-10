class Solution {
    public int singleNumber(int[] nums) {
        //XOR
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        return res;
        
//         //Set
//         Set<Integer> res = new HashSet<>();
        
//         for (int num: nums) {
//             if (res.contains(num)) {
//                 res.remove(num);
//             } else{
//                 res.add(num);
//             }
//         }
//         for (int element: res) {
//             return element;
//         }
//         return 0;
    }
}