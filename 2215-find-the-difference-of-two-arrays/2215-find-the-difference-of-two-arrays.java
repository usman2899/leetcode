class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Map<Integer, Integer> map3 = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i],0);
            map2.put(nums1[i],0);
        }
        for (int i = 0; i < nums2.length; i++) {
            map1.remove(nums2[i]);
            if (!map2.containsKey(nums2[i]) && !map3.containsKey(nums2[i])) {
                map3.put(nums2[i], 0);
                res2.add(nums2[i]);
            }
        }
        for (Integer i: map1.keySet()) {
            res1.add(i);
        }
        // for (Integer i: map3.keySet()) {
        //     res2.add(i);
        // }
        result.add(res1);
        result.add(res2);
        return result;

    }
}