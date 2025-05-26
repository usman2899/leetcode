class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        recursion(candidates, visited, new ArrayList<>(), target, 0);
        return res;
    }

    void recursion(int[] candidates, boolean[] visited, List<Integer> tempList, int target, int start){
        if (target <= 0) {
            if (target == 0) {
                List<Integer> combination = new ArrayList<>();
                combination.addAll(tempList);
                res.add(combination);
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            tempList.add(candidates[i]);
            recursion(candidates, visited, tempList, target-candidates[i], i+1);
            visited[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }

}