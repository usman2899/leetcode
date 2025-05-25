class Solution {
    Set<Integer> visitedIndices;
    Set<String> permutations;
    List<List<Integer>> list;

    public List<List<Integer>> permuteUnique(int[] nums) {
        visitedIndices = new HashSet<>();
        permutations = new HashSet<>();
        list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(new ArrayList<>(), nums);
        return list;
        }


    private void backtrack(List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            String permutationString = permToString(tempList);
            if (!permutations.contains(permutationString)) {
                list.add(new ArrayList<>(tempList));
                permutations.add(permutationString);
            }
            return;
        } else{
            for(int i = 0; i < nums.length; i++){
                if(visitedIndices.contains(i)) continue; 
                visitedIndices.add(i);
                tempList.add(nums[i]);
                backtrack(tempList, nums);
                tempList.remove(tempList.size() - 1);
                visitedIndices.remove(i);
            }
        }
    }

    private String permToString (List<Integer> tempList) {
        StringBuilder sb = new StringBuilder();
        for (Integer num: tempList) {
            sb.append(String.valueOf(num));
            sb.append("->");
        }
        return sb.toString();
    }
}
