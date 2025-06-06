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
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return validateBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean validateBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if ((root.val >= max ) || (root.val <= min)) return false;
        return (validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max));
    }
}