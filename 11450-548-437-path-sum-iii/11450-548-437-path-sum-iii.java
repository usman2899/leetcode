/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int result = 0;
    Map<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, 0, targetSum);
        return result;
    }

    void dfs(TreeNode root, long currSum, int targetSum) {
        if (root == null) {
            return;
        }
        currSum += root.val;

        result += map.getOrDefault(currSum - targetSum, 0);

        if (currSum == targetSum) result++;

        map.put(currSum, map.getOrDefault(currSum, 0) +1);

        dfs (root.left, currSum, targetSum);
        dfs (root.right, currSum, targetSum);

        map.put(currSum, map.get(currSum)-1);
    }
}