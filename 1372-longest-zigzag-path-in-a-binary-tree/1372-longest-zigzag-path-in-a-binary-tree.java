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
    int maxZigzag = 0;
    
    public int longestZigZag(TreeNode root) {
        traverse(root.left, 1, 1);
        traverse(root.right, 0, 1);
        return maxZigzag;
    }
    
    void traverse(TreeNode root, int left, int currZigzag) {
        if (root == null) return;
        maxZigzag = Math.max(maxZigzag, currZigzag);
        if (left == 1) {
            traverse(root.right, 0, currZigzag + 1);
            traverse(root.left, 1, 1);
        } else {
            traverse(root.right, 0, 1);
            traverse(root.left, 1, currZigzag + 1);
        }
    }
    
}