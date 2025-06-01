class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        // for (int i = 0; i < nums.length; i++) {
        //     if (i > 0 && nums[i] == nums[i-1]) continue;
        //     backtrack(nums, new ArrayList<>(), i);
        // }
        backtrack(nums, new ArrayList<>(), 0, visited);
        return res;
    }

    void backtrack(int[] nums, List<Integer> curr, int start, boolean[] visited) {
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && visited[i - 1] == false) continue;
            visited[i] = true;
            curr.add(nums[i]);
            res.add(new ArrayList<>(curr));
            backtrack(nums, curr, i+1, visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}