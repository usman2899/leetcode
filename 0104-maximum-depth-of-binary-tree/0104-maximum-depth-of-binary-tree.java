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
    Integer max = 0;
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return max;
    }

    void dfs (TreeNode root, Integer curr) {
        if (root == null) {
            max = Math.max(curr,max);
            return;
        }
        dfs (root.left, curr+1);
        dfs (root.right, curr+1);
    }
}