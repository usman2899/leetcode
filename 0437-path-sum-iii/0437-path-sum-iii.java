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
    public int pathSum(TreeNode root, int targetSum) {
        List<Long> path = new ArrayList<>();
        int[] res = new int[1];
        traverse(root, path, res, targetSum);
        return res[0];
    }
    
    void traverse(TreeNode root, List<Long> path, int[] res, int targetSum) {
        if (root == null) return;
        
        path.add((long)root.val);
        
        long sum = 0;
        
        int len = path.size();
        for (int i = len - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == targetSum) {
                res[0]++;
            }
        }
        
        traverse(root.left, path, res, targetSum);
        traverse(root.right, path, res, targetSum);
        path.remove(len-1);
    }
}