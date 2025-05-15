class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        /*
        Set of arr2 elemetns
        HashMap of word and freq arr1:
        if found in set put in map and change to 0 else leave
        two pointers arr1, arr2
        keep filling arr1
        end of arr2, sort remaining array and insert
        */
        
        Set<Integer> set = new HashSet<>();
        for (int num: arr2) {
            set.add(num);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0;  i< arr1.length; i++) {
            int num = arr1[i];
            if (set.contains(num)) {
                map.put(num, map.getOrDefault(num, 0) +1);
                arr1[i] = 0;
            }
        }
        
        Arrays.sort(arr1);
        
        int pointer = 0;
        
        for (int num: arr2) {
            while(map.get(num) > 0) {
                arr1[pointer++] = num;
                map.put(num, map.get(num)-1);
            }
        }
        return arr1;
    }
}
