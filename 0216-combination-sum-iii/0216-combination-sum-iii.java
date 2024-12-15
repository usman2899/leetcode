class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, k, n, new ArrayList<>());
        return result;
    }
    
    public void backtrack(int start, int k, int n, List<Integer> curr) {
        if (curr.size() == k) {
            if (n == 0) {
                List<Integer> ans = new ArrayList<>(curr);
                result.add(ans);
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            curr.add(i);
            backtrack(i+1, k, n-i, curr);
            curr.remove(curr.size()-1);
        }
    }   
}